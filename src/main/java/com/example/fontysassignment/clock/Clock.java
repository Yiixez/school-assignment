package com.example.fontysassignment.clock;

import com.example.fontysassignment.interfaces.ClockInterface;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

public class Clock implements ClockInterface {
    private Label clock;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Clock(Label clock) {
        this.clock = clock;
    }

    @Override @FXML
    public void setClock() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> clock.setText(dtf.format(getTime())));
            }
        }, 0, 1000);
    }
}
