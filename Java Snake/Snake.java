

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.*;


public class Snake extends JFrame{

    Board game = new Board();
    public Snake()
    {
        initUI();
    }

    private void initUI()
    {
        add(game);
        setResizable(false);
        pack();

        setTitle("2nake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame ex = new Snake();
            ex.setVisible(true);
        });
    }
}
