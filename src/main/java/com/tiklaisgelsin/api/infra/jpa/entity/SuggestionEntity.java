package com.tiklaisgelsin.api.infra.jpa.entity;

import com.tiklaisgelsin.api.domain.common.model.PositionSuggestion;
import com.tiklaisgelsin.api.domain.common.model.SeekerSuggestion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "suggestion")
public class SuggestionEntity extends AbstractEntity {

    @Column(nullable = false)
    private int matchRate;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private EmployerEntity employer;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private PositionEntity position;

    @ManyToOne
    @JoinColumn(name = "seeker_id")
    private SeekerEntity seeker;

    public PositionSuggestion toPositionSuggestionModel() {
        return PositionSuggestion.builder()
                .id(getId())
                .positionId(position.getId())
                .matchRate(matchRate)
                .createdAt(getCreatedAt())
                .build();
    }

    public SeekerSuggestion toSeekerSuggestionModel() {
        return SeekerSuggestion.builder()
                .id(getId())
                .seekerId(seeker.getId())
                .positionId(position.getId())
                .matchRate(matchRate)
                .createdAt(getCreatedAt())
                .build();
    }
}
