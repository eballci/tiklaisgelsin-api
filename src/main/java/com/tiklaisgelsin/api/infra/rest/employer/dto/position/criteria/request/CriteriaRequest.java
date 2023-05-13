package com.tiklaisgelsin.api.infra.rest.employer.dto.position.criteria.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CriteriaRequest {

    @NotNull
    @NotBlank
    private String type;

    @NotNull
    @NotBlank
    private Map<String, Object> data;
}
