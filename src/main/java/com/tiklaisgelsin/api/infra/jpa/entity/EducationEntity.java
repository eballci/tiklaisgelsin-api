package com.tiklaisgelsin.api.infra.jpa.entity;

import com.tiklaisgelsin.api.domain.common.model.Education;
import com.tiklaisgelsin.api.domain.common.model.EducationLevel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "education")
public class EducationEntity extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "seeker_id")
    private SeekerEntity seeker;

    @Column(nullable = false)
    private String study;

    @Column(nullable = false)
    private String institution;

    @Column
    private String description;

    @Column
    private float GPA;

    @Column(nullable = false)
    private LocalDate start;

    @Column
    private LocalDate end;

    @Column
    private int level;

    public Education toModel() {
        return Education.builder()
                .id(getId())
                .study(study)
                .institution(institution)
                .description(description)
                .GPA(GPA)
                .start(start)
                .end(end)
                .educationLevel(EducationLevel.generate(level))
                .build();
    }
}
