package visualisation;

import dataStructures.DataStructure;

/**
 * The VisualisationEngine class manages the visualization of various data structures.
 *
 * <p>This class is responsible for displaying the visual representation of the current data structure.
 * It supports setting a new data structure, getting the current data structure, displaying the visualization,
 * and traversing the data structure while updating the visualization during traversal.</p>
 */
public class VisualisationEngine {
    private DataStructure dataStructure;

    /**
     * Constructs a VisualisationEngine with the specified initial data structure.
     *
     * @param initialDataStructure The initial data structure to be visualized.
     */
    public VisualisationEngine(DataStructure initialDataStructure) {
        this.dataStructure = initialDataStructure;
    }

    /**
     * Sets a new data structure to be visualized.
     *
     * @param newDataStructure The new data structure to be set for visualization.
     */
    public void setDataStructure(DataStructure newDataStructure) {
        this.dataStructure = newDataStructure;
    }

    /**
     * Gets the current data structure being visualized.
     *
     * @return The current data structure.
     */
    public DataStructure getDataStructure() {
        return dataStructure;
    }

    /**
     * Displays the visual representation of the current data structure.
     *
     * <p>This method retrieves the visual representation of the current data structure
     * and prints it to the console with appropriate formatting.</p>
     */
    public void displayVisualisation() {
        String visualRepresentation = dataStructure.getVisualRepresentation();

        System.out.println();
        System.out.println(visualRepresentation);
        System.out.println();
    }

    /**
     * Traverses the current data structure and updates the visualization during traversal.
     *
     * <p>This method initiates the traversal of the current data structure, prints a message indicating
     * the traversal process, and calls the traverse method on the data structure to update the visualization.</p>
     */
    public void traverseAndVisualize() {
        System.out.println("Traversing the Data Structure:");
        dataStructure.traverse();
    }
}
