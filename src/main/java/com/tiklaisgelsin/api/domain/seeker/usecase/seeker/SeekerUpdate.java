package com.tiklaisgelsin.api.domain.seeker.usecase.seeker;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class SeekerUpdate implements UseCase {
    private Long seekerId;
    private String name;
    private String surname;
    private String email;
    private String avatar;
    private String biography;
    private LocalDate birth;
}
