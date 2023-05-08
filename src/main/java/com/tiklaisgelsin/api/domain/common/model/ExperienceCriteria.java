package com.tiklaisgelsin.api.domain.common.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ExperienceCriteria implements Criteria<List<Experience>> {
    private int minimumYears;
    private List<String> titles;

    @Override
    public int getPoint(List<Experience> data) {
        long employedMonths = 0;

        for (Experience iter : data) {
            for (String title : titles) {
                if (iter.getPosition().toLowerCase().compareTo(title.toLowerCase()) == 0) {
                    employedMonths += iter.getMonthsEmployed();
                    break;
                }
            }
        }

        return (int) ((employedMonths / minimumYears * 12 * 100) % 101);
    }
}