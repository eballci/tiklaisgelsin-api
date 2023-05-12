package com.tiklaisgelsin.api.infra.jpa.entity;

import com.tiklaisgelsin.api.domain.common.model.Offer;
import com.tiklaisgelsin.api.domain.common.model.OfferStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "offer")
public class OfferEntity extends AbstractEntity {

    @Column(nullable = false)
    private int status;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private EmployerEntity employer;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private PositionEntity position;

    @ManyToOne
    @JoinColumn(name = "seeker_id")
    private SeekerEntity seeker;

    public Offer toModel() {
        return Offer.builder()
                .id(getId())
                .seekerId(seeker.getId())
                .positionId(position.getId())
                .offerStatus(OfferStatus.generate(status))
                .build();
    }
}
