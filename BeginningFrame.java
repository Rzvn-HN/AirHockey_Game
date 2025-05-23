package com.company;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

public class BeginningFrame extends JFrame{


    public static String getPaddle1colorText;
    public static String getPaddle2colorText;
    JTextField paddle1color ;
    JTextField paddle2color;




    public void setPaddle1color(JTextField paddle1color) {
        this.paddle1color = paddle1color;
    }



    public void setPaddle2color(JTextField paddle2color) {
        this.paddle2color = paddle2color;
    }



    public void setgetPaddle1colorText(JTextField paddle1color) {
        this.getPaddle1colorText = paddle1color.getText();
    }

    public void setgetPaddle2colorText(JTextField paddle2color) {
        this.getPaddle2colorText = paddle2color.getText();
    }



    BeginningFrame() {

        JTextField paddle1color ;
        JTextField paddle2color;
        String paddle1colorText ;
        String paddle2colorText;


       /*JFrame beginningframe = new JFrame();
        beginningframe.setTitle("Beginning Air Hockey GAME");
        beginningframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        beginningframe.setResizable(true);
        beginningframe.setSize(500,700);
       // beginningframe.setOpaque(true);
        beginningframe.setVisible(true);
       //beginningframe.add();
        beginningframe.pack();*/


        Object[] options = {"Playing",
                "History"};
        int n = JOptionPane.showOptionDialog(null,
                "WELCOME TO AIRHOCKEY GAME, your order:",
                "Air Hockey", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);


        if (n == 0) {

            Object[] options2 = {"Time limited",
                    "Point limited"};
            int n2 = JOptionPane.showOptionDialog(null,
                    "Choose your mood, please",
                    "Air Hockey",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options2,
                    options2[0]);

            if (n2 == 0) {
                JTextField TopTime = new JTextField(15);
                JPanel topTimePanel = new JPanel(new GridBagLayout());
                GridBagConstraints tt = new GridBagConstraints();
                tt.insets = new Insets(5, 5, 5, 5);
                tt.weightx = 1.0;
                tt.weighty = 1.0;
                tt.anchor = GridBagConstraints.WEST;
                topTimePanel.add(new JLabel("Type your time limit"), tt);
                tt.gridx = 1;
                tt.anchor = GridBagConstraints.EAST;
                topTimePanel.add(TopTime, tt);


                int resultTT = JOptionPane.showConfirmDialog(null, topTimePanel,
                        "Air hockey", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (resultTT == JOptionPane.OK_OPTION) {
                    paddle1color = new JTextField(15);
                    paddle2color = new JTextField(15);
                    JPanel moreComplexPanel = new JPanel(new GridBagLayout());
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.insets = new Insets(5, 5, 5, 5);
                    gbc.weightx = 1.0;
                    gbc.weighty = 1.0;
                    gbc.anchor = GridBagConstraints.WEST;
                    moreComplexPanel.add(new JLabel("Paddle one color(red/blue):"), gbc);
                    gbc.gridx = 1;
                    gbc.anchor = GridBagConstraints.EAST;
                    moreComplexPanel.add(paddle1color, gbc);
                    gbc.gridx = 0;
                    gbc.gridy = 1;
                    gbc.anchor = GridBagConstraints.WEST;
                    moreComplexPanel.add(new JLabel("Paddle two color(red/blue):"), gbc);
                    gbc.gridx = 1;
                    gbc.anchor = GridBagConstraints.EAST;
                    moreComplexPanel.add(paddle2color, gbc);

                    int result = JOptionPane.showConfirmDialog(null, moreComplexPanel,
                            "Air hockey", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (result == JOptionPane.OK_OPTION) {
                        Object[] options3 = {"START!",};
                        int n3 = JOptionPane.showOptionDialog(null,
                                "So let's do it!",
                                "Air Hockey",
                                JOptionPane.YES_NO_CANCEL_OPTION,
                                JOptionPane.PLAIN_MESSAGE,
                                null,
                                options3,
                                options3[0]);
                        if (n==0){
                            GameFrame frame = new GameFrame();
                        }
                    }


                }
            }

        else if (n2 == 1) {
            JTextField TopScore = new JTextField(15);
            JPanel topScorePanel = new JPanel(new GridBagLayout());
            GridBagConstraints ts = new GridBagConstraints();
            ts.insets = new Insets(5, 5, 5, 5);
            ts.weightx = 1.0;
            ts.weighty = 1.0;
            ts.anchor = GridBagConstraints.WEST;
            topScorePanel.add(new JLabel("Type your point limited"), ts);
            ts.gridx = 1;
            ts.anchor = GridBagConstraints.EAST;
            topScorePanel.add(TopScore, ts);

            int resultTS = JOptionPane.showConfirmDialog(null, topScorePanel,
                    "Air hockey", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);


            if (resultTS == JOptionPane.OK_OPTION) {
                paddle1color = new JTextField(15);
                paddle2color = new JTextField(15);
                JPanel moreComplexPanel = new JPanel(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(5, 5, 5, 5);
                gbc.weightx = 1.0;
                gbc.weighty = 1.0;
                gbc.anchor = GridBagConstraints.WEST;
                moreComplexPanel.add(new JLabel("Paddle one color(red/blue):"), gbc);
                gbc.gridx = 1;
                gbc.anchor = GridBagConstraints.EAST;
                moreComplexPanel.add(paddle1color, gbc);
                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.anchor = GridBagConstraints.WEST;
                moreComplexPanel.add(new JLabel("Paddle two color(red/blue):"), gbc);
                gbc.gridx = 1;
                gbc.anchor = GridBagConstraints.EAST;
                moreComplexPanel.add(paddle2color, gbc);

                int result = JOptionPane.showConfirmDialog(null, moreComplexPanel,
                        "Air hockey", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (result == JOptionPane.OK_OPTION) {
                    Object[] options3 = {"START!",};
                    int n3 = JOptionPane.showOptionDialog(null,
                            "So let's do it!",
                            "Air Hockey",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            options3,
                            options3[0]);

                    if (n==0){
                        GameFrame frame = new GameFrame();
                    }
                }
            }


        }

    }
            }


        }














