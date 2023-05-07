package com.tiklaisgelsin.api.domain.common.model;

public enum SubmissionStatus {
    ISSUED(1),
    IDLE(2),
    ACCEPTED(3),
    REFUSED(4);

    private final int level;

    SubmissionStatus(int level) {
        this.level = level;
    }

    public static SubmissionStatus generate(int level) {
        try {
            if (level == 1) return ISSUED;
            if (level == 2) return IDLE;
            if (level == 3) return ACCEPTED;
            if (level == 4) return REFUSED;
            throw new RuntimeException("The provided level is not satisfactory");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public int getLevel() {
        return level;
    }
}
