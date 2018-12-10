package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.sensors.SensorEvent;

public class AlarmPassword implements AlarmState{
    private final Alarm alarm;

    public AlarmPassword(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void switchOn() {

    }

    @Override
    public void switchOff() {

    }

    @Override
    public void enterPassword(String password) {
        if(alarm.checkPassword(password)) {
            alarm.setState(new AlarmDeactivate(alarm));
        }
        else {
            alarm.setState(new AlarmRing(alarm));
        }
    }

    @Override
    public void startRing() {

    }

    @Override
    public void onSensorEvent(SensorEvent event) {

    }

    @Override
    public AlarmStateEnum getState() {
        return AlarmStateEnum.WAIT_FOR_PASSWORD;
    }
}
