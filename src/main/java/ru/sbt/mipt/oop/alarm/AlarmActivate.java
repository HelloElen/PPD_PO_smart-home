package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.sensors.SensorEvent;

public class AlarmActivate implements AlarmState {
    private final Alarm alarm;

    public AlarmActivate(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void switchOn() {}

    @Override
    public void switchOff() {}

    @Override
    public void onSensorEvent(SensorEvent event) {
        alarm.setState(new AlarmPassword(alarm));
    }

    @Override
    public void enterPassword(String password) {}

    @Override
    public void startRing() {
    }

    @Override
    public AlarmStateEnum getState() {
        return AlarmStateEnum.ON;
    }
}
