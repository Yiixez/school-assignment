package com.example.fontysassignment;

import com.example.fontysassignment.clock.Alarm;
import com.example.fontysassignment.clock.Clock;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.format.DateTimeFormatter;

public class Controller {

    private Clock c;
    private Alarm alarm;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

    @FXML
    private Label alarms;
    @FXML
    private TextField alarmText;
    @FXML
    private Label clock;
    @FXML
    private Label errorText;

    @FXML
    private void initialize() {
        c = new Clock(clock);
        alarm = new Alarm(c);
        startTimer();
    }

    public void startTimer() {
        c.setClock();
    }

    @FXML
    protected void addAlarm() {
        String[] test = alarmText.getText().split(":");

        if (test.length != 3) {
            errorText.setText("Wrong text input. [hh:mm:ss]");
            return;
        }

        if (test[0].length() != 2 || test[1].length() != 2 || test[2].length() != 2) {
            errorText.setText("Wrong text input. [hh:mm:ss]");
            return;
        }

        alarm.addAlarm(test, alarms);
        alarm.startAlarmTimer(alarms);
    }
}