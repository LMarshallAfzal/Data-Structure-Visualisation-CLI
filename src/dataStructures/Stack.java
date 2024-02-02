package dataStructures;

/**
 * Implementation of a stack data structure.
 *
 * <p>A stack is a last-in, first-out (LIFO) data structure where elements are added and removed
 * from the top of the stack. This implementation provides methods for adding, removing, traversing,
 * and obtaining he visual representation of the stack.</p>
 */
public class Stack extends DataStructure {
    private Element top;

    /**
     * Inner class representing a node in the stack.
     */
    private static class Element {
        int value;
        Element next;

        Element(int value) {
            this.value = value;
            this.next = null;
        }
    }

    /**
     * Adds a new element with the specific value to the top of the stack.
     * This operation is equivalent to pushing an element onto the stack.
     *
     * <p>This method creates a new element with the given value and paces it at the
     * top of the stack. The newly added element becomes the new top of the stack,
     * and the next reference of the new element is set to the previous top of the stack.
     * The value of the added node is printed to the console, indicating the successful
     * push operation.</p>
     *
     * @param value The value to be added to the stack.
     */
    @Override
    public void addNode(int value) {
    // Push Operation: Add a new node to the top of the stack
    Element newNode = new Element(value);
    newNode.next = top;
    top = newNode;
    System.out.println("Pushed element onto the stack: " + value);
    }

    /**
     * Removes the top element from the stack.
     * This operation is equivalent to popping an element from the stack.
     *
     * <p>If the stack is empty. a message is printed indicating that the stack is empty
     * and the operation cannot be performed. Otherwise, the top element is removed from
     * the stack, and a message is printed indicating the successful pop operation.</p>
     *
     * @param value The value being removed from the stack.
     */
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

    /**
     * Displays the elements in the stack.
     *
     * <p>This method traverses the stack from the top to the bottom and prints each
     * element's value to the console. If the stack is empty, it prints a message
     * indicating that the stack is empty.</p>
     */
    @Override
    public void traverse() {
        Element current = top;
        System.out.println("Stack: ");
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    /**
     * Returns the value of the top element without removing it.
     * If the stack is empty, it prints a message indicating that the stack is empty
     * and returns a sentinel value of -1.
     *
     * @return The value of the top element.
     */
    public int peak() {
        if (top == null) {
            System.out.println("Stack is empty. Cannot peak.");
            return -1;
        }
        return top.value;
    }

    /**
     * Gets the visual representation of the stack.
     *
     * <p>This method creates a visual representation of the stack, displaying each element
     * enclosed in square brackets on a new line. The representation is returned as a string.</p>
     *
     * @return The visual representation of the stack.
     */
    @Override
    public String getVisualRepresentation() {
        StringBuilder visualRepresentation = new StringBuilder("");
        Element current = top;

        while (current != null) {
            visualRepresentation.append("[").append(current.value).append("] \n");
            current = current.next;
        }

        return visualRepresentation.toString();
    }
}
