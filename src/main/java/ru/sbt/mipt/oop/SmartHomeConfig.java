package ru.sbt.mipt.oop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.coolcompany.smarthome.events.SensorEventsManager;
import ru.sbt.mipt.oop.loaders.FileSmartHomeLoader;
import ru.sbt.mipt.oop.loaders.SmartHomeLoader;
import ru.sbt.mipt.oop.observers.EventsManager;


@Configuration
public class SmartHomeConfig {

    @Bean
    SmartHomeLoader smartHomeLoader() {
        return new FileSmartHomeLoader();
    }

    @Bean
    EventsManager eventsManager() {
        return new EventManagerAdapter(new SensorEventsManager());
    }

}