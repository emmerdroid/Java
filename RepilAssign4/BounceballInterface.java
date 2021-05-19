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
//Date Project began: 2021-Apr-17
//Date of last update: 2021-May-10
//Status: Work in Progress
//Purpose: This program is meant to be the UI of the program.
//This module contains the interface for the user to input speeds for both cat and mouse and the direction of the mouse.
//BallGraphics.java
//Compile: javac BounceballInterface.java
//This module called from the Main class
// Purpose: Continuation of practicing with moving java graphics with not only straight lines
// but also with curved lines that update to one's motion





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
import java.awt.Graphics;
import java.awt.BasicStroke;
import java.text.DecimalFormat;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;


public class BounceballInterface extends JFrame {
  private final int length_of_delay = 1000;
  private final int widthUI = 1280;
  private final int heightUI = 720;
  private int refreshDelay;
  private int motionDelay;
  private int catMotionDelay;
  private Timer delayClosing;
  private Timer refreshClock;
  private Timer motionClock;
  private Timer catMotionClock;
  private JButton clearButton;
  private JButton startButton;
  private JButton quitButton;
  private JPanel Top;
  private final int topWidth = widthUI;
  private final int topHeight = 50;
  private JPanel ButtonA;
  private JPanel ButtonB;
  private JPanel ButtonC;
  private JPanel Bottom;
  private final int BottomWidth = widthUI;
  private final int BottomHeight = 100;
  private JLabel refRate;
  private JLabel speedLabel;
  private JLabel dirLabel;
  private JTextField refreshRateText;
  private JTextField speed;
  private JTextField direction;
  private double texttoRefresh;
  private double texttoSpeed;
  private double texttoDirection;
  private final double motion_clock_rate  = 100.0;
  private final double cat_motion_rate = 100.0;
  private final double refresh_clock_rate = 120.50;
  private double catClock;
  private JLabel ballLoc;
  private JLabel xLabel;
  private JLabel yLabel;
  private double xCoord;
  private double yCoord;
  private JTextField xText;
  private JTextField yText;
  private double deltaX;
  private double deltaY;
  private JLabel name;
  private JLabel assignment;
  private String startText;
  private String resumeText;
  private String pauseText;
  private Color CPanel1 = new Color(193,230,254);
  private Color CPanel2 = new Color(  0,100,165);
  private Color CPanel3 = new Color(155, 70,200);
  private Color CPanel4 = new Color(230,126, 34);
  private BallGraphics ball;
  private boolean on = false;
  private boolean show = false;
  private int state = 1;
  private DecimalFormat df;
  private double ballSpeedSec;
  private double ballSpeedTic;
  private final int ballPanelWidth = widthUI;
  private final int ballPanelHeight = heightUI - topHeight - BottomHeight;
  private Clockhandler myclock;




