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
//BallGraphics.java
//Compile: javac BallGraphics.java
//This module called from the Main class
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
import java.lang.Math;
import java.awt.Graphics;
import java.awt.BasicStroke;


public class BallGraphics extends JPanel
{
  private int width = 1280;
  private int height = 900 - 50 - 100;
  private double xmin;
  private double xmax;
  private double ymin;
  private double ymax;
  private double x;
  private double y;
  private double dx;
  private double dy;
  private Color ballColor = new Color(255,170,100);
  private double radius = 10.0;
  private double diameter = 2.0* radius;
  private double getxcenter_of_ball;
  private double getycenter_of_ball;
  private double ballXCorner;
  private double ballYCorner;
  private double sigmaX;
  private double sigmaY;
  private double temp;
  private int intballXCorner;
  private int intballYCorner;
  private int index;
  private boolean successmove = true;
  private boolean showBall = false;

  public BallGraphics()
  {
    setVisible(true);
  }



  public void BallMovement(double deltaX, double deltaY)
  {
    xmin = 0;
    xmax = width;
    ymin = 0;
    ymax = height;

    sigmaX = deltaX;
    sigmaY = deltaY;


    getxcenter_of_ball = (xmin + ymax) / 2;
    getycenter_of_ball = (ymin + ymax) / 2;

    ballXCorner = getxcenter_of_ball - radius;
    ballYCorner = getycenter_of_ball - radius;
    intballXCorner = (int)Math.round(ballXCorner);
    intballYCorner = (int)Math.round(ballYCorner);

  }

  public void paintComponent(Graphics g)
  {

    super.paintComponent(g);
    setBackground(new Color(  0,100,165));
    if(showBall)
    {
      g.setColor(ballColor);
      g.fillOval(intballXCorner, intballYCorner, (int) Math.round(diameter), (int)Math.round(diameter));
    }


  }

  public void showing(boolean show)
  {
    showBall = show;
  }


  public boolean moveBall()
  {
    successmove = true;
    if(getycenter_of_ball + sigmaY < radius || getycenter_of_ball + sigmaY > height - radius)
    {
      sigmaY = -sigmaY;
    }

    if(getxcenter_of_ball + sigmaX < radius || getxcenter_of_ball + sigmaX > width - radius)
    {
      sigmaX = -sigmaX;
    }

    getxcenter_of_ball += sigmaX;
    getycenter_of_ball += sigmaY;
    ballXCorner = getxcenter_of_ball - radius;
    ballYCorner = getycenter_of_ball - radius;
    intballXCorner = (int)Math.round(ballXCorner);
    intballYCorner = (int)Math.round(ballYCorner);

    return successmove;
  }

  public double CenterXofBall()
  {
    temp = getxcenter_of_ball;
    return temp;
  }
  public double CenterYofBall()
  {
    temp = getycenter_of_ball;
    return temp;
  }

}
