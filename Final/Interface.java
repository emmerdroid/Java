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
    private JPanel Panel1, Panel2;
    private final int widthUI = 1280;
    private final int heightUI = 720;


    public Interface()
    {
        super("Final Java");
        setLayout(new BorderLayout());
        setTitle("Final Program");
        setSize(widthUI, heightUI);
        setLocationRelativeTo(null);

        //Top Panel
        Panel1 = new JPanel();
        Panel1.setBackground(new Color(2, 131, 204));
        Panel1.setPreferredSize(new Dimension(1280,100));
        add(Panel1, BorderLayout.NORTH);

        //Mid Panel
        Panel2 = new JPanel();
        Panel2.setBackground(new Color(0,176,72));
        Panel2.setPreferredSize(new Dimension(1280,620));
        add(Panel2, BorderLayout.CENTER);

    }
}
