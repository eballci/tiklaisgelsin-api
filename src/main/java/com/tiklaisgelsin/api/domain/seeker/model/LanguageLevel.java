package com.tiklaisgelsin.api.domain.seeker.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum LanguageLevel {
    BEGINNER(1),
    INTERMEDIATE(2),
    PROFESSIONAL(3),
    NATIVE(4);

    private final int level;

    LanguageLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public static LanguageLevel generate(int level) {
        try {
            if (level == 1) return BEGINNER;
            if (level == 2) return INTERMEDIATE;
            if (level == 3) return PROFESSIONAL;
            if (level == 4) return NATIVE;

            throw new RuntimeException("The given level is not satisfactory.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
