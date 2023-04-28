package com.tiklaisgelsin.api.domain.seeker.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

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
}
