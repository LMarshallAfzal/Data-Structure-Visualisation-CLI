package visualisation;

import java.util.Scanner;
import dataStructures.DataStructure;
import dataStructures.LinkedList;
import dataStructures.Stack;

public class UserInterface {
    private final VisualisationEngine visualisationEngine;
    private final Scanner scanner;
    private static boolean running;

    public UserInterface(VisualisationEngine visualisationEngine) {
        this.visualisationEngine = visualisationEngine;
        this.scanner = new Scanner(System.in);
        running = true;
    }

    public void start() {
        System.out.println("Welcome to the Data Structure Visualiser!");
        System.out.println("Type 'help' for a list of available commands.");

        while (running) {
            System.out.print("> ");
            String userInput = scanner.nextLine();
            processUserInput(userInput);
        }
    }

    private void processUserInput(String userInput) {
        switch (userInput.toLowerCase()) {
            case "help":
                displayHelp();
                break;
            case "exit":
                exitProgram();
                break;
            default:
                handleDataStructureCommand(userInput);
        }
    }

    private void displayHelp() {
        System.out.println("Available Commands:");
        System.out.println(" - help: Display this help message.");
        System.out.println(" - choose: Choose a data structure.");
        System.out.println(" - exit: Exit the program.");
    }

    private void handleDataStructureCommand(String userInput) {
        switch (userInput.toLowerCase()) {
            case "choose":
                chooseDataStructure();
                break;
            default:
                System.out.println("Unknown command: Type 'help' for assistance.");
        }
    }

    private void chooseDataStructure() {
        System.out.println("Choose a data structure:");
        System.out.println("1. Linked List");
        System.out.println("2. Stack");
        System.out.println("3. Queue");
        System.out.println("4. Hash Table");
        System.out.println("5. Tree");

        System.out.print("Enter the number of your choice: ");
        String choice = scanner.nextLine();

        DataStructure selectedDataStructure = createDataStructure(choice);
        if (selectedDataStructure != null) {
            visualisationEngine.setDataStructure(selectedDataStructure);
            performDataStructureOperations();
        }
    }

    private DataStructure createDataStructure(String choice) {
        switch (choice.toLowerCase()) {
            case "1":
                return new LinkedList();
            case "2":
                return new Stack();
            case "3":
                return null;
            case "4":
                return null;
            default:
                System.out.println("Invalid choice. Please try again.");
                return null;
        }
    }

    private void performDataStructureOperations() {
        System.out.println("Data Structure chosen. You can now perform operations:");
        System.out.println(" - add: Add a node.");
        System.out.println(" - remove: Remove a node.");
        System.out.println(" - display: Display the current data structure.");
        System.out.println(" - back: Go back to choosing a data structure.");
        System.out.println(" - exit: Exit the program");

        while (running) {
            System.out.print("> ");
            String operation = scanner.nextLine().toLowerCase();
            switch (operation) {
                case "add":
                    addNode();
                    break;
                case "remove":
                    removeNode();
                    break;
                case "traverse":
                    visualisationEngine.traverseAndVisualize();
                    break;
                case "display":
                    visualisationEngine.displayVisualisation();
                    break;
                case "back":
                    return;
                case "exit":
                    exitProgram();
                    break;
                default:
                    System.out.println("Unknown operation. Type 'help' for assistance.");
            }
        }
    }

    private void addNode() {
        System.out.print("Enter the value of the node to add: ");
        int value = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        visualisationEngine.getDataStructure().addNode(value);
        System.out.println("Node added.");
        visualisationEngine.displayVisualisation();
    }

    private void removeNode() {
        System.out.print("Enter the value of the node to remove: ");
        int value = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        visualisationEngine.getDataStructure().removeNode(value);
        System.out.println("Node removed.");
        visualisationEngine.displayVisualisation();
    }

    private void exitProgram() {
        System.out.println("Thanks for using Data Structure visualiser");
        running = false;
    }
}
