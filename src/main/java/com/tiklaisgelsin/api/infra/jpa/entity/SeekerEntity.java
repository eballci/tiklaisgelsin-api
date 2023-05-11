package com.tiklaisgelsin.api.infra.jpa.entity;

import com.tiklaisgelsin.api.domain.common.model.Seeker;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "seeker")
public class SeekerEntity extends AbstractEntity {

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String biography;

    @Column
    private LocalDate birth;

    @OneToOne(mappedBy = "seeker")
    private SeekerAvatarEntity avatar;

    @OneToMany(mappedBy = "seeker", cascade = CascadeType.ALL)
    private List<EducationEntity> educations = new LinkedList<>();

    @OneToMany(mappedBy = "seeker", cascade = CascadeType.ALL)
    private List<ExperienceEntity> experiences = new LinkedList<>();

    @OneToMany(mappedBy = "seeker", cascade = CascadeType.ALL)
    private List<LanguageEntity> languages = new LinkedList<>();

    @OneToMany(mappedBy = "seeker", cascade = CascadeType.ALL)
    private List<PhoneEntity> phones = new LinkedList<>();

    @OneToMany(mappedBy = "seeker", cascade = CascadeType.ALL)
    private List<OfferEntity> offers = new LinkedList<>();

    @OneToMany(mappedBy = "seeker", cascade = CascadeType.ALL)
    private List<SubmissionEntity> submissions = new LinkedList<>();

    @OneToMany(mappedBy = "seeker", cascade = CascadeType.ALL)
    private List<SuggestionEntity> suggestions = new LinkedList<>();

    public Seeker toModel() {
        return Seeker.builder()
                .id(getId())
                .avatar(Optional.ofNullable(avatar).map(SeekerAvatarEntity::getFile).orElse(""))
                .name(name)
                .surname(surname)
                .email(email)
                .biography(biography)
                .birth(birth)
                .educations(educations.stream().map(EducationEntity::toModel).toList())
                .experiences(experiences.stream().map(ExperienceEntity::toModel).toList())
                .languages(languages.stream().map(LanguageEntity::toModel).toList())
                .phones(phones.stream().map(PhoneEntity::toModel).toList())
                .offers(offers.stream().map(OfferEntity::toModel).toList())
                .submissions(submissions.stream().map(SubmissionEntity::toModel).toList())
                .positionSuggestions(
                        suggestions.stream()
                                .map(SuggestionEntity::toPositionSuggestionModel)
                                .collect(Collectors.toCollection(TreeSet::new))
                )
                .build();
    }
}
