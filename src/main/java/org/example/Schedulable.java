package org.example;

public interface Schedulable {
    public boolean checkAvailability(TimeSlot timeSlot);
    public void addTimeSlot(TimeSlot timeSlot);
}
