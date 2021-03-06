//Emmanuel Salcedo
//CPSC223 J Test 1


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


public class Test1Frame extends JFrame {
  private final int length_of_delay = 2500;
  private JButton clearButton;
  private JButton computeButton;
  private JButton exitButton;
  private JTextField input1;
  private JTextField input2;
  private JLabel inputSide1;
  private JLabel inputSide2;
  private JLabel area;
  private JLabel hypotenuse;
  private JLabel output1;
  private JLabel output2;
  private JLabel Welcome;
  private JLabel Name;
  private JLabel Slogan;
  private JLabel AreaIs;
  private JLabel HypIs;
  private JPanel Top;
  private JPanel Mid;
  private JPanel Bot;
  private String inputA;
  private String inputB;
  private String outputA;
  private String outputB;
  private double inputDoubA;
  private double inputDoubB;
  private double areaOut;
  private double hypOut;
  private boolean inputValid;
  private boolean successCalc;
  private Timer delayClosing;
  private Test1Operation operations;
  private Color custom = new Color(19, 126, 128);

  public Test1Frame()
  {
    super("Test 1");
    setLayout(new GridLayout(3,1));
    setTitle("Triangle Calculator");


    Top = new JPanel(new GridLayout(3,1));
    Top.setBackground(Color.gray);
    Top.setPreferredSize(new Dimension(450,75));
    add(Top);
    Welcome = new JLabel("Welcome to Triangle Computation");
    Welcome.setHorizontalAlignment(JLabel.CENTER);
    Name = new JLabel("Programmed by Emmanuel Salcedo");
    Name.setHorizontalAlignment(JLabel.CENTER);
    Slogan = new JLabel("Making sure your Triangles are right");
    Slogan.setHorizontalAlignment(JLabel.CENTER);
    Top.add(Welcome);
    Top.add(Name);
    Top.add(Slogan);

    Mid = new JPanel(new GridLayout(4,2));
    Mid.setBackground(custom);
    Mid.setPreferredSize(new Dimension(300,350));
    add(Mid);
    input1 = new JTextField(5);
    input2 = new JTextField(5);
    inputSide1 = new JLabel("Input side 1: ");
    inputSide2 = new JLabel("Input side 2: ");
    Mid.add(inputSide1);
    Mid.add(input1);
    Mid.add(inputSide2);
    Mid.add(input2);
    output1 = new JLabel();
    output2 = new JLabel();
    AreaIs = new JLabel("The area is: ");
    HypIs = new JLabel("The hypotenuse is: ");
    Mid.add(HypIs);
    Mid.add(output2);
    Mid.add(AreaIs);
    Mid.add(output1);

    Bot = new JPanel();
    Bot.setBackground(Color.lightGray);
    Bot.setPreferredSize(new Dimension(600,100));
    add(Bot);
    clearButton = new JButton("Clear");
    clearButton.setPreferredSize(new Dimension(150, 40));
    computeButton = new JButton("Compute");
    computeButton.setPreferredSize(new Dimension(150, 40));
    exitButton = new JButton("Quit");
    exitButton.setPreferredSize(new Dimension(150, 40));
    Bot.add(clearButton);
    Bot.add(computeButton);
    Bot.add(exitButton);


    buttonhandler myhandler = new buttonhandler();
    clearButton.addActionListener(myhandler);
    computeButton.addActionListener(myhandler);
    exitButton.addActionListener(myhandler);
    operations = new Test1Operation();
    delayClosing = new Timer(length_of_delay, myhandler);

  }
  private class buttonhandler implements ActionListener {
    public void actionPerformed(ActionEvent event) {

      if(event.getSource() == clearButton){
        input1.setText(null);
        input2.setText(null);
        outputA = input1.getText();
        outputB = input2.getText();
        output1.setText(null);
        output2.setText(null);

      }

      else if (event.getSource() == computeButton){
        successCalc = true;
        inputA = input1.getText();
        inputB = input2.getText();
        inputValid = operations.isFloat(inputA);
        if(inputValid)
        {
          inputDoubA = Double.parseDouble(inputA);
        }
        else
        {
            successCalc = false;
        }
        inputValid = operations.isFloat(inputB);

        if(inputValid)
        {
          inputDoubB = Double.parseDouble(inputB);
        }
        else
        {
          successCalc = false;
        }

        if(inputDoubA < 0 || inputDoubB < 0)
        {
          successCalc = false;
        }
        else
        {
          areaOut = operations.Area(inputDoubA, inputDoubB);
          hypOut = operations.Hypotenuse(inputDoubA, inputDoubB);
        }

        if(successCalc)
        {
          outputA = String.format("%.2f", areaOut);
          outputB = String.format("%.2f", hypOut);

          output1.setText(outputA);
          output2.setText(outputB);
        }
        else
        {
          output1.setText("Error");
          output2.setText("Error");
        }

      }
      else if (event.getSource() == exitButton){
        exitButton.setEnabled(false);
        computeButton.setEnabled(false);
        clearButton.setEnabled(false);
        delayClosing.start();
      }
      else if (event.getSource() == delayClosing)
      {
        System.exit(0);
      }
      else
      {
        System.out.println("Unknown Error");
      }

    }
  }




}
