package com.tiklaisgelsin.api.infra.adapter.employer;

import com.tiklaisgelsin.api.domain.common.model.Position;
import com.tiklaisgelsin.api.domain.employer.port.PositionPort;
import com.tiklaisgelsin.api.domain.employer.usecase.position.CreatePosition;
import com.tiklaisgelsin.api.domain.employer.usecase.position.DeletePosition;
import com.tiklaisgelsin.api.domain.employer.usecase.position.UpdatePosition;
import com.tiklaisgelsin.api.domain.employer.usecase.position.criteria.CreateCriteria;
import com.tiklaisgelsin.api.infra.adapter.employer.criteria.CriteriaUseCaseManager;
import com.tiklaisgelsin.api.infra.jpa.entity.EmployerEntity;
import com.tiklaisgelsin.api.infra.jpa.entity.PositionEntity;
import com.tiklaisgelsin.api.infra.jpa.repository.EmployerJpaRepository;
import com.tiklaisgelsin.api.infra.jpa.repository.PositionJpaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PositionDataAdapter implements PositionPort {

    private final EntityManagerFactory entityManagerFactory;
    private final EmployerJpaRepository employerJpaRepository;
    private final PositionJpaRepository positionJpaRepository;
    private final List<CriteriaUseCaseManager<? extends CreateCriteria>> criteriaUseCaseManagers;

    @Override
    public Position getPosition(Long id) {
        return positionJpaRepository.findById(id)
                .map(PositionEntity::toModel)
                .orElse(null);
    }

    @Override
    public Position createPosition(CreatePosition createPosition) {
        Optional<EmployerEntity> employer = employerJpaRepository.findById(createPosition.getEmployerId());

        if (employer.isEmpty()) return null;

        PositionEntity position = new PositionEntity();

        position.setTitle(createPosition.getTitle());
        position.setDescription(createPosition.getDescription());
        position.setEmployer(employer.get());

        position = positionJpaRepository.saveAndFlush(position);

        for (CreateCriteria criteria : createPosition.getCriteriaList()) {
            CriteriaUseCaseManager<?> manager = criteriaUseCaseManagers.stream()
                    .filter(m -> m.isUseCaseMyType(criteria.getClass()))
                    .findFirst()
                    .orElseThrow(RuntimeException::new);

            position.getCriteriaList().add(manager.saveCriteria(criteria, position));
        }

        return positionJpaRepository.save(position).toModel();
    }

    @Override
    public void updatePosition(UpdatePosition updatePosition) {
        Optional<PositionEntity> position = positionJpaRepository.findById(updatePosition.getPositionId());

        if (position.isEmpty()) return;

        position.get().setTitle(updatePosition.getTitle());
        position.get().setDescription(updatePosition.getDescription());
        positionJpaRepository.saveAndFlush(position.get());

        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Query query = em.createQuery("delete from CriteriaEntity ce where ce.position.id = :positionId");
            query.setParameter("positionId", position.get().getId());
            query.executeUpdate();
            tx.commit();
        } catch (RuntimeException ex) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }

        for (CreateCriteria criteria : updatePosition.getCriteriaList()) {
            CriteriaUseCaseManager<?> manager = criteriaUseCaseManagers.stream()
                    .filter(m -> m.isUseCaseMyType(criteria.getClass()))
                    .findFirst()
                    .orElseThrow(RuntimeException::new);

            position.get().getCriteriaList().add(manager.saveCriteria(criteria, position.get()));
        }
    }

    @Override
    public void removePosition(DeletePosition deletePosition) {
        positionJpaRepository.deleteById(deletePosition.getPositionId());
    }

    @Override
    public List<Position> getAllPositions() {
        return positionJpaRepository.findAll().stream()
                .map(PositionEntity::toModel)
                .toList();
    }

    @Override
    public boolean checkIfPositionDoesntExist(Long id) {
        return positionJpaRepository.findById(id).isEmpty();
    }
}
