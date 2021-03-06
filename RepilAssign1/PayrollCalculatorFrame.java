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
//Date of last update: 2021-Feb-12
//Status: Work in Progress
//Purpose: This program is supposed to create a basic UI for computing
//the weekly amount of pay for employees in a small hypothetical company.
//Main things this program will demonstrate is the ability to use multiple
//files, creating panels, text, and other UI elemants as well as making
//operations to do equations.

//This module
//PayrollCalculatorFrame.java
//Compile: javac PayrollCalculatorFrame.java
//This module called from the PayrollCalculatorTest class
// Purpose: To show understanding of using JPanels, JButtons, JText
// and overall java UI abilities for a beginner

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.Timer;

public class PayrollCalculatorFrame extends JFrame {
  private final int length_of_delay = 3500; // time is done with milliseconds
  private JButton clearButton;
  private JButton computeButton;
  private JButton exitButton;
  private JTextField employeeName;
  private JTextField workedHours;
  private JTextField payRateHours;
  private JPanel compName;
  private JPanel inputPanel;
  private JPanel outputPanel;
  private JPanel buttonPanel;
  private JLabel nameOfEmploy;
  private JLabel empStringtoLabel;
  private JLabel regPay;
  private JLabel regStringtoLabel;
  private JLabel overtimePay;
  private JLabel overStringtoLabel;
  private JLabel grossPay;
  private JLabel grossStringtoLabel;
  private JLabel nameofComp;
  private JLabel displayEmpName;
  private JLabel displayHourWorked;
  private JLabel displayPayRate;
  private Timer delayClosing;
  private PayrollCalculatorOperations operations;
  private String empNameString; // string to show employee name
  private String overTimeString; // string to show the over time pay
  private String regPayString; // string for regular pay
  private String grossPayString; // string for the gross pay
  private String hourString; //string for the amount of hours worked
  private String payRateString; //string for the payrate
  private double payGrossDoub; // double to use to display the gross pay
  private double regPayDoub; // double to display the regular pay
  private double overTimeDoub; // double for to display the overtime
  private double hoursDoub; // to use in function
  private double payDoub; // to use in operations function
  private boolean inputIsValid;
  private boolean successCalc;

  private Color CPanel1 = new Color(153,76,0);
  private Color CPanel2 = new Color(0, 102, 204);
  private Color CPanel3 = new Color(159, 74, 74);
  private Color CPanel4 = new Color(88,78,226);

  public PayrollCalculatorFrame() // constructor
  {
    super("Program 1");
    setLayout(new FlowLayout());
    setTitle("Payroll Calculator");
    // Panel 1
    compName = new JPanel();
    compName.setBackground(CPanel1);
    compName.setPreferredSize(new Dimension(850,75));
    add(compName);
    nameofComp = new JLabel("Franklin Flowers");
    compName.add(nameofComp);
    // Panel 2
    inputPanel = new JPanel();
    inputPanel.setBackground(CPanel2);
    inputPanel.setPreferredSize(new Dimension(300,250));
    add(inputPanel);
    empNameString = new String();
    overTimeString = new String();
    regPayString = new String();
    grossPayString = new String();
    hourString = new String();
    payRateString = new String();
    displayEmpName = new JLabel("Employee name: ");
    displayHourWorked = new JLabel("Hours worked: ");
    displayPayRate = new JLabel("Hourly pay rate: ");
    employeeName = new JTextField(5);
    workedHours = new JTextField(5);
    payRateHours = new JTextField(5);
    inputPanel.add(displayEmpName);
    inputPanel.add(employeeName);
    inputPanel.add(displayHourWorked);
    inputPanel.add(workedHours);
    inputPanel.add(displayPayRate);
    inputPanel.add(payRateHours);
    // Panel 3
    outputPanel = new JPanel();
    outputPanel.setBackground(CPanel3);
    outputPanel.setPreferredSize(new Dimension(300,250));
    add(outputPanel);
    nameOfEmploy = new JLabel("Name of employee ");
    regPay = new JLabel("Regular pay " );
    overtimePay = new JLabel("Overtime pay " );
    grossPay = new JLabel("Gross pay" );
    empStringtoLabel = new JLabel();
    regStringtoLabel = new JLabel();
    overStringtoLabel = new JLabel();
    grossStringtoLabel = new JLabel();
    outputPanel.add(nameOfEmploy);
    outputPanel.add(empStringtoLabel);
    outputPanel.add(regPay);
    outputPanel.add(regStringtoLabel);
    outputPanel.add(overtimePay);
    outputPanel.add(overStringtoLabel);
    outputPanel.add(grossPay);
    outputPanel.add(grossStringtoLabel);
    // Panel 4
    buttonPanel = new JPanel();
    buttonPanel.setBackground(CPanel4);
    buttonPanel.setPreferredSize(new Dimension(750,150));
    add(buttonPanel);
    clearButton = new JButton("Clear");
    computeButton = new JButton("Compute");
    exitButton = new JButton("Quit");
    buttonPanel.add(clearButton);
    buttonPanel.add(computeButton);
    buttonPanel.add(exitButton);

    // handlers and actions
    buttonhandler myhandler = new buttonhandler();
    clearButton.addActionListener(myhandler);
    computeButton.addActionListener(myhandler);
    exitButton.addActionListener(myhandler);
    operations = new PayrollCalculatorOperations();
    delayClosing = new Timer(length_of_delay, myhandler);

  } // end of constructor

