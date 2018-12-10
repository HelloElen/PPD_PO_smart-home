package ru.sbt.mipt.oop.loaders;

import ru.sbt.mipt.oop.alarm.AlarmEventProcessor;
import ru.sbt.mipt.oop.eventProcessors.DoorEventProcessor;
import ru.sbt.mipt.oop.eventProcessors.HallDoorEventProcessor;
import ru.sbt.mipt.oop.eventProcessors.LightsEventProcessor;
import ru.sbt.mipt.oop.components.SmartHome;
import ru.sbt.mipt.oop.observers.EventsManager;

public class EventsLoader {
    public static void runEvents (SmartHome smartHome, EventsManager eventManager) {
        eventManager.addEventProcessor(new LightsEventProcessor());
        eventManager.addEventProcessor(new DoorEventProcessor());
        eventManager.addEventProcessor(new AlarmEventProcessor());
        eventManager.addEventProcessor(new HallDoorEventProcessor());
        eventManager.runEventsCycle(smartHome);
    }
}
