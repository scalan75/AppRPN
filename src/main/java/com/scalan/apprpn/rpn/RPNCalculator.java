package com.scalan.apprpn.rpn;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * RPNCalculator - implementation of RPNCalculator calculator
 *
 * @author alexsco
 */
public class RPNCalculator {

    // List with supported operations
    private List<Operation> operations = new ArrayList<>();
    private Stack<Double> stack = new Stack<>();

    /**
     * Method to add new operation into the list.
     *
     * @param operation - Operation object
     */
    public void addOperation(Operation operation) {
        operations.add(operation);
    }

    /**
     *
     * Method to process RPNCalculator calculator. Input: numbers [0-9],
     * operators [+-/*], quit: 'q'
     *
     * @param in - Input Stream (Stdin, file, etc...)
     * @param out - Output Stream (Stdout, file, etc...)
     */
    public void runCalculator(InputStream in, PrintStream out) {
        boolean quitFlag = false;

        Scanner scanner = new Scanner(in);
        scanner.useDelimiter("[\\t \\r\\n]");
        while (!quitFlag && scanner.hasNext()) {
            String element = scanner.next().trim();
            out.print(element + "\n");
            if (element.length() > 0) { // Not empty element...
                if (element.equalsIgnoreCase("q")) { // Quit...
                    quitFlag = true;
                } else {
                    processElement(element, out);
                }
            }
        }
        scanner.close();
    }

    /**
     * Method to process operation
     *
     * @param element - current one element from input stream
     * @param out - output stream
     */
    private void processElement(String element, PrintStream out) {
        // Looking for operation
        Operation currentOperation = null;
        for (Operation operation : operations) {
            if (operation.isOperation(element)) {
                currentOperation = operation;
                break;
            }
        }
        if (currentOperation != null) { // Process operation
            if (stack.size() >= 2) { // Check arguments count
                processOperation(currentOperation, out);
            } else { // Wrong arguments count.
                printError("Error.", out);
                stack.clear();
            }
        } else { // Process Number (parse)
            Double numElement = null;
            try {
                numElement = Double.parseDouble(element);
                stack.push(numElement);
            } catch (NumberFormatException e) { // Error parse number
                printError("Error.", out);
                stack.clear();
            }
        }
    }

    /**
     * Method to process current operation
     *
     * @param currentOperation
     * @param out
     */
    private void processOperation(Operation currentOperation, PrintStream out) {
        double secondOperand = stack.pop();
        double firstOperand = stack.pop();
        // Process operation...
        double result = currentOperation.processOperation(firstOperand, secondOperand);
        stack.push(result);
        // Print result
        printResult(result, out);
    }

    /**
     * Method to print result.
     *
     * @param result - value to print
     * @param out - stream to output
     */
    public void printResult(double result, PrintStream out) {
        // Print result...
        out.print(result + "\n");
    }

    /**
     * Method to print error message.
     *
     * @param message - text of the message to print
     * @param out - stream to output
     */
    public void printError(String message, PrintStream out) {
        // Print result...
        out.print(message + "\n");
    }
}
