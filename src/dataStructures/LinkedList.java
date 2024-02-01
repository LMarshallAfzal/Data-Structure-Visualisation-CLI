package dataStructures;

public class LinkedList extends DataStructure {
    private Node head;

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
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Added node with value: " + value);
    }

    @Override
    public void removeNode(int value) {
        if (head == null) {
            System.out.println("Linked list is empty. Cannot remove node.");
            return;
        }

        if (head.value == value) {
            head = head.next;
            System.out.println("Removed node with value: " + value);
            return;
        }

        Node current = head;
        while (current.next != null && current.next.value != value) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Removed node with value: " + value);
        } else {
            System.out.println("Node with value " + value + " not found in the linked list.");
        }
    }

    @Override
    public void traverse() {
        Node current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    @Override
    public String getVisualRepresentation() {
        StringBuilder visualRepresentation = new StringBuilder();
        Node current = head;
        while (current != null) {
            visualRepresentation.append("[").append(current.value).append("] -> ");
            current = current.next;
        }
        visualRepresentation.append("null");
        return visualRepresentation.toString();
    }
}
