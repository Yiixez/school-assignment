package com.example.fontysassignment.interfaces;

import java.time.LocalTime;

public interface ClockInterface {

    default LocalTime getTime() { return LocalTime.now(); }
    void setClock();

}
