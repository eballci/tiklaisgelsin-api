package com.tiklaisgelsin.api.domain.common.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SeekerSuggestion {
    private Long id;
    private Seeker seeker;
    private Position position;
    private int matchRate;
    private LocalDateTime createdAt;
}
