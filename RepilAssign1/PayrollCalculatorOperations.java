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
	//Date of last update: 2021-Feb-11
	//Status: Work in Progress
	//Purpose: This program is supposed to create a basic UI for computing
	//the weekly amount of pay for employees in a small hypothetical company.
	//Main things this program will demonstrate is the ability to use multiple
	//files, creating panels, text, and other UI elemants as well as making
	//operations to do equations.


//This module
	//PayrollCalculatorOperations.java
	//Compile: PayrollCalculatorOperations.java
	//This module is invoked in PayrollCalculatorFrame class
  // Purpose: To do the calculations of the payroll for the employees


  public class PayrollCalculatorOperations
  {

    public static double payroll (double hoursWorked, double hourPay)
    {
      double prod;
      prod = hoursWorked * hourPay;
      return prod;


    } // end of regular pay payroll function

    public static double overTime (double hoursWorked, double hourPay)
    {
      double overTimePay;
      overTimePay = 1.5*hourPay*(hoursWorked-40.0);

      return overTimePay;
    } // end of overtime calculator

    public static double grossPay (double regularPay, double overPay)
    {


      double gross = regularPay + overPay;
      return gross;


    }
    public static boolean isFloat(String s)
    {
      int length = s.length();
      boolean success = true;
      if(length == 0)
      {
        success = false;
      }
      else
      {
        int start = 0;
        char c = s.charAt(0);
        if (c == '+' || c == '-')
        {
          start = 1;
        }
        if (start == length)
        {
          success = false;
        }
        for (int k = start; k < length && success; k++)
        {
          c = s.charAt(k);
          if(Character.isLetter(c))
          {
            success = false;
          }
          if(!hasDot(s))
          {
            success = false;
          }
        } // for loop ended
      } // end of the else
        return success;
    }// end of is float

    public static boolean hasDot(String s)
    {
      boolean success;
      success = true;
      if (!s.contains("."))
      {
        success = false;
      }
      return success;
    }



  }
