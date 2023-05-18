package com.tiklaisgelsin.api.infra.adapter.employer;

import com.tiklaisgelsin.api.domain.employer.port.EmployerOfferPort;
import com.tiklaisgelsin.api.domain.employer.usecase.offer.RemoveOffer;
import com.tiklaisgelsin.api.infra.jpa.repository.OfferJpaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployerOfferDataPort implements EmployerOfferPort {

    private final EntityManagerFactory entityManagerFactory;
    private final OfferJpaRepository repository;

    @Override
    public void remove(RemoveOffer useCase) {
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Query query = em.createQuery("delete from OfferEntity oe where oe.id = :offerId");
            query.setParameter("offerId", useCase.getOfferId());
            query.executeUpdate();
            tx.commit();
        } catch (RuntimeException ex) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
        }
    }
}
