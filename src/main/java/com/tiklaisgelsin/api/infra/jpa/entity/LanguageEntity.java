package com.tiklaisgelsin.api.infra.jpa.entity;

import com.tiklaisgelsin.api.domain.common.model.Language;
import com.tiklaisgelsin.api.domain.common.model.LanguageLevel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "language")
public class LanguageEntity extends AbstractEntity {

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private int level;

    @ManyToOne
    @JoinColumn(name = "seeker_id")
    private SeekerEntity seeker;

    public Language toModel() {
        return Language.builder()
                .id(getId())
                .name(language)
                .level(LanguageLevel.generate(level))
                .build();
    }
}
