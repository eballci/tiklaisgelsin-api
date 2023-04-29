package com.tiklaisgelsin.api.domain.seeker.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SeekerForVisitors {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String avatar;
    private String biography;
    private List<Language> languages;
    private List<Experience> experiences;
}
