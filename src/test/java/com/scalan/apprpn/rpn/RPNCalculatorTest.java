package com.scalan.apprpn.rpn;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexsco
 */
public class RPNCalculatorTest {

    private RPNCalculator instance = new RPNCalculator();

    public RPNCalculatorTest() {
    }

    @Before
    public void setUp() {
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

        instance.addOperation(plus);
        instance.addOperation(minus);
        instance.addOperation(mul);
        instance.addOperation(div);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of runCalculator method, of class TestAppRPN (Test +).
     */
    @Test
    public void testRunCalculator_testPlus() {
        System.out.println("runCalculator test Plus");
        // Input string
        String inputString
                = "20\n"
                + "31\n"
                + "+\n";
        System.out.println("Input string:\n" + inputString);
        InputStream in = new java.io.ByteArrayInputStream(inputString.getBytes());
        OutputStream outputStream = new java.io.ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);
        instance.runCalculator(in, out);
        String outputString = outputStream.toString();
        System.out.println("Output string:\n" + outputString);
        // Check output string
        assertEquals(outputString,
                "20\n"
                + "31\n"
                + "+\n"
                + "51.0\n");
    }

    /**
     * Test of runCalculator method, of class TestAppRPN (Test -).
     */
    @Test
    public void testRunCalculator_testMinus() {
        System.out.println("runCalculator test Minus");
        // Input string
        String inputString
                = "8\n"
                + "3\n"
                + "-\n";
        System.out.println("Input string:\n" + inputString);
        InputStream in = new java.io.ByteArrayInputStream(inputString.getBytes());
        OutputStream outputStream = new java.io.ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);
        instance.runCalculator(in, out);
        String outputString = outputStream.toString();
        System.out.println("Output string:\n" + outputString);
        // Check output string
        assertEquals(outputString,
                "8\n"
                + "3\n"
                + "-\n"
                + "5.0\n");
    }

    /**
     * Test of runCalculator method, of class TestAppRPN (Test *).
     */
    @Test
    public void testRunCalculator_testMul() {
        System.out.println("runCalculator test Mul");
        // Input string
        String inputString
                = "23\n"
                + "2\n"
                + "*\n";
        System.out.println("Input string:\n" + inputString);
        InputStream in = new java.io.ByteArrayInputStream(inputString.getBytes());
        OutputStream outputStream = new java.io.ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);
        instance.runCalculator(in, out);
        String outputString = outputStream.toString();
        System.out.println("Output string:\n" + outputString);
        // Check output string
        assertEquals(outputString,
                "23\n"
                + "2\n"
                + "*\n"
                + "46.0\n");
    }

    /**
     * Test of runCalculator method, of class TestAppRPN (Test /).
     */
    @Test
    public void testRunCalculator_testDiv() {
        System.out.println("runCalculator test Div");
        // Input string
        String inputString
                = "60\n"
                + "2\n"
                + "/\n";
        System.out.println("Input string:\n" + inputString);
        InputStream in = new java.io.ByteArrayInputStream(inputString.getBytes());
        OutputStream outputStream = new java.io.ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);
        instance.runCalculator(in, out);
        String outputString = outputStream.toString();
        System.out.println("Output string:\n" + outputString);
        // Check output string
        assertEquals(outputString,
                "60\n"
                + "2\n"
                + "/\n"
                + "30.0\n");
    }

    /**
     * Test of runCalculator method, of class TestAppRPN (Test q).
     */
    @Test
    public void testRunCalculator_testQuit() {
        System.out.println("runCalculator test Quit");
        // Input string
        String inputString
                = "55\n"
                + "5\n"
                + "/\n"
                + "q\n";
        System.out.println("Input string:\n" + inputString);
        InputStream in = new java.io.ByteArrayInputStream(inputString.getBytes());
        OutputStream outputStream = new java.io.ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);
        instance.runCalculator(in, out);
        String outputString = outputStream.toString();
        System.out.println("Output string:\n" + outputString);
        // Check output string
        assertEquals(outputString,
                "55\n"
                + "5\n"
                + "/\n"
                + "11.0\n"
                + "q\n");
    }

    /**
     * Test of runCalculator method, of class TestAppRPN (Test few operations).
     */
    @Test
    public void testRunCalculator_testFewOperations() {
        System.out.println("runCalculator test FewOperations");
        // Input string
        String inputString
                = "5\n"
                + "7\n"
                + "*\n"
                + "3\n"
                + "+\n"
                + "12\n"
                + "*\n"
                + "20\n"
                + "-\n";
        System.out.println("Input string:\n" + inputString);
        InputStream in = new java.io.ByteArrayInputStream(inputString.getBytes());
        OutputStream outputStream = new java.io.ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);
        instance.runCalculator(in, out);
        String outputString = outputStream.toString();
        System.out.println("Output string:\n" + outputString);
        // Check output string
        assertEquals(outputString,
                "5\n"
                + "7\n"
                + "*\n"
                + "35.0\n"
                + "3\n"
                + "+\n"
                + "38.0\n"
                + "12\n"
                + "*\n"
                + "456.0\n"
                + "20\n"
                + "-\n"
                + "436.0\n");
    }

    /**
     * Test of runCalculator method, of class TestAppRPN (Test empty rows).
     */
    @Test
    public void testRunCalculator_testEmptyRows() {
        System.out.println("runCalculator test EmptyRows");
        // Input string
        String inputString
                = "1\n"
                + "2\n"
                + "\n"
                + "*\n"
                + "32\n"
                + "\n"
                + "+\n"
                + "\n"
                + "\n"
                + "28\n"
                + "*\n"
                + "30\n"
                + "-\n";
        System.out.println("Input string:\n" + inputString);
        InputStream in = new java.io.ByteArrayInputStream(inputString.getBytes());
        OutputStream outputStream = new java.io.ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);
        instance.runCalculator(in, out);
        String outputString = outputStream.toString();
        System.out.println("Output string:\n" + outputString);
        // Check output string
        assertEquals(outputString,
                "1\n"
                + "2\n"
                + "\n"
                + "*\n"
                + "2.0\n"
                + "32\n"
                + "\n"
                + "+\n"
                + "34.0\n"
                + "\n"
                + "\n"
                + "28\n"
                + "*\n"
                + "952.0\n"
                + "30\n"
                + "-\n"
                + "922.0\n");
    }

    /**
     * Test of runCalculator method, of class TestAppRPN (Test Error).
     */
    @Test
    public void testRunCalculator_testError() {
        System.out.println("runCalculator test Error");
        // Input string
        String inputString
                = "qwe\n"
                + "asd\n"
                + "+\n"
                + "5\n"
                + "9\n"
                + "1\n"
                + "-\n"
                + "/\n";
        System.out.println("Input string:\n" + inputString);
        InputStream in = new java.io.ByteArrayInputStream(inputString.getBytes());
        OutputStream outputStream = new java.io.ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);
        instance.runCalculator(in, out);
        String outputString = outputStream.toString();
        System.out.println("Output string:\n" + outputString);
        // Check output string
        assertEquals(outputString,
                "qwe\n"
                + "Error.\n"
                + "asd\n"
                + "Error.\n"
                + "+\n"
                + "Error.\n"
                + "5\n"
                + "9\n"
                + "1\n"
                + "-\n"
                + "8.0\n"
                + "/\n"
                + "0.625\n");
    }

    //===============================
    // Tests based on task examples:
    //===============================
    /**
     * Test of runCalculator method, of class TestAppRPN (Example1).
     */
    @Test
    public void testRunCalculator_example1() {
        System.out.println("runCalculator test example1");
        // Input string
        String inputString
                = "5\n"
                + "8\n"
                + "+\n";
        System.out.println("Input string:\n" + inputString);
        InputStream in = new java.io.ByteArrayInputStream(inputString.getBytes());
        OutputStream outputStream = new java.io.ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);
        instance.runCalculator(in, out);
        String outputString = outputStream.toString();
        System.out.println("Output string:\n" + outputString);
        // Check output string
        assertEquals(outputString,
                "5\n"
                + "8\n"
                + "+\n"
                + "13.0\n");
    }

    /**
     * Test of runCalculator method, of class TestAppRPN (Example2).
     */
    @Test
    public void testRunCalculator_example2() {
        System.out.println("runCalculator test example2");
        // Input string
        String inputString
                = "5 8 +\n"
                + "13 -\n";
        System.out.println("Input string:\n" + inputString);
        InputStream in = new java.io.ByteArrayInputStream(inputString.getBytes());
        OutputStream outputStream = new java.io.ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);
        instance.runCalculator(in, out);
        String outputString = outputStream.toString();
        System.out.println("Output string:\n" + outputString);
        // Check output string
        assertEquals(outputString,
                "5\n"
                + "8\n"
                + "+\n"
                + "13.0\n"
                + "13\n"
                + "-\n"
                + "0.0\n");
    }

    /**
     * Test of runCalculator method, of class TestAppRPN (Example3).
     */
    @Test
    public void testRunCalculator_example3() {
        System.out.println("runCalculator test example3");
        // Input string
        String inputString
                = "-3\n"
                + "-2\n"
                + "*\n"
                + "5\n"
                + "+\n";
        System.out.println("Input string:\n" + inputString);
        InputStream in = new java.io.ByteArrayInputStream(inputString.getBytes());
        OutputStream outputStream = new java.io.ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);
        instance.runCalculator(in, out);
        String outputString = outputStream.toString();
        System.out.println("Output string:\n" + outputString);
        // Check output string
        assertEquals(outputString,
                "-3\n"
                + "-2\n"
                + "*\n"
                + "6.0\n"
                + "5\n"
                + "+\n"
                + "11.0\n");
    }

    /**
     * Test of runCalculator method, of class TestAppRPN (Example4).
     */
    @Test
    public void testRunCalculator_example4() {
        System.out.println("runCalculator test example4");
        // Input string
        String inputString
                = "5\n"
                + "9\n"
                + "1\n"
                + "-\n"
                + "/\n";
        System.out.println("Input string:\n" + inputString);
        InputStream in = new java.io.ByteArrayInputStream(inputString.getBytes());
        OutputStream outputStream = new java.io.ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);
        instance.runCalculator(in, out);
        String outputString = outputStream.toString();
        System.out.println("Output string:\n" + outputString);
        // Check output string
        assertEquals(outputString,
                "5\n"
                + "9\n"
                + "1\n"
                + "-\n"
                + "8.0\n"
                + "/\n"
                + "0.625\n");
    }

}
