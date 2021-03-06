#Program name: Payroll Calculator
#Author: Emmanuel Salcedo
#email: emsalcedo@csu.fullerton.edu
#file name: run.sh
#Preconditions:
#	1. All source files are in one directory
#	2. THis file, run.sh , is in the same directory
#	3. The shell is currently active is in the same directory
#How to execute: Enter "sh run.sh" without quotes in terminal

echo Remove old byte-code files if any exist
rm *.class

echo View list of source files
ls -l *.java

echo Compile PayrollCalculatorOperations.java
javac PayrollCalculatorOperations.java

echo Compile PayrollCalculatorFrame.java
javac PayrollCalculatorFrame.java

echo Compile PayrollCalculatorTest.java
javac PayrollCalculatorTest.java

echo Execute the Payroll Program
java PayrollCalculatorTest

echo End of execution. Thank you

