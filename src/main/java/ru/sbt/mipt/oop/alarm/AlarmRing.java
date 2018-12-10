package ru.sbt.mipt.oop.alarm;
import ru.sbt.mipt.oop.sensors.SensorEvent;

public class AlarmRing implements AlarmState{
    private final Alarm alarm;

    public AlarmRing(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void switchOn() {

    }

    @Override
    public void switchOff() {
        alarm.setState(new AlarmDeactivate(alarm));
    }

    @Override
    public void enterPassword(String password) {

    }

    @Override
    public void startRing() {
        alarm.setState(new AlarmRing(alarm));
        System.out.println("Sending sms");
    }

    @Override
    public void onSensorEvent(SensorEvent event) {

    }

    @Override
    public AlarmStateEnum getState() {
        return AlarmStateEnum.RING;
    }
}
