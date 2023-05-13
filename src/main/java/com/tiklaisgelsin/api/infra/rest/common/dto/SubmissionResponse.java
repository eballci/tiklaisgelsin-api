package com.tiklaisgelsin.api.infra.rest.common.dto;

import com.tiklaisgelsin.api.domain.common.model.Submission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubmissionResponse {
    private Long id;
    private Long positionId;
    private Long seekerId;
    private int status;

    public static SubmissionResponse fromModel(Submission submission) {
        return SubmissionResponse.builder()
                .id(submission.getId())
                .positionId(submission.getPositionId())
                .seekerId(submission.getSeekerId())
                .status(submission.getSubmissionStatus().getLevel())
                .build();
    }
}
