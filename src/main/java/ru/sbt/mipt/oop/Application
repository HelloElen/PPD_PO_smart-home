package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.alarm.AlarmEventProcessor;
import com.coolcompany.smarthome.events.SensorEventsManager;
import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sbt.mipt.oop.components.SmartHome;
import ru.sbt.mipt.oop.loaders.FileSmartHomeLoader;
import ru.sbt.mipt.oop.loaders.SmartHomeLoader;
import ru.sbt.mipt.oop.eventProcessors.DoorEventProcessor;
import ru.sbt.mipt.oop.eventProcessors.HallDoorEventProcessor;
import ru.sbt.mipt.oop.eventProcessors.LightsEventProcessor;
import ru.sbt.mipt.oop.observers.EventsManager;

public class Application {
    private static Logger logger = LogManager.getLogger(Application.class);
    private static SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();
    private static EventsManager eventManager = new EventManagerAdapter(new SensorEventsManager());

    public static void setSmartHomeLoader(SmartHomeLoader smartHomeLoader) {
        Application.smartHomeLoader = smartHomeLoader;
    }

    public static void main(String... args) throws IOException {
        logger.info("Starting configuration...");
        ApplicationContext context = new AnnotationConfigApplicationContext(SmartHomeConfig.class);
        SmartHomeLoader smartHomeLoader = context.getBean(SmartHomeLoader.class);
        EventsManager eventManager = context.getBean(EventsManager.class);

        SmartHome smartHome = smartHomeLoader.loadSmartHome();

        eventManager.addEventProcessor(new LightsEventProcessor());
        eventManager.addEventProcessor(new DoorEventProcessor());
        eventManager.addEventProcessor(new AlarmEventProcessor());
        eventManager.addEventProcessor(new HallDoorEventProcessor());
        eventManager.runEventsCycle(smartHome);
    }

}
