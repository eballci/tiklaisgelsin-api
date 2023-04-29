package com.tiklaisgelsin.api.domain.seeker.model;

public enum SubmissionStatus {
    IDLE(1),
    ACCEPTED(3),
    REFUSED(4);

    private final int level;

    SubmissionStatus(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public static SubmissionStatus generate(int level) {
        try {
            if (level == 1) return IDLE;
            if (level == 3) return ACCEPTED;
            if (level == 4) return REFUSED;
            throw new RuntimeException("The provided level is not satisfactory");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
