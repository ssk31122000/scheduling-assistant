package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchedulingAssistant {

    private Map<Integer, Employee> employees;
    private List<Room> rooms;
    private List<Meeting> meetings;

    SchedulingAssistant(){
        employees = new HashMap<>();
        rooms = new ArrayList<>();
        meetings = new ArrayList<>();
    }


    public void bookMeeting(TimeSlot timeSlot, List<Employee> meetingEmployees){
        for(Employee employee: meetingEmployees){
            if(!employee.checkAvailability(timeSlot)){
                System.out.println("Cannot schedule this meeting !!!!!, Employee " + employee.getEmployeeId() + " is busy for time slot " + timeSlot);
                return;
            }
        }
        Room meetingRoom = null;
        for(Room room : rooms){
            if(room.checkAvailability(timeSlot)){
                meetingRoom = room;
                break;
            }
        }
        if(meetingRoom == null){
            System.out.println("Cannot schedule this meeting !!!!!, as no room available for time slot " + timeSlot);
            return;
        }
        meetingRoom.addTimeSlot(timeSlot);
        for (Employee employee: meetingEmployees){
            employee.addTimeSlot(timeSlot);
        }
        Meeting meeting = new Meeting(System.currentTimeMillis(), meetingEmployees, timeSlot, meetingRoom);
        meetings.add(meeting);
        System.out.println("Scheduled meeting " + meeting);
    }

    public Employee getEmployeeById(Integer employeeId){
        if(!employees.containsKey(employeeId)){
            throw new IllegalArgumentException("Employee does not exist");
        }
        return employees.get(employeeId);
    }

    public void addEmployee(Integer employeeId){
        if(employees.containsKey(employeeId)){
            throw new IllegalArgumentException("Employee already exists");
        }
        Employee employee = new Employee(employeeId);
        employees.put(employeeId, new Employee(employeeId));
        System.out.println("Added employee " + employee);
    }

    public void addRoom(){
        Room room = new Room(rooms.size() + 1);
        rooms.add(room);
        System.out.println("Added Room " + room);
    }


}
