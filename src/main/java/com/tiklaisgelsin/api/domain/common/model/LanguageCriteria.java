package com.tiklaisgelsin.api.domain.common.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LanguageCriteria implements Criteria {

    private String expectedLanguage;

    private LanguageLevel expectedLevel;

    @Override
    public int getPoint(Seeker seeker) {
        for (Language iter : seeker.getLanguages()) {
            if (iter.getName().compareTo(expectedLanguage) == 0) {
                return (iter.getLevel().getLevel() / expectedLevel.getLevel() * 100) % 101;
            }
        }

        return 0;
    }
}
