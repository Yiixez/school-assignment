package com.example.fontysassignment.interfaces;

import javafx.scene.control.Label;

public interface AlarmInterface {
    void addAlarm(String[] alarmArr, Label alarm);
    void setAlarmText(Label alarm);
    void startAlarmTimer(Label alarm);
}
