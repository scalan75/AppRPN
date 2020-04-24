package com.scalan.apprpn.rpn;

/**
 * Operation abstract object
 *
 * @author alexsco
 */
public abstract class Operation {

    String operation;

    public Operation(String operation) {
        this.operation = operation;
    }

    /**
     * 
     * Method to check operation element
     * 
     * @param operation - text element of operation
     * @return true or false
     */
    public boolean isOperation(String operation) {
        return this.operation.equals(operation);
    }

    /**
     * 
     * Method to process operation between two values.
     * 
     * @param value1 - first Value
     * @param value2 - second Value
     * @return result of operation
     */
    abstract public double processOperation(double value1, double value2);
}
