package com.tiklaisgelsin.api.domain.common.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SeekerSuggestion implements Comparable<SeekerSuggestion> {
    private Long id;
    private Long seekerId;
    private Long positionId;
    private int matchRate;
    private LocalDateTime createdAt;

    @Override
    public int compareTo(SeekerSuggestion o) {
        if (-Integer.compare(this.matchRate, o.matchRate) != 0)
            return -Integer.compare(this.matchRate, o.matchRate);
        return -createdAt.compareTo(o.createdAt);
    }
}
