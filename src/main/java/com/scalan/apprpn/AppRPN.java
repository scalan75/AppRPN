package com.scalan.apprpn;

import com.scalan.apprpn.rpn.RPNCalculator;
import com.scalan.apprpn.rpn.Operation;

/**
 *
 * @author alexsco
 */
public class AppRPN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RPNCalculator rpnCalculator = new RPNCalculator();    
        
        // Implement supported operations
        Operation plus = new Operation("+") {
            public double processOperation(double firstOperand, double secondOperand) {
                return firstOperand + secondOperand;
            }
        };
        Operation minus = new Operation("-") {
            public double processOperation(double firstOperand, double secondOperand) {
                return firstOperand - secondOperand;
            }
        };
        Operation mul = new Operation("*") {
            public double processOperation(double firstOperand, double secondOperand) {
                return firstOperand * secondOperand;
            }
        };
        Operation div = new Operation("/") {
            public double processOperation(double firstOperand, double secondOperand) {
                return firstOperand / secondOperand;
            }
        };

        // Add all implemented operations
        rpnCalculator.addOperation(plus);
        rpnCalculator.addOperation(minus);
        rpnCalculator.addOperation(mul);
        rpnCalculator.addOperation(div);

        // Run calculator
        rpnCalculator.runCalculator(System.in, System.out);
    }

}
