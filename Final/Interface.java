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
import java.text.DecimalFormat;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;


public class Interface extends JFrame 
{
    private JPanel Panel1, Panel2, startP, coordP, exitP;
    private JTextField inputEarth, xCoordEarth, yCoorsEarth;
    private final int widthUI = 1280, heightUI = 720, length_of_delay = 1000;
    private final double earthMotion = 100, refreshRate = 120.50, marsMotion = 100, moonMotion = 100;
    private int state = 0, refreshDelay, earthmotionDelay, marsMotionDelay, moonMotionDelay;
    private JButton startButton, pauseButton, exitButton;
    private JLabel assignment, name, inputEarthLabel, earthXYcoorsLabel;
    private panelGraphics space;
    private Timer earthClock, marsClock, moonClock, refreshClock;
    private buttonhandler buttons;
    private clockhandler clocks;
    private double earthSpeed, earthTic, marsSpeed, marsTic, moonSpeed, moonTic;
    

    public Interface()
    {
        super("Final Java");
        setLayout(new BorderLayout());
        setTitle("Orbit Simulation");
        setSize(widthUI, heightUI);
        setLocationRelativeTo(null);

        //Top Panel
        Panel1 = new JPanel();
        Panel1.setBackground(new Color(0,176,72));
        Panel1.setPreferredSize(new Dimension(1280,30));
        add(Panel1, BorderLayout.NORTH);
        assignment = new JLabel("CPSC 223J Final: Earth Orbit");
        name = new JLabel("By Emmanuel Salcedo");
        Panel1.add(assignment);
        Panel1.add(name);

        //Mid Panel
        space = new panelGraphics();
        space.setBackground(new Color(2,131,204));
        space.setSize(new Dimension(1280,580));
        add(space, BorderLayout.CENTER);

        //bottom Panel

        Panel2 = new JPanel();
        Panel2.setLayout(new GridLayout(1,3));
        Panel2.setBackground(new Color(175, 170, 255));
        add(Panel2, BorderLayout.SOUTH);

        startP = new JPanel();
        startP.setLayout(new GridLayout(0,1));
        startP.setBackground(new Color(175, 170, 255));
        Panel2.add(startP);

        coordP = new JPanel();
        coordP.setLayout(new GridLayout(0,1)); 
        coordP.setBackground(new Color(175, 170, 255));
        Panel2.add(coordP);

        exitP = new JPanel();
        exitP.setLayout(new GridLayout(1,1)); 
        exitP.setBackground(new Color(175, 170, 255));
        Panel2.add(exitP);

        startButton = new JButton("Start");
        startButton.setPreferredSize(new Dimension(10, 20));
        pauseButton = new JButton("Pause");
        exitButton = new JButton("Exit");

        inputEarthLabel = new JLabel("Input Earth Linear Speed pix/sec");
        earthXYcoorsLabel = new JLabel("X/Y coords of Earth");
        inputEarth = new JTextField();
        xCoordEarth = new JTextField();
        yCoorsEarth = new JTextField();
        startP.add(inputEarthLabel);
        startP.add(startButton);
        startP.add(inputEarth);

        coordP.add(earthXYcoorsLabel);
        coordP.add(xCoordEarth);
        coordP.add(yCoorsEarth);

        exitP.add(pauseButton);
        exitP.add(exitButton);


        //handlers
        buttons = new buttonhandler();
        startButton.addActionListener(buttons);
        pauseButton.addActionListener(buttons);
        exitButton.addActionListener(buttons);

        clocks = new clockhandler(); 
        space.orbitInit(0, 0, 0, 0, 0);

        refreshDelay = (int)Math.round(length_of_delay/refreshRate);
        refreshClock = new Timer(refreshDelay, clocks);

        earthmotionDelay = (int)Math.round(length_of_delay/earthMotion);
        earthClock = new Timer(earthmotionDelay, clocks);

        marsMotionDelay = (int)Math.round(length_of_delay/marsMotion);
        marsClock = new Timer(marsMotionDelay, clocks);
        
        moonMotionDelay = (int)Math.round(length_of_delay/moonMotion);
        moonClock = new Timer(moonMotionDelay, clocks);
        


    }

    private class clockhandler implements ActionListener
        {
            public void actionPerformed(ActionEvent event)
            {
                boolean animationContinue = false;
                if(event.getSource() == refreshClock);
                {
                    space.repaint();
                }   

                 if(event.getSource() == earthClock)
                {
                    animationContinue = space.moveEarth();
                    xCoordEarth.setText(String.format("%.2f", space.CenterXofEarth()));
                    yCoorsEarth.setText(String.format("%.2f", space.CenterYofEarth()));
                    if(!animationContinue)
                    {
                        earthClock.stop();
                        refreshClock.stop();
                        marsClock.stop();
                        moonClock.stop();
                    }
                }
                if(event.getSource() == marsClock)
                {
                    animationContinue = space.moveMars();
                    if(!animationContinue)
                    {
                        earthClock.stop();
                        marsClock.stop();
                        moonClock.stop();
                        refreshClock.stop();
                    }
                }
                if(event.getSource() == moonClock)
                {
                    animationContinue = space.moveMoon();
                    if(!animationContinue)
                    {
                        earthClock.stop();
                        refreshClock.stop();
                        marsClock.stop();
                        moonClock.stop();
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
                    earthSpeed = Double.parseDouble(inputEarth.getText());
                    earthTic = earthSpeed/earthMotion;
                    marsSpeed = Double.parseDouble(inputEarth.getText());
                    marsTic = marsSpeed/marsMotion;
                    moonSpeed = Double.parseDouble(inputEarth.getText());
                    moonTic = moonSpeed/moonMotion;
                    refreshClock.start();
                    earthClock.start();
                    marsClock.start();
                    moonClock.start();
                    space.orbitInit(600, 290, earthTic, marsTic, moonTic);

                }

                else if (event.getSource() == pauseButton)
                {
                    refreshClock.stop();
                    earthClock.stop();
                    marsClock.stop();
                    moonClock.stop();
                }   

                else if (event.getSource() == exitButton)
                {
                    System.exit(0);
                }
            }
        }
}
