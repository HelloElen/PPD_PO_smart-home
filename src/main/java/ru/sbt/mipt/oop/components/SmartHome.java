package ru.sbt.mipt.oop.components;

import ru.sbt.mipt.oop.alarm.Alarm;
import ru.sbt.mipt.oop.components.Light;
import ru.sbt.mipt.oop.components.Room;
import ru.sbt.mipt.oop.sensors.CommandType;
import ru.sbt.mipt.oop.sensors.SensorCommand;
import ru.sbt.mipt.oop.sensors.SensorCommandExecutor;

import java.util.ArrayList;
import java.util.Collection;

public class SmartHome {
    Collection<Room> rooms;
    Alarm alarm;

    public SmartHome() {
        rooms = new ArrayList<>();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void setRooms(Collection<Room> rooms) {
        this.rooms = rooms;
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public void switchOffLights() {
        for (Room room : getRooms()) {
            for (Light light : room.getLights()) {
                light.setOn(false);
                SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                SensorCommandExecutor.executeCommand(command);
            }
        }
    }

    public Alarm getAlarm() {
        return alarm;
    }

}
