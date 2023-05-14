package com.tiklaisgelsin.api.domain.common.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

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
                if (education.getEnd() == null) continue;
                if (LocalDate.now().isBefore(education.getEnd())) continue;

                int calc = (int) ((float) education.getEducationLevel().getLevel() / (float) minEducationLevel.getLevel() * 100) % 101;

                if (calc > point) {
                    point = calc;
                }
            }
        }

        return point;
    }
}
