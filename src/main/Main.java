package main;

import dataStructures.LinkedList;
import dataStructures.DataStructure;
import visualisation.UserInterface;
import visualisation.VisualisationEngine;
public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        VisualisationEngine visualisationEngine = new VisualisationEngine(linkedList);
        UserInterface userInterface = new UserInterface(visualisationEngine);

        userInterface.start();

    }
}
