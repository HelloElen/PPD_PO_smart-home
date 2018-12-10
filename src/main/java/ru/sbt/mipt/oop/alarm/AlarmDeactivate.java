package ru.sbt.mipt.oop.alarm;
import ru.sbt.mipt.oop.sensors.SensorEvent;

public class AlarmDeactivate implements AlarmState {
    private final Alarm alarm;

    public AlarmDeactivate(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void switchOn() {
        alarm.setState(new AlarmActivate(alarm));
    }

    @Override
    public void switchOff() {

    }

    @Override
    public void enterPassword(String password) {}

    @Override
    public void startRing() {

    }

    @Override
    public void onSensorEvent(SensorEvent event) {}

    @Override
    public AlarmStateEnum getState() {
        return AlarmStateEnum.OFF;
    }
}
