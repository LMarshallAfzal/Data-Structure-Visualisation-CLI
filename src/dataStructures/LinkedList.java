package dataStructures;

/**
 * Implement of a linked list data structure.
 *
 * <p>A linked list is a linear data structure where elements are stored in nodes, and each node
 * points to the next one. This implementation provides methods for adding, removing, traversing,
 * and obtaining the visual representation of the linked list.</p>
 */
public class LinkedList extends DataStructure {
    private Node head;

    /**
     * Inner class representing a node in the linked list.
     */
    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    /**
     * Adds a new node with the specified value to the end of the linked list.
     *
     * <p>This method creates a new node with the given value and appends it to the end
     * of the linked list. If the linked list is empty, the new node becomes the head.
     * the value of the added node is printed to the console, indicating the successful
     * addition of the node.</p>
     *
     * @param value The value to be added to the linked list.
     */
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

    /**
     * Removes a node with the specified value from the linked list.
     *
     * <p>If the linked list is empty. a message is printed indicating that the linked list
     * is empty and the operation cannot be performed. if the node with the specified value
     * is found, it is removed from the linked list. If the node is the head, the head is
     * updated o the next node. If the node is not found, a message is printed indicating
     * that the node with the specified value was not found in the linked list.</p>
     *
     * @param value The value of the node to be removed from the linked list.
     */
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

    /**
     * Displays the elements in the linked list.
     *
     * <p>This method traverses the linked list and prints each element's value to the console.
     * If the linked list is empty, it prints a message indicating that the linked list is empty.</p>
     */
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

    /**
     * Gets the visual representation of the linked list.
     *
     * <p>This method creates a visual representation of the linked list, displaying each element
     * enclosed in square brackets and connected by arrows. The representation ends with "null" to
     * indicate the end of the linked list.</p>
     *
     * @return The visual representation of the linked list.
     */
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
