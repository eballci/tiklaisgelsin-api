package com.tiklaisgelsin.api.domain.common.model;

public enum EducationLevel {
    ASSOCIATE(1),
    BACHELORS(2),
    MASTERS(3),
    DOCTORAL(4);

    private final int level;

    EducationLevel(int level) {
        this.level = level;
    }

    public static EducationLevel generate(int level) {
        try {
            if (level == 1) return ASSOCIATE;
            if (level == 2) return BACHELORS;
            if (level == 3) return MASTERS;
            if (level == 4) return DOCTORAL;

            throw new RuntimeException("The given level is not satisfactory.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public int getLevel() {
        return level;
    }
}