package com.tiklaisgelsin.api.domain.common.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LanguageCriteria implements Criteria<List<Language>> {

    private Language expectedLanguage;

    @Override
    public int getPoint(List<Language> data) {
        for (Language iter : data) {
            if (iter.getName().compareTo(expectedLanguage.getName()) == 0) {
                return (iter.getLevel().getLevel() / expectedLanguage.getLevel().getLevel() * 100) % 101;
            }
        }

        return 0;
    }
}
