//****************************************************************************************************************************
//Program name: "Bouncing Balls.  This program shows how to employ grid layout to better control resizing of  *
//the entire frame.  Copyright (C) 2021 Emmanuel Salcedo  This program is free software: you can redistribute it and/or modify *
//it under the terms of the GNU General Public License version 3 as published by the Free Software Foundation.               *
//This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied         *
//warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.     *
//A copy of the GNU General Public License v3 is available here:  <https://www.gnu.org/licenses/>.                           *
//****************************************************************************************************************************
//Author: Emmanuel Salcedo
//Mail: emsalcedo@csu.fullerton.edu

//Program Information
//Program Name:Bouncing Balls
//Programming Language: Java
//Files: BallGraphics.java, BounceballInterface.java, Main.java, run.sh
//Date Project began: 2021-Mar-17
//Date of last update: 2021-Mar-28
//Status: Work in Progress
//Purpose: This program is meant to simulate a bouncing ball
//This module
//Main.java
//Compile: javac Main.java
//This module is the top level class that activates the UI
// Purpose: To practice more with java graphics as well as having collisions


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



public class Main
{public static void main(String[] args)
  {
    BounceballInterface myframe = new BounceballInterface();
    myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    myframe.setSize(1280, 900);
    myframe.setVisible(true);
  }


}
