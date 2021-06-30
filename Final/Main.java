//Emmanuel Salcedo
//Java Final

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

public class Main 
{ public static void main(String[] args)
    {
        Interface myframe = new Interface();
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myframe.setSize(1280, 720);
        myframe.setVisible(true);
        myframe.setResizable(false);

    }
    
}