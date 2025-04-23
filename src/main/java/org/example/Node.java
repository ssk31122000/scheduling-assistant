package org.example;

public class Node {

    private TimeSlot timeSlot;
    private Node left;
    private Node right;
    private int height;

    public Node(TimeSlot timeSlot, Node left, Node right, int height) {
        this.timeSlot = timeSlot;
        this.left = left;
        this.right = right;
        this.height = height;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
