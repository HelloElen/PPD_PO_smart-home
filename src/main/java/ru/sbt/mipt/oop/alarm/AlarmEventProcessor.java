package ru.sbt.mipt.oop.alarm;

import ru.sbt.mipt.oop.eventProcessors.EventProcessor;
import ru.sbt.mipt.oop.sensors.SensorEvent;
import ru.sbt.mipt.oop.components.SmartHome;

import static ru.sbt.mipt.oop.sensors.SensorEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.sensors.SensorEventType.ALARM_DEACTIVATE;
public class AlarmEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if(!isAlarmEvent(event)) return;
        //событие от сигнализации
        if(event.getType() == ALARM_ACTIVATE) {
            smartHome.getAlarm().switchOn();
        }
        else {
            smartHome.getAlarm().switchOff();
        }
    }
    private boolean isAlarmEvent(SensorEvent event) {
        return event.getType() == ALARM_ACTIVATE || event.getType() == ALARM_DEACTIVATE;
    }
}