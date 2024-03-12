package com.example.fontysassignment.clock;

import javafx.fxml.FXML;
import javafx.scene.control.Labeled;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javafx.scene.control.Label;

import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AlarmTest {

    Clock clock = new Clock(null);
    Alarm alarm = new Alarm(clock);

    @Test
    void addAlarm() {
        String[] alarmArr = {"10", "20", "30"};
        alarm.addAlarm(alarmArr, null);
        ArrayList<LocalTime> arr = new ArrayList<>();
        arr.add(LocalTime.of(10, 20, 30));
        assertIterableEquals(alarm.getAlarms(), arr);
    }
}