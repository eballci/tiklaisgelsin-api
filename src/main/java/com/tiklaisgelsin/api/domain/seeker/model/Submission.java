package com.tiklaisgelsin.api.domain.seeker.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Submission {
    private Long id;
    private Position position;
    private SubmissionStatus submissionStatus;
    private LocalDateTime createdAt;
}
