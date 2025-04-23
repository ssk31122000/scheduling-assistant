package org.example;

public class SelfBalancingTree {

    public static boolean traverseBST(Node node, TimeSlot ts){
        if(node == null){
            return true;
        }
        if(node.getTimeSlot().getEndTime().isAfter(ts.getEndTime())){
            if(node.getTimeSlot().getStartTime().isBefore(ts.getEndTime()) || node.getTimeSlot().getStartTime().isEqual(ts.getEndTime())){
                return false;
            }
            return traverseBST(node.getLeft(),ts);
        }else{
            if(node.getTimeSlot().getEndTime().isAfter(ts.getStartTime()) || node.getTimeSlot().getEndTime().isEqual(ts.getStartTime())){
                return false;
            }
            return traverseBST(node.getRight(), ts);
        }
    }

    public static Node addSlot(Node node, TimeSlot ts){
        if(node == null){
            return new Node(ts, null, null, 1);
        }

        if(node.getTimeSlot().getEndTime().isAfter(ts.getEndTime())){
            node.setLeft(addSlot(node.getLeft(), ts));
        } else if (node.getTimeSlot().getEndTime().isBefore(ts.getEndTime())) {
            node.setRight(addSlot(node.getRight(), ts));
        }else {
            return node;
        }

        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));

        int balance = getBalance(node);

        if (balance > 1 && ts.getEndTime().isBefore(node.getLeft().getTimeSlot().getEndTime()))
            return rightRotate(node);

        if (balance < -1 && ts.getEndTime().isAfter(node.getRight().getTimeSlot().getEndTime()))
            return leftRotate(node);

        if (balance > 1 && ts.getEndTime().isAfter(node.getLeft().getTimeSlot().getEndTime())) {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }
        if (balance < -1 && ts.getEndTime().isBefore(node.getRight().getTimeSlot().getEndTime())) {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }
        return node;
    }

    static int height(Node node) {
        return node == null ? 0 : node.getHeight();
    }

    static int getBalance(Node node) {
        return node == null ? 0 : height(node.getLeft()) - height(node.getRight());
    }

    static Node rightRotate(Node node) {
        Node rotatedNode = node.getLeft();
        Node temp = rotatedNode.getRight();
        rotatedNode.setRight(node);
        node.setLeft(temp);
        node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
        rotatedNode.setHeight(Math.max(height(rotatedNode.getLeft()), height(rotatedNode.getRight())) + 1);
        return rotatedNode;
    }

    static Node leftRotate(Node node) {
        Node rotatedNode = node.getRight();
        Node temp = rotatedNode.getLeft();
        rotatedNode.setLeft(node);
        node.setRight(temp);
        node.setHeight(Math.max(height(node.getLeft()), height(node.getRight())) + 1);
        rotatedNode.setHeight(Math.max(height(rotatedNode.getLeft()), height(rotatedNode.getRight())) + 1);
        return rotatedNode;
    }


}