  // new class for actions of the JButtons
  private class buttonhandler implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      if (event.getSource() == clearButton) {
        employeeName.setText(null);
        empNameString = employeeName.getText();
        empStringtoLabel.setText(empNameString);
        regPayString = employeeName.getText();
        regStringtoLabel.setText(regPayString);
        overTimeString = employeeName.getText();
        overStringtoLabel.setText(overTimeString);
        grossPayString = employeeName.getText();
        grossStringtoLabel.setText(grossPayString);
        workedHours.setText(null);
        payRateHours.setText(null);


      }
      // end of clear button

      else if (event.getSource() == computeButton) {
        

        successCalc = true;
        empNameString = employeeName.getText();
        empStringtoLabel.setText(empNameString);

        hourString = workedHours.getText();
        payRateString = payRateHours.getText();
        inputIsValid = operations.isFloat(payRateString);

        if(inputIsValid) // process the pay rate to see if valid
        {
        payDoub = Double.parseDouble(payRateString);
        }

        else
        {
          successCalc = false;
        }
        inputIsValid = operations.isFloat(hourString);

        if(inputIsValid) // process the hours worked to see if valid
        {
        hoursDoub = Double.parseDouble(hourString);
        }

        else
        {
          successCalc = false;
        }

        if(hoursDoub <= 40 && hoursDoub > 0)
        {
          overTimeDoub = 0.0;
          regPayDoub = operations.payroll(hoursDoub, payDoub);

        }
        else if(hoursDoub > 40 && hoursDoub <= 168)
        {
          overTimeDoub = operations.overTime(hoursDoub, payDoub);
          regPayDoub = operations.payroll(hoursDoub, payDoub);
        }
        else if (hoursDoub > 168 || hoursDoub < 0)
        {
          successCalc = false;


        }


        if(successCalc)
        {
        payGrossDoub = operations.grossPay(regPayDoub, overTimeDoub);
        regPayString = String.format("%.2f", regPayDoub);
        overTimeString = String.format("%.2f", overTimeDoub);
        grossPayString = String.format("%.2f", payGrossDoub);

        regStringtoLabel.setText(regPayString);
        overStringtoLabel.setText(overTimeString);
        grossStringtoLabel.setText(grossPayString);
        }
        else
        {
        regStringtoLabel.setText("Error");
        overStringtoLabel.setText("Error");
        grossStringtoLabel.setText("Error");
        }










      }
      // end of compute button
      else if (event.getSource() == exitButton) {
        exitButton.setEnabled(false);
        computeButton.setEnabled(false);
        clearButton.setEnabled(false);
        delayClosing.start();
      } else if (event.getSource() == delayClosing) {
        System.exit(0);
      } else
        System.out.println("Unknown error");
    }

  }// end of button handler

} // end of frame class
