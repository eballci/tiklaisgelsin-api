package com.tiklaisgelsin.api.domain.common.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EducationCriteria implements Criteria {

    private String study;
    private EducationLevel minEducationLevel;

    @Override
    public int getPoint(Seeker seeker) {
        int point = 0;

        for (Education education : seeker.getEducations()) {
            if (education.getStudy().toLowerCase().compareTo(study.toLowerCase()) == 0) {
                int calc = (education.getEducationLevel().getLevel() / minEducationLevel.getLevel() * 100) % 101;

                if (calc > point) {
                    point = calc;
                }
            }
        }

        return point;
    }
}
