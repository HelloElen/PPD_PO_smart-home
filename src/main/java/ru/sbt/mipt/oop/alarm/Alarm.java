package ru.sbt.mipt.oop.alarm;
import ru.sbt.mipt.oop.sensors.SensorEvent;

public class Alarm {
    private AlarmState state;
    private final String rightPassword;

    public Alarm(String password) {
        this.rightPassword = password;
        state = new AlarmDeactivate(this);
    }

    public void switchOn(){
        state.switchOn();
    }

    public void switchOff() {
        state.switchOff();
    }

    public void enterPassword(String password) {
        state.enterPassword(password);
    }

    public void onSensorEvent(SensorEvent sensorEvent) {
        state.onSensorEvent(sensorEvent);
    }

    public void setState(AlarmState state) {
        this.state = state;
    }

    boolean checkPassword (String password) {
        if(password.equals(rightPassword)) {
            return true;
        }
        else {
            return false;
        }
    }

    public AlarmStateEnum getState() {
        return state.getState();
    }

    public void startRing() {
        state.startRing();
    }
}