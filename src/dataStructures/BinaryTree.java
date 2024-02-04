package dataStructures;

/**
 * The BinaryTree class represents a binary tree data structure.
 *
 * <p>This class includes methods for adding and removing nodes, traversing the tree,
 * and generating a visual representation suitable for display in the VisualisationEngine.</p>
 */
public class BinaryTree extends DataStructure {
    private Node root;

    /**
     * The Node class represents a node in the binary tree.
     */
    private static class Node {
        int value;
        Node left;
        Node right;

        /**
         * Constructs a new node with the specified value.
         *
         * @param value The value of the node.
         */
        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * Adds a new node with the specified value to the binary tree.
     *
     * <p>This method adds a new node with the given value to the binary tree
     * while maintaining the binary search tree property.</p>
     *
     * @param value The value to be added to the binary tree.
     */
    @Override
    public void addNode(int value) {
        root = addNodeRecursive(root, value);
        System.out.println("Added node with value: " + value);
    }

    private Node addNodeRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addNodeRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addNodeRecursive(current.right, value);
        }

        return current;
    }

    /**
     * Removes a node with the specified value from the binary tree.
     *
     * <p>This method removes a node with the given valur from the binary tree
     * while maintaining the binary search tree property.</p>
     *
     * @param value The value to be removed from the binary tree.
     */
    @Override
    public void removeNode(int value) {
        root = removeNodeRecursive(root, value);
        System.out.println("Removed node with value: " + value);
    }

    private Node removeNodeRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Node to be deleted found

            // Case 1: Node with only one child or no child
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }

            // Case 2: Node with two children
            current.value = findMinValue(current.right);

            // Delete the in-order successor
            current.right = removeNodeRecursive(current.right, current.value);
        } else if (value < current.value) {
            current.left = removeNodeRecursive(current.left, value);
        } else {
            current.right = removeNodeRecursive(current.right, value);
        }

        return current;
    }

    private int findMinValue(Node node) {
        return node.left == null ? node.value : findMinValue(node.left);
    }

    /**
     * Performs an in-order traversal of the binary tree.
     *
     * <p>This method traverses the binary tree in in-order fashion, printing the values
     * of the nodes as they are visited.</p>
     */
    @Override
    public void traverse() {
        System.out.print("Binary Tree In-order Traversal: ");
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.value + " ");
            inOrderTraversal(node.right);
        }
    }

    /**
     * Gets the visual representation of the binary tree.
     *
     * <p>This method generates a visual representation of the binary tree suitable for display
     * in the VisualisationEngine. The representation includes indentation to represent the
     * hierarchical structure of the tree.</p>
     *
     * @return The visual representation of the binary tree.
     */
    @Override
    public String getVisualRepresentation() {
        return visualRepresentationRecursive(root, 0);
    }

    private String visualRepresentationRecursive(Node node, int depth) {
        StringBuilder visualRepresentation = new StringBuilder();

        if (node != null) {
            for (int i = 0; i < depth; i++) {
                visualRepresentation.append("  ");
            }

            visualRepresentation.append("[").append(node.value).append("]\n");

            visualRepresentation.append(visualRepresentationRecursive(node.left, depth + 1));
            visualRepresentation.append(visualRepresentationRecursive(node.right, depth + 1));
        }

        return visualRepresentation.toString();
    }
}
