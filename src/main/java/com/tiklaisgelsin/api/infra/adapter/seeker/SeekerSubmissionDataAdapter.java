package com.tiklaisgelsin.api.infra.adapter.seeker;

import com.tiklaisgelsin.api.domain.seeker.port.SeekerSubmissionPort;
import com.tiklaisgelsin.api.domain.seeker.usecase.submission.RemoveSubmission;
import com.tiklaisgelsin.api.infra.jpa.repository.SubmissionJpaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeekerSubmissionDataAdapter implements SeekerSubmissionPort {

    private final EntityManagerFactory entityManagerFactory;
    private final SubmissionJpaRepository repository;

    @Override
    public void removeSubmission(RemoveSubmission removeSubmission) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Query query = em.createQuery("delete from SubmissionEntity se where se.id = :submissionId");
            query.setParameter("submissionId", removeSubmission.getSubmissionId());
            query.executeUpdate();
            tx.commit();
        } catch (RuntimeException ex) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
    }
}
