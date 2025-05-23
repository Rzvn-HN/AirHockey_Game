package com.company;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class GameFrame extends JFrame{

    GamePanel panel ;

    GameFrame()  {

        panel = new GamePanel();
        this.add(panel);
        this.setTitle("Air Hockey Game!");
        this.setBackground(Color.gray);


        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);

    }



}
