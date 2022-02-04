package com.example.demo.type;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlatformTypeTest {

    @Test
    void descOf() {
        assertEquals(PlatformType.MAC, PlatformType.descOf("mac"));
        assertEquals(PlatformType.LINUX, PlatformType.descOf("liNux"));
        assertEquals(PlatformType.WINDOWS, PlatformType.descOf("WINDOWS"));
    }
}