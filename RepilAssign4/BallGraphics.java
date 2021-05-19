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
//Date Project began: 2021-April-17
//Date of last update: 2021-May-10
//Status: Work in Progress
//Purpose: This program is meant to simulate a bouncing ball
//This module contains all the graphical information required to have the program run correctly, including speed and movement curve.
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
import java.awt.geom.Point2D;


public class BallGraphics extends JPanel
{
  private int width = 1280;
  private int height = 720 - 50 - 100;
  private double xmin;
  private double xmax;
  private double ymin;
  private double ymax;
  private double x;
  private double y;
  private double dx;
  private double dy;
  private Color ballColor = new Color( 33, 47, 60);
  private Color bigBallColor = new Color(146, 43, 33);
  private double radius = 10.0;
  private double catRadius = 20.0;
  private double diameter = 2.0* radius;
  private double catDiameter = 2.0 * catRadius;
  private double getxcenter_of_ball;
  private double getycenter_of_ball;
  private double cat_getxcenter_of_ball;
  private double cat_getycenter_of_ball;
  private double ballXCorner;
  private double ballYCorner;
  private double cat_ballXCorner;
  private double cat_ballYCorner;
  private double sigmaX;
  private double sigmaY;
  private double cat_sigmaX;
  private double cat_sigmaY;
  private double temp;
  private int intballXCorner;
  private int intballYCorner;
  private int cat_intballXCorner;
  private int cat_intballYCorner;
  private int index;
  private double distance;
  private double catSpeed;
  private boolean successmove = true;

  public BallGraphics()
  {
    setVisible(true);
  }



  public void BallMovement(double deltaX, double deltaY, double catClock)
  {
    xmin = 0;
    xmax = width;
    ymin = 0;
    ymax = height;
    catSpeed = catClock;
    sigmaX = deltaX;
    sigmaY = deltaY;


    getxcenter_of_ball = (xmin + ymax) / 2;
    getycenter_of_ball = (ymin + ymax) / 2;

    cat_getxcenter_of_ball = (0 + 40) / 2;
    cat_getycenter_of_ball = (0 + 40) / 2;

    distance = Point2D.distance(cat_getxcenter_of_ball, cat_getycenter_of_ball, getxcenter_of_ball, getycenter_of_ball);

    ballXCorner = getxcenter_of_ball - radius;
    ballYCorner = getycenter_of_ball - radius;
    cat_ballXCorner = cat_getxcenter_of_ball - catRadius;
    cat_ballYCorner = cat_getycenter_of_ball - catRadius;
    intballXCorner = (int)Math.round(ballXCorner);
    intballYCorner = (int)Math.round(ballYCorner);
    cat_intballXCorner = (int)Math.round(cat_ballXCorner);
    cat_intballYCorner = (int)Math.round(cat_ballYCorner);
  }

  public void paintComponent(Graphics g)
  {

    super.paintComponent(g);
    setBackground(new Color(242,155,195));


      g.setColor(ballColor);
      g.fillOval(intballXCorner, intballYCorner, (int) Math.round(diameter), (int)Math.round(diameter));


      g.setColor(bigBallColor);
      g.fillOval(cat_intballXCorner, cat_intballYCorner, (int)Math.round(catDiameter), (int)Math.round(catDiameter));
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

  public boolean moveCat()
  {
    successmove = true;
    cat_sigmaX = catSpeed * (getxcenter_of_ball - cat_getxcenter_of_ball)/distance;
    cat_sigmaY = catSpeed * (getycenter_of_ball - cat_getycenter_of_ball)/distance;

    cat_getxcenter_of_ball += cat_sigmaX;
    cat_getycenter_of_ball += cat_sigmaY;

    cat_ballXCorner = cat_getxcenter_of_ball - catRadius;
    cat_ballYCorner = cat_getycenter_of_ball - catRadius;
    cat_intballXCorner = (int)Math.round(cat_ballXCorner);
    cat_intballYCorner = (int)Math.round(cat_ballYCorner);

    distance = Point2D.distance(cat_getxcenter_of_ball, cat_getycenter_of_ball, getxcenter_of_ball, getycenter_of_ball);
    if(distance <= catRadius + radius)
    {
      successmove = false;
    }

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

  public double CenterXofCat()
  {
    temp = cat_getxcenter_of_ball;
    return temp;
  }
  public double CenterYofCat()
  {
    temp = cat_getycenter_of_ball;
    return temp;
  }
  public double getDistance()
  {
    temp = distance;
    return temp;
  }

}
