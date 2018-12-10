package ru.sbt.mipt.oop;
import org.junit.Test;

import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.alarm.AlarmStateEnum;
import ru.sbt.mipt.oop.sensors.SensorEvent;
import ru.sbt.mipt.oop.sensors.SensorEventType;

import static org.junit.Assert.*;


public class AlarmTest {

    public SensorEvent getSensorEvent() {
        return new SensorEvent(SensorEventType.DOOR_OPEN, "0001");
    }

    @Test
    public void testStateOn(){
        Alarm alarm = new Alarm("0001");
        alarm.switchOn();
        AlarmStateEnum actual = alarm.getState();
        AlarmStateEnum expected = AlarmStateEnum.ON;
        assertEquals(expected, actual);
    }

    @Test
    public void testStateOff(){
        Alarm alarm = new Alarm("0001");
        AlarmStateEnum actual = alarm.getState();
        AlarmStateEnum expected = AlarmStateEnum.OFF;
        assertEquals(expected, actual);
    }

    @Test
    public void testStateWaitForPassword(){
        Alarm alarm = new Alarm("0001");
        alarm.switchOn();
        SensorEvent sensorEvent = getSensorEvent();
        alarm.onSensorEvent(sensorEvent);
        AlarmStateEnum actual = alarm.getState();
        AlarmStateEnum expected = AlarmStateEnum.WAIT_FOR_PASSWORD;
        assertEquals(expected, actual);
    }

    @Test
    public void testStateRing(){
        Alarm alarm = new Alarm("0001");
        alarm.switchOn();
        SensorEvent sensorEvent = getSensorEvent();
        alarm.onSensorEvent(sensorEvent);
        alarm.enterPassword("1111");
        AlarmStateEnum actual = alarm.getState();
        AlarmStateEnum expected = AlarmStateEnum.RING;
        assertEquals(expected, actual);
    }


}
