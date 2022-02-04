package com.example.demo.type;

import java.util.Arrays;

/**
 * @author okato
 */
public enum PlatformType {
    WINDOWS("WINDOWS", 1),
    MAC("MAC", 1),
    LINUX("LINUX", 1),
    ANDROID("ANDROID", 1),
    MOBILE("FIREFOX_OS", 0),
    DEFAULT("NO_DESCRIPTIONS", 0);

    public final String description;

    public final int order;

    PlatformType(String desc, int order) {
        this.description = desc;
        this.order = order;
    }

    public static PlatformType descOf(String str) {
        if (str == null) {
            return DEFAULT;
        }
        final String upperStr = str.toUpperCase().trim();
        return Arrays.stream(PlatformType.values()).filter(v -> v.description.equals(upperStr)).findAny().orElse(DEFAULT);
    }

    @Override
    public String toString() {
        return description;
    }
}
