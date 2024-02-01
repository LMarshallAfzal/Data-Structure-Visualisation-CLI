package visualisation;

import dataStructures.DataStructure;

public class VisualisationEngine {
    private DataStructure dataStructure;

    public VisualisationEngine(DataStructure initialDataStructure) {
        this.dataStructure = initialDataStructure;
    }

    public void setDataStructure(DataStructure newDataStructure) {
        this.dataStructure = newDataStructure;
    }

    public DataStructure getDataStructure() {
        return dataStructure;
    }

    public void updateVisualisation() {
        String visualRepresentation = dataStructure.getVisualRepresentation();

        System.out.println("Visual Representation:");
        System.out.println(visualRepresentation);
    }

    public void displayVisualisation() {
        String visualRepresentation = dataStructure.getVisualRepresentation();

        System.out.println();
        System.out.println(visualRepresentation);
        System.out.println();
    }

    public void traverseAndVisualize() {
        // Traverse the data structure and update the visualization during traversal
        System.out.println("Traversing the Data Structure:");
        dataStructure.traverse();  // Assuming the traverse method is implemented in DataStructure
    }
}
