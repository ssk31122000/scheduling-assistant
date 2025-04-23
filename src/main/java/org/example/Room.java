package org.example;

public class Room implements Schedulable{

    private final Integer roomNumber;

    private Node selfBalancingBST;

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                '}';
    }

    public Room(Integer roomNumber) {
        this.roomNumber = roomNumber;
        this.selfBalancingBST = null;
    }

    @Override
    public boolean checkAvailability(TimeSlot timeSlot){
        return SelfBalancingTree.traverseBST(selfBalancingBST, timeSlot);
    }

    @Override
    public void addTimeSlot(TimeSlot timeSlot){
        selfBalancingBST = SelfBalancingTree.addSlot(selfBalancingBST, timeSlot);
        System.out.println("Timeslot : " + timeSlot.getStartTime() + " - " + timeSlot.getEndTime() + "added for room No " + roomNumber);
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }
}
