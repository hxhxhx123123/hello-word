package com.hx;

import javax.swing.*;
import java.awt.*;

public class Hello extends JFrame {

    public Hello() {
        add(new Snake());
        setResizable(false);
        pack();
        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame ex = new Hello();
            ex.setVisible(true);
        });
    }
}
