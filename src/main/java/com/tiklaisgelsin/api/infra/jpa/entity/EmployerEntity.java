package com.tiklaisgelsin.api.infra.jpa.entity;

import com.tiklaisgelsin.api.domain.common.model.Employer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "employer")
public class EmployerEntity extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "employer")
    private EmployerAvatarEntity avatar;

    @Column(columnDefinition = "text")
    private String description;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private int scale;

    @Column
    private String webSite;

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
    private List<PositionEntity> positions = new LinkedList<>();

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
    private List<OfferEntity> offers = new LinkedList<>();

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
    private List<SubmissionEntity> submissions = new LinkedList<>();

    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
    private List<SuggestionEntity> suggestions = new LinkedList<>();

    public Employer toModel() {
        return Employer.builder()
                .id(getId())
                .name(name)
                .avatar(Optional.ofNullable(avatar).map(EmployerAvatarEntity::getFile).orElse(""))
                .description(description)
                .webSite(webSite)
                .email(email)
                .scale(scale)
                .openPositions(positions.stream().map(PositionEntity::toModel).toList())
                .offers(offers.stream().map(OfferEntity::toModel).toList())
                .submissions(submissions.stream().map(SubmissionEntity::toModel).toList())
                .seekerSuggestions(
                        suggestions.stream()
                                .map(SuggestionEntity::toSeekerSuggestionModel)
                                .collect(Collectors.toCollection(TreeSet::new))
                )
                .build();
    }
}
