package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.SensorEventsManager;
import ru.sbt.mipt.oop.components.SmartHome;
import ru.sbt.mipt.oop.eventProcessors.EventProcessor;
import ru.sbt.mipt.oop.observers.EventsManager;
import ru.sbt.mipt.oop.sensors.RandomSensorEventProvider;
import ru.sbt.mipt.oop.sensors.SensorEvent;

import java.util.ArrayList;
import java.util.Collection;

public class EventManagerAdapter implements EventsManager {

    private SensorEventsManager manager;
    private final Collection<EventProcessor> eventProcessors = new ArrayList<>();

    public EventManagerAdapter(SensorEventsManager sensorEventsManager) {
       this.manager = sensorEventsManager;
    }

    @Override
    public void addEventProcessor(EventProcessor eventProcessor) {
        eventProcessors.add(eventProcessor);
    }

    @Override
    public void runEventsCycle(SmartHome smartHome) {
        SensorEvent event = RandomSensorEventProvider.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventProcessor eventProcessor : eventProcessors) {
                eventProcessor.processEvent(smartHome, event);
            }
            event = RandomSensorEventProvider.getNextSensorEvent();
        }
    }
}
