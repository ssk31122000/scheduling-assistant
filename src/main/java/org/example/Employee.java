package org.example;

public class Employee implements Schedulable {


    private final Integer employeeId;

    private Node selfBalancingBST;

    public Employee(Integer employeeId) {
        this.employeeId = employeeId;
        this.selfBalancingBST = null;
    }

    @Override
    public boolean checkAvailability(TimeSlot timeSlot){
        return SelfBalancingTree.traverseBST(selfBalancingBST, timeSlot);
    }

    @Override
    public void addTimeSlot(TimeSlot timeSlot){
        selfBalancingBST = SelfBalancingTree.addSlot(selfBalancingBST, timeSlot);
        System.out.println("Timeslot : " + timeSlot.getStartTime() + " - " + timeSlot.getEndTime() + "added for Employee " + employeeId);
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                '}';
    }
}
