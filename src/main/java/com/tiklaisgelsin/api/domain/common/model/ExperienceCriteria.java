package com.tiklaisgelsin.api.domain.common.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ExperienceCriteria implements Criteria {
    private int minimumYears;
    private List<String> titles;

    @Override
    public int getPoint(Seeker seeker) {
        long employedMonths = 0;

        for (Experience iter : seeker.getExperiences()) {
            for (String title : titles) {
                if (iter.getPosition().toLowerCase().compareTo(title.toLowerCase()) == 0) {
                    employedMonths += iter.getMonthsEmployed();
                    break;
                }
            }
        }

        return (int) ((float) employedMonths / (float) (minimumYears * 12) * 100) % 101;
    }
}
