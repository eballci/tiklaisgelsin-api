package com.tiklaisgelsin.api.infra.jpa.entity.criteria;

import com.tiklaisgelsin.api.domain.common.model.Criteria;
import com.tiklaisgelsin.api.infra.jpa.entity.AbstractEntity;
import com.tiklaisgelsin.api.infra.jpa.entity.PositionEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public abstract class CriteriaEntity extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "position_id")
    private PositionEntity position;

    public abstract Criteria toModel();
}
