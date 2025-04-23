package org.example;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SchedulingAssistant schedulingAssistant = new SchedulingAssistant();
        schedulingAssistant.addEmployee(1);
        schedulingAssistant.addEmployee(2);
        schedulingAssistant.addRoom();

        schedulingAssistant.bookMeeting(new TimeSlot(LocalDateTime.now(), LocalDateTime.now().plusMinutes(30)), List.of(schedulingAssistant.getEmployeeById(1), schedulingAssistant.getEmployeeById(2)));
        schedulingAssistant.bookMeeting(new TimeSlot(LocalDateTime.now(), LocalDateTime.now().plusMinutes(60)), List.of(schedulingAssistant.getEmployeeById(1)));
        schedulingAssistant.bookMeeting(new TimeSlot(LocalDateTime.now().plusMinutes(40), LocalDateTime.now().plusMinutes(60)), List.of(schedulingAssistant.getEmployeeById(1)));
        schedulingAssistant.bookMeeting(new TimeSlot(LocalDateTime.now().plusMinutes(50), LocalDateTime.now().plusMinutes(60)), List.of(schedulingAssistant.getEmployeeById(2)));
    }
}