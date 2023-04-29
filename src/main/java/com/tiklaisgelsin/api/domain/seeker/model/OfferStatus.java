package com.tiklaisgelsin.api.domain.seeker.model;

public enum OfferStatus {
    ISSUED(1),
    IDLE(2),
    ACCEPTED(3),
    REFUSED(4);

    private final int level;

    OfferStatus(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public static OfferStatus generate(int level) {
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
}
