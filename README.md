# Java command line RPN calculator
===========

## 1. What is Reverse Polish Notation (RPN)?
Reverse polish notation, or RPN, is one of the three commonly used calculation notations. In it we should place the operator after the numbers. 
Example: '**10 5 +**'.

## 2. Task
Create a RPN calculator which will read input stream and write results into output stream, process 4 base operations (+-*/).

## 3. Specifications

* The calculator uses standard input and standard output
* It implements the four standard arithmetic operators (+-*/)
* It works with double numerics (3.14, 1.15, etc...)
* It handles errors (wrong numbers) and recover gracefully (displays Error message and recover to init state)
* It exits when it receives a q command or an end of input indicator (EOF / Ctrl+D)


# Technical description
I use java language because it allows run application on Linux, Windows and Linux operation system.

As a software project management, build and run system I use maven - because it is most popular and allows work with complex projects.

Application has abstraction: operation. This point allows you create your own operations.


## Classes
**AppRPN** - main class which initialise RPNCalculator, adds supported Operations

**RPNCalculator** - class with implementation

**Operation** - abstract class which declare Operation

# Implementation

## 1. Installation
============================

Clone the the repository (use command and link in github).

```
git clone https://github.com/scalan75/AppRPN.git
```

Check java(1.8):
```
java --version
```

And maven:
```
mvn
```

## 2. Build application
To build application use next command:
```
mvn clean install
```
or run ```build.sh``` (Linux or Mac).

Application will be built, tested and ready to use.
Result jar file location: target/AppRPN-1.0-SNAPSHOT.jar

Be patient first time. Maven will load set of additional libraries so it might take few minutes to build.

## 3. Run application
To run application use next command:
```
mvn -q exec:java -Dexec.mainClass="com.scalan.apprpn.AppRPN"
```
or run ```run.sh``` (Linux or Mac).

## 4. Internal tests
* Test operations working operations (+-*/)
* Test few operations
* Test wrong parameters and correct working after that
* Test quit command
* Test empty rows
* Test the examples tests

## 5. Test examples files
To see how application works with files as input resource use:
```
mvn -q exec:java -Dexec.mainClass="com.scalan.apprpn.AppRPN" < example1.txt
```
or run ```run_exampleFiles.sh``` (Linux or Mac).

Example files list:

* example1.txt
* example2.txt
* example3.txt
* example4.txt

## 6. Java documentation
Build process includes prepare standard Java-doc files. Jar file with java-doc you can find in the target directory with name: AppRPN-1.0-SNAPSHOT.jar
In addition you can open target/apidocs directory in your browser to work with documentation.

## 7. How to create your own operations
Application has abstrach class Operation. It contain two important points:

* operation string
* operation process

Example plus ("+") operation declaration:

```
Operation plus = new Operation("+") {
	public double processOperation(double firstOperand, double secondOperand) {
		return firstOperand + secondOperand;
	}
};
```

Use it:

```
// Create calculator object
RPNCalculator rpnCalculator = new RPNCalculator(); 
// Add your operation(s)
rpnCalculator.addOperation(plus);
// ...
// Run calculator
rpnCalculator.runCalculator(System.in, System.out);
```

In addition I have created in the RPNCalculator class public methods printResult and printError. So you can extend this class and override it with your methods to polish output results or errors.

## 8. What can be improved
In my approach I declared base operations in the main method. I did it to  demonstration and for clear logic and to avoid bunch of short files with similar code.

In more complex logic this declaration should be placed into separate method and each operation should be placed into separate class.

Noext point: add more tests. I wrote dozen of tests to test basic logic and little bit more. I think there should be more complex test cases (Examples: set of operations, set of operations with errors, different type of data).

Application works with numbers in a double type. I think in some cases we need the same logic with integers.

# Resume
This application allows to process RPN calculator with basic +-*/ operations streams on Linux, Windows, Mac OS. In addition you can create your own Operations and implement them. Be comfortable to use it.