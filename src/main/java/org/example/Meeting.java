package org.example;

import java.util.List;

public class Meeting {
    private final long id;
    private Room room;
    private final List<Employee> employees;
    private TimeSlot timeSlot;

    @Override
    public String toString() {
        return "Meeting{" +
                "id=" + id +
                ", room=" + room +
                ", employees=" + employees +
                ", timeSlot=" + timeSlot +
                '}';
    }

    public Meeting(long id, List<Employee> employees, TimeSlot timeSlot, Room room) {
        this.id = id;
        this.employees = employees;
        this.timeSlot = timeSlot;
        this.room = room;
    }
}
