package ru.sbt.mipt.oop.eventProcessors;
import ru.sbt.mipt.oop.components.Door;
import ru.sbt.mipt.oop.components.Room;
import ru.sbt.mipt.oop.sensors.SensorEvent;
import ru.sbt.mipt.oop.components.SmartHome;

import static ru.sbt.mipt.oop.sensors.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.sensors.SensorEventType.DOOR_OPEN;

public class DoorEventProcessor implements EventProcessor {
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (!isDoorEvent(event)) return;
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    if (event.getType() == DOOR_OPEN) {
                       changeDoorState(room, door, true, " was opened.");
                    } else {
                        changeDoorState(room, door, false, " was closed.");
                    }
                }
            }
        }
    }
    private void changeDoorState(Room room, Door door, boolean opened, String s) {
        door.setOpen(opened);
        System.out.println("Door " + door.getId() + " in room " + room.getName() + s);
    }
    private boolean isDoorEvent(SensorEvent event) {
        return event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED;
    }

}
