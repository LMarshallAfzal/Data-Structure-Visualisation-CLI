package dataStructures;

public class Stack extends DataStructure {
    private Node top;

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    @Override
    public void addNode(int value) {
    // Push Operation: Add a new node to the top of the stack
    Node newNode = new Node(value);
    newNode.next = top;
    top = newNode;
    System.out.println("Pushed element onto the stack: " + value);
    }

    @Override
    public void removeNode(int value) {
        // Pop Operation: Remove the top node from the stack
        if (top == null) {
            System.out.println("Stack is empty. Cannot pop.");
            return;
        }

        System.out.println("Popped element from the stack: " + top.value);
        top = top.next;

    }

    @Override
    public void traverse() {
        Node current = top;
        System.out.println("Stack: ");
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int peak() {
        if (top == null) {
            System.out.println("Stack is empty. Cannot peak.");
            return -1;
        }
        return top.value;
    }

    @Override
    public String getVisualRepresentation() {
        StringBuilder visualRepresentation = new StringBuilder("");
        Node current = top;

        while (current != null) {
            visualRepresentation.append("[").append(current.value).append("] \n");
            current = current.next;
        }

        return visualRepresentation.toString();
    }
}