  public BounceballInterface()
  {
    super("Program 4");
    setLayout(new BorderLayout());
    setTitle("Cat and Mouse");
    setSize(widthUI, heightUI);
    setLocationRelativeTo(null);
    //top panel
    Top = new JPanel();
    Top.setBackground(CPanel1);
    Top.setSize(topWidth, topHeight);
    add(Top, BorderLayout.NORTH);
    assignment = new JLabel("CPSC 233J Assignment 4");
    name = new JLabel("By Emmanuel Salcedo");
    Top.add(assignment);
    Top.add(name);
    //middle panel
    //import the ball graphics
    ball = new BallGraphics();
    ball.setBackground(CPanel2);
    ball.setSize(ballPanelWidth, ballPanelHeight);
    add(ball, BorderLayout.CENTER);

    //Bottom
    Bottom = new JPanel();
    Bottom.setLayout(new GridLayout(0,2));
    Bottom.setBackground(CPanel3);
    ButtonA = new JPanel();
    ButtonA.setLayout(new GridLayout(3,3));
    ButtonA.setBackground(CPanel4);
    ButtonB = new JPanel();
    ButtonB.setLayout(new FlowLayout());
    ButtonB.setBackground(CPanel4);
    add(Bottom, BorderLayout.SOUTH);
    Bottom.add(ButtonA);
    Bottom.add(ButtonB);

    clearButton = new JButton("Clear");
    startButton = new JButton("Start");
    quitButton = new JButton("Quit");

    ButtonA.add(startButton);
    ButtonA.add(clearButton);
    ButtonA.add(quitButton);

    refRate = new JLabel("Cat Speed");
    speedLabel = new JLabel("Speed (pix/sec)");
    dirLabel = new JLabel("Direction");
    refreshRateText = new JTextField();
    speed = new JTextField();
    direction = new JTextField();
    ButtonA.add(refRate);
    ButtonA.add(speedLabel);
    ButtonA.add(dirLabel);
    ButtonA.add(refreshRateText);
    ButtonA.add(speed);
    ButtonA.add(direction);

    ballLoc = new JLabel("Ball's Location");
    xLabel = new JLabel("Distance Between: ");
    //yLabel = new JLabel("Y: ");
    xText = new JTextField("000.00");
    //yText = new JTextField("000.00");
    ButtonB.add(ballLoc);
    ButtonB.add(xLabel);
    ButtonB.add(xText);
    //ButtonB.add(yLabel);
    //ButtonB.add(yText);
    //buttonhandler
    buttonhandler myhandler = new buttonhandler();
    clearButton.addActionListener(myhandler);
    startButton.addActionListener(myhandler);
    quitButton.addActionListener(myhandler);

    //clockhandler
    myclock = new Clockhandler();
    ball.BallMovement(0,0,0);
    //clocks
    refreshDelay = (int)Math.round(length_of_delay/refresh_clock_rate);
    refreshClock = new Timer(refreshDelay, myclock);

    motionDelay = (int)Math.round(length_of_delay/motion_clock_rate);
    motionClock = new Timer(motionDelay, myclock);

    catMotionDelay = (int)Math.round(length_of_delay/cat_motion_rate);
    catMotionClock = new Timer(motionDelay, myclock);






  }

  private class Clockhandler implements ActionListener
  {
    public void actionPerformed (ActionEvent event)
    {
      boolean animationContinue = false;
      if(event.getSource() == refreshClock)
      {
        ball.repaint();
      }
      else if(event.getSource() == motionClock)
      {
        animationContinue = ball.moveBall();
        xCoord = ball.getDistance();
        //yCoord = ball.CenterYofBall();
        xText.setText(String.format("%.2f", xCoord));
        //yText.setText(String.format("%.2f",yCoord));
        if(!animationContinue)
        {
          motionClock.stop();
          refreshClock.stop();
          catMotionClock.stop();
          startButton.setEnabled(true);

        }
      }
      else if(event.getSource() == catMotionClock)
      {
        animationContinue = ball.moveCat();
        xCoord = ball.CenterXofCat();
        yCoord = ball.CenterYofCat();

        if(!animationContinue)
        {
          motionClock.stop();
          catMotionClock.stop();
          refreshClock.stop();
          startButton.setText("Start");
          startButton.setEnabled(true);
        }
      }
    }


  }

  private class buttonhandler implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
      {
        if(event.getSource() == startButton)
        {
          if(state == 1)
          {
            state++;
          }
          if(on)
          {
            refreshClock.stop();
            motionClock.stop();
            catMotionClock.stop();
            startButton.setText("Resume");
            on = false;
          }
          else
          {
            refreshClock.start();
            motionClock.start();
            catMotionClock.start();
            startButton.setText("Pause");
            on = true;
          }
          if(state == 2)
          {
            ballSpeedSec = Double.parseDouble(speed.getText());
            ballSpeedTic = ballSpeedSec/motion_clock_rate;

            texttoSpeed = Double.parseDouble(speed.getText());
            texttoDirection = Double.parseDouble(direction.getText());
            texttoSpeed = texttoSpeed/motion_clock_rate;
            double angle = Math.toRadians(texttoDirection);
            deltaX = Math.cos(angle) * texttoSpeed;
            deltaY = Math.sin(angle) * texttoSpeed;
            catClock = Double.parseDouble(refreshRateText.getText());
            catClock = catClock/motion_clock_rate;
            ball.BallMovement(deltaX, deltaY, catClock);
            state = 0;
          }
        }


        else if (event.getSource() == clearButton)
        {
          show = false;
          speed.setText(null);
          direction.setText(null);
          refreshRateText.setText(null);
          startButton.setText("Start");
          xText.setText("000.00");
          //yText.setText("000.00");
          ball.BallMovement(deltaX, deltaY, catClock);

          state = 1;
          ball.repaint();
          startButton.setEnabled(true);
        }



        else if (event.getSource() == quitButton)
        {
          System.exit(0);
        }


      }

    }
  }
