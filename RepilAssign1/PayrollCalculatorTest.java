//****************************************************************************************************************************
//Program name: "Payroll Calculator.  This program shows how to employ grid layout to better control resizing of  *
//the entire frame.  Copyright (C) 2021 Emmanuel Salcedo  This program is free software: you can redistribute it and/or modify *
//it under the terms of the GNU General Public License version 3 as published by the Free Software Foundation.               *
//This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied         *
//warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.     *
//A copy of the GNU General Public License v3 is available here:  <https://www.gnu.org/licenses/>.                           *
//****************************************************************************************************************************


//Author: Emmanuel Salcedo
//Mail: emsalcedo@csu.fullerton.edu


//Program Information
	//Program Name:Payroll Calculator
	//Programming Language: Java
	//Files: PayrollCalculatorOperations.java, PayrollCalculatorFrame.java, PayrollCalculatorTest.Java, run.sh
	//Date Project began: 2021-Jan-27
	//Date of last update: 2021-Feb-10
	//Status: Work in Progress
	//Purpose: This program is supposed to create a basic UI for computing
	//the weekly amount of pay for employees in a small hypothetical company.
	//Main things this program will demonstrate is the ability to use multiple
	//files, creating panels, text, and other UI elemants as well as making
	//operations to do equations.


//This module
  //File name: PayrollCalculatorTest.java
  //Compile: javac PayrollCalculatorTest.java
  //This is the top level module and is the one that activates the UI

  import javax.swing.*;

  public class PayrollCalculatorTest
  {public static void main (String[] args)
    { PayrollCalculatorFrame myframe = new PayrollCalculatorFrame();
      myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      myframe.setSize(900,800);
      myframe.setVisible(true);


    }//main ends here

  }//end of class
