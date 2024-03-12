package com.example.fontysassignment.clock;

import javafx.scene.control.Label;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class ClockTest {

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    Clock clock = new Clock(null);

    @Test
    void getTime() {
        assertEquals(dtf.format(LocalTime.now()), dtf.format(clock.getTime()));
    }
}