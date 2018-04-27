package com.codebind;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameGui {

    private JButton move1;
    private JPanel panelMain;
    private JButton move1Button;
    private JButton move2Button;
    private JButton move3Button;
    private JTextArea useYourMovesByTextArea;

    public GameGui() {

        move1Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(null, "Move 1 Complete.");
            }
        });
        move2Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(null, "Move 2 Complete.");
            }
        });
        move3Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(null, "Move 3 Complete.");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame1 = new JFrame("GameGui");
        frame1.setContentPane(new GameGui().panelMain);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.pack();
        frame1.setVisible(true);
    }
}
