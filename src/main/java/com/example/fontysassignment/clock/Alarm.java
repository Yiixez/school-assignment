package com.example.fontysassignment.clock;

import com.example.fontysassignment.interfaces.AlarmInterface;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import lombok.Getter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Alarm implements AlarmInterface {
    @Getter
    private ArrayList<LocalTime> alarms = new ArrayList<>();

    private final Clock clock;
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
    private final Timer timer = new Timer();
    private boolean isTimerActive = false;

    public Alarm(Clock clock) {
        this.clock = clock;
    }

    @Override
    public void addAlarm(String[] alarmArr, Label alarm) {
        LocalTime time = LocalTime.of(Integer.parseInt(alarmArr[0]), Integer.parseInt(alarmArr[1]), Integer.parseInt(alarmArr[2]));
        alarms.add(time);
        setAlarmText(alarm);
    }

    @Override
    public void setAlarmText(Label alarm) {
        if (alarm == null) {
            return;
        }

        if (alarms.isEmpty()) {
            alarm.setText("None");
            return;
        }

        ArrayList<String> text = new ArrayList<>();
        for (LocalTime time : alarms) {
            text.add(dtf.format(time));
        }

        alarm.setText(text.toString());
    }

    @Override
    public void startAlarmTimer(Label alarm) {
        if (isTimerActive) {
            return;
        }

        isTimerActive = true;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    if (alarms.isEmpty()) {
                        isTimerActive = false;
                        setAlarmText(alarm);
                        cancel();
                        return;
                    }

                    for (LocalTime time : new ArrayList<>(alarms)) {
                        if (dtf.format(clock.getTime()).equals(dtf.format(time))) {
                            Alert alert = new Alert(AlertType.WARNING);
                            alert.setContentText("Alarm!");
                            alert.show();
                            alarms.remove(time);
                            setAlarmText(alarm);
                        }
                    }
                });
            }
        }, 0, 1000);
    }
}
