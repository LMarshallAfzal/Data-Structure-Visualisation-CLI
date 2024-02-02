package main;

import dataStructures.LinkedList;
import visualisation.UserInterface;
import visualisation.VisualisationEngine;

/**
 * The Main class serves as the entry point for the Data Structure Visualiser program.
 *
 * <p>This class initializes a linked list data structure, creates instances of the VisualisationEngine
 * and UserInterface, and starts the user interface for interacting with and visualizing various data structures.</p>
 */
public class Main {
    /**
     * The main method, serving as the entry point for the Data Structure Visualiser program.
     *
     * <p>This method creates an instance of a linked list, sets up the VisualisationEngine with the initial
     * data structure, and initializes the UserInterface for user interaction. It then starts the user interface.</p>
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        VisualisationEngine visualisationEngine = new VisualisationEngine(linkedList);
        UserInterface userInterface = new UserInterface(visualisationEngine);

        userInterface.start();

    }
}
