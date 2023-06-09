package com.tiklaisgelsin.api.domain.common.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.SortedSet;

@Data
@Builder
public class Seeker {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String avatar;
    private String biography;
    private LocalDate birth;
    private List<Phone> phones;
    private List<Language> languages;
    private List<Experience> experiences;
    private List<Education> educations;
    private List<Offer> offers;
    private List<Submission> submissions;
    private SortedSet<PositionSuggestion> positionSuggestions;
}
