package com.tiklaisgelsin.api.domain.seeker.usecase.seeker;

import com.tiklaisgelsin.api.domain.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class SeekerCreate implements UseCase {
    private String name;
    private String surname;
    private String email;
    private String password;
    private LocalDate birth;
}
