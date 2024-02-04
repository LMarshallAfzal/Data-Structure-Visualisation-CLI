package visualisation;

import java.util.Scanner;

import dataStructures.BinaryTree;
import dataStructures.DataStructure;
import dataStructures.LinkedList;
import dataStructures.Stack;

/**
 * User Interface for the Data Structure Visualiser.
 *
 * <p>This class provides a command-line interface for the user to interact with the Data Structure
 * Visualiser. Users can choose different data structures, perform operations on them, and visualise
 * the changes in real time.</p>
 */
public class UserInterface {
    private final VisualisationEngine visualisationEngine;
    private final Scanner scanner;
    private static boolean running;

    /**
     * Constructs a User Interface with the specified VisualisationEngine.
     *
     * @param visualisationEngine The Visualisation Engine to use for visualisation.
     */
    public UserInterface(VisualisationEngine visualisationEngine) {
        this.visualisationEngine = visualisationEngine;
        this.scanner = new Scanner(System.in);
        running = true;
    }

    /**
     * Starts the Data Structure Visualiser UI
     */
    public void start() {
        System.out.println("Welcome to the Data Structure Visualiser!");
        System.out.println(("Here you can view data structures and perform operations on them."));
        System.out.println("Type 'help' for a list of available commands.");
        System.out.println("------------------------------------------------------------------");

        while (running) {
            System.out.print("> ");
            String userInput = scanner.nextLine();
            processUserInput(userInput);
        }
    }

    /**
     * Process the user's input based on the given command.
     *
     * <p>This method evaluates the user's input and performs the corresponding action based on the command.
     * If the input is "help," it calls the displayHelp() method to show a list of available commands.
     * If the input is "exit," it calls the exitProgram() method to terminate the program. For any other input,
     * it calls the handleDataStructureCommand() method to process data structure-related commands.</p>
     *
     * @param userInput The user's input to be processed.
     */
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

    /**
     * Displays a list of available commands to the user.
     *
     * <p>This method prints a message to the console providing information about the available commands.
     * It includes commands such as 'help' to display the help message, 'choose' to select a data structure,
     * and 'exit' to exit the program.</p>
     */
    private void displayHelp() {
        System.out.println("\nAvailable Commands:");
        System.out.println(" - help: Display this help message.");
        System.out.println(" - choose: Choose a data structure.");
        System.out.println(" - exit: Exit the program.");
        System.out.println("------------------------------------------------------------------");
    }

    /**
     * Handles user input related to data structure commands.
     *
     * <p>This method takes user input and checks if it corresponds to the 'choose' command.
     * If the input is 'choose,' it calls the chooseDataStructure() method to initiate the data structure
     * selection process. If the input is unknown, it prints a message suggesting the user type 'help'
     * for assistance.</p>
     *
     * @param userInput The user's input related to data structure commands.
     */
    private void handleDataStructureCommand(String userInput) {
        if (userInput.equalsIgnoreCase("choose")) {
            chooseDataStructure();
        } else {
            System.out.println("Unknown command: Type 'help' for assistance.");
            System.out.println("------------------------------------------------------------------");
        }
    }

    /**
     * Initiates the process of choosing a data structure.
     *
     * <p>This method guides the user through the process of choosing a data structure.
     * It displays a list of available data structures, prompts the user to enter a choice,
     * and sets the selected data structure in the VisualisationEngine. It then calls the
     * performDataStructureOperations() method to allow the user to perform operations on the chosen
     * data structure.</p>
     */
    private void chooseDataStructure() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("Choose a data structure:");
        System.out.println("1. Linked List");
        System.out.println("2. Stack");
        System.out.println("3. Queue");
        System.out.println("4. Binary Tree");
        System.out.println("5. Tree");
        System.out.println("------------------------------------------------------------------");

        System.out.print("Enter the number of your choice: ");
        String choice = scanner.nextLine();

        DataStructure selectedDataStructure = createDataStructure(choice);
        if (selectedDataStructure != null) {
            visualisationEngine.setDataStructure(selectedDataStructure);
            performDataStructureOperations();
        }
    }

    /**
     * Creates a new instance of the selected data structure based on the user's choice.
     *
     * <p>This method takes a string representation of the user's choice and returns a new instance of the
     * corresponding data structure. The choices include options for a Linked List, Stack, and null for other
     * data structures. If the choice is invalid, it prints an error message and returns null.</p>
     *
     * @param choice The user's choice representing the desired data structure.
     * @return A new instance of the selected data structure or null if the choice is invalid.
     */
    private DataStructure createDataStructure(String choice) {
        switch (choice.toLowerCase()) {
            case "1":
                return new LinkedList();
            case "2":
                return new Stack();
            case "3":
                return null;
            case "4":
                return new BinaryTree();
            default:
                System.out.println("Invalid choice. Please try again.");
                return null;
        }
    }

    /**
     * Performs operations on the selected data structure based on user input.
     *
     * <p>This method displays the available operations for the chosen data structure and continuously
     * prompts the user for input to perform various actions. It supports operations such as adding and
     * removing nodes, pushing and popping elements, traversing, displaying, going back to choosing a data
     * structure, and exiting the program.</p>
     */
    private void performDataStructureOperations() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("Data Structure chosen. You can now perform operations:");

        if (!(visualisationEngine.getDataStructure() instanceof Stack)) {
            System.out.println(" - add: Add a node.");
            System.out.println(" - remove: Remove a node.");
        } else {
            System.out.println(" - push: Push an element onto the stack");
            System.out.println(" - pop: Pop an element from the stack");
        }

        System.out.println(" - display: Display the current data structure.");
        System.out.println(" - back: Go back to choosing a data structure.");
        System.out.println(" - exit: Exit the program");
        System.out.println("------------------------------------------------------------------");

        while (running) {
            System.out.print("> ");
            String operation = scanner.nextLine().toLowerCase();
            switch (operation) {
                case "add":
                case "push":
                    addNode();
                    break;
                case "remove":
                case "pop":
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

    /**
     * Adds a node to the selected data structure with the specified value.
     *
     * <p>This method prompts the user to enter the value of the node to be added, reads the input, and adds
     * a node with the entered value to the selected data structure. It then displays the updated visualisation.</p>
     */
    private void addNode() {
        System.out.print("Enter the value of the node to add: ");
        int value = scanner.nextInt();
        scanner.nextLine();

        visualisationEngine.getDataStructure().addNode(value);
        visualisationEngine.displayVisualisation();
    }

    /**
     * Removes a node from the selected data structure based on user input.
     *
     * <p>This method checks the type of the selected data structure. If it's not a Stack, it prompts the user
     * to enter the value of the node to be removed. If it's a Stack, it removes the top element. It then displays
     * the updated visualisation of the data structure.</p>
     */
    private void removeNode() {
        if (!(visualisationEngine.getDataStructure() instanceof Stack)) {
            System.out.print("Enter the value of the node to remove: ");
            int value = scanner.nextInt();
            scanner.nextLine();

            visualisationEngine.getDataStructure().removeNode(value);
        } else {
            visualisationEngine.getDataStructure().removeNode(0);
        }

        visualisationEngine.displayVisualisation();
    }

    /**
     * Exits the Data Structure Visualiser program.
     *
     * <p>This method prints a farewell message to the console and sets the 'running' flag to false, indicating
     * that the program should terminate. It is called when the user decides to exit the program.</p>
     */
    private void exitProgram() {
        System.out.println("Thanks for using Data Structure visualiser");
        running = false;
    }
}
