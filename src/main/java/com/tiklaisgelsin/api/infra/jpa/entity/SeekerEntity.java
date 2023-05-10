package com.tiklaisgelsin.api.infra.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "seeker")
public class SeekerEntity extends AbstractEntity {

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
}
