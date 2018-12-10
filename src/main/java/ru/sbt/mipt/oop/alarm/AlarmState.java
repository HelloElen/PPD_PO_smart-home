package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.sensors.SensorEvent;

public interface AlarmState {
    void switchOn();
    void switchOff();
    void enterPassword(String password);
    void startRing();
    void onSensorEvent(SensorEvent event);
    AlarmStateEnum getState();}
