package com.tiklaisgelsin.api.infra.jpa.entity;

import com.tiklaisgelsin.api.domain.common.model.Submission;
import com.tiklaisgelsin.api.domain.common.model.SubmissionStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "submission")
public class SubmissionEntity extends AbstractEntity {

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

    public Submission toModel() {
        return Submission.builder()
                .id(getId())
                .seekerId(seeker.getId())
                .position(position.toModel())
                .submissionStatus(SubmissionStatus.generate(status))
                .createdAt(getCreatedAt())
                .build();
    }
}
