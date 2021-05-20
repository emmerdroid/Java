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

public class panelGraphics extends JPanel{
    private double earthDiameter = 20.0, sunDiameter = 70.0, marsDiameter = 15.0, moonDiameter = 10.0; 
    private double cornEarthX, cornEarthY, earthCenterX, earthCenterY, earthsigmaX, earthsigmaY, sunCenterX, sunCenterY;
    private int earthXCorner, earthYCorner, width = 1280, height = 720, marsXCorner, marsYCorner, moonXCorner, moonYCorner;
    private double distance, theta = 0, orbitRadius = 20.0, deltaT, earthSpeed, marsSpeed,temp,moonSpeed;
    public boolean successmove;
    public double marsDistance, marsCenterX, marsCenterY,moonDistance, moonCenterX, moonCenterY;
    public double cornMarsX, cornMarsY, marsSigmaX, marsSigmaY, cornMoonX, cornMoonY, moonSigmaX, moonSigmaY;
    public double marsTheta = 0, marsDeltaT, moonTheta = 0, moonDeltaT;

    
    
    


    public void spaceGraphics()
    {
        setVisible(true);
    }

    public void orbitInit(double deltaX, double deltaY, double earthRate, double marsRate, double moonRate)
    {
      sunCenterX = 640.0;
      sunCenterY = 290.0;

      earthCenterX = 900.0; 
      earthCenterY = 290.0;

      moonCenterX = 930.0;
      moonCenterY = 290.0;

      marsCenterX = 970.0;
      marsCenterY = 290.0;


      earthSpeed = earthRate;
      marsSpeed = marsRate * .5;
      moonSpeed = moonRate * .3;
      
      
      distance = Math.sqrt(Math.pow(sunCenterX - earthCenterX, 2) + Math.pow(sunCenterY - earthCenterY, 2));
      marsDistance = Math.sqrt(Math.pow(sunCenterX - marsCenterX, 2) + Math.pow(sunCenterY - marsCenterY, 2));
      moonDistance = Math.sqrt(Math.pow(earthCenterX - moonCenterX, 2) + Math.pow(earthCenterY - moonCenterY, 2));
      
      cornEarthX = earthCenterX - (earthDiameter/2);
      cornEarthY = earthCenterY - (earthDiameter/2);  

      cornMarsX = marsCenterX - (marsDiameter/2);
      cornMarsY = marsCenterY - (marsDiameter/2);

      cornMoonX = moonCenterX - (moonDiameter/2);
      cornMoonY = moonCenterY - (moonDiameter/2);

      earthXCorner = (int)Math.round((cornEarthX));
      earthYCorner = (int)Math.round((cornEarthY));

      marsXCorner = (int)Math.round(cornMarsX);
      marsYCorner = (int)Math.round(cornMarsY);

      moonXCorner = (int)Math.round(cornMoonX);
      moonYCorner = (int)Math.round(cornMoonY);




    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        setBackground(Color.DARK_GRAY);
        g.setColor(Color.BLUE);
        g.fillOval(earthXCorner, earthYCorner, (int)Math.round(earthDiameter), (int)Math.round(earthDiameter));

        g.setColor(Color.YELLOW);
        g.fillOval(640, 290, (int)Math.round(sunDiameter), (int)Math.round(sunDiameter));

        g.setColor(Color.RED);
        g.fillOval(marsXCorner, marsYCorner, (int)Math.round(marsDiameter), (int)Math.round(marsDiameter));

        g.setColor(Color.WHITE);
        g.fillOval(moonXCorner, moonYCorner, (int)Math.round(moonDiameter), (int)Math.round(moonDiameter));
    }

    public boolean moveEarth()
    {
        successmove = true;
        deltaT = earthSpeed/distance;
        theta = theta + deltaT;

        earthsigmaX = sunCenterX + distance*Math.cos(theta);
        earthsigmaY = sunCenterY + distance*Math.sin(-theta);
        
        earthCenterX = earthsigmaX;
        earthCenterY = earthsigmaY;

        cornEarthX = earthCenterX - (earthDiameter/2);
        cornEarthY = earthCenterY - (earthDiameter/2);

        earthXCorner = (int)Math.round(cornEarthX);
        earthYCorner = (int)Math.round(cornEarthY);

        return successmove;
    }

    public boolean moveMars()
    {  
        successmove = true;
        marsDeltaT = marsSpeed/marsDistance;
        marsTheta = marsTheta + marsDeltaT;

        marsSigmaX = sunCenterX + marsDistance*Math.cos(marsTheta);
        marsSigmaY = sunCenterY + marsDistance*Math.sin(-marsTheta);

        marsCenterX = marsSigmaX;
        marsCenterY = marsSigmaY;

        cornMarsX = marsCenterX - (marsDiameter/2);
        cornMarsY = marsCenterY - (marsDiameter/2);
        
        marsXCorner = (int)Math.round(cornMarsX);
        marsYCorner = (int)Math.round(cornMarsY);

        return successmove;
    }

    public boolean moveMoon()
    {  
        successmove = true;
        moonDeltaT = moonSpeed/moonDistance;
        moonTheta = moonTheta + moonDeltaT;

        moonSigmaX = earthCenterX + moonDistance*Math.cos(moonTheta);
        moonSigmaY = earthCenterY + moonDistance*Math.sin(-moonTheta);

        moonCenterX = moonSigmaX;
        moonCenterY = moonSigmaY;

        cornMoonX = moonCenterX - (moonDiameter/2);
        cornMoonY = moonCenterY - (moonDiameter/2);
        
        moonXCorner = (int)Math.round(cornMoonX);
        moonYCorner = (int)Math.round(cornMoonY);

        return successmove;
    }

    public double CenterXofEarth()
    {
        temp = earthCenterX;
        return temp;
    }

    public double CenterYofEarth()
    {
        temp = earthCenterY;
        return temp;
    }

    
}
