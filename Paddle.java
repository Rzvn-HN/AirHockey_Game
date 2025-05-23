package com.company;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Paddle extends Rectangle {

    int id;
    int xVelocity;
    int yVelocity;
    int sy=10;
    int sx=10;

    Paddle(int x , int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id){
        super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
        this.id = id;

    }

    public void keyPressed (KeyEvent e){
        switch (id){
            case 1:
                if(e.getKeyCode()==KeyEvent.VK_W){
                    setYDirection(-sy);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_X){
                    setYDirection(sy);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_A){
                    setXDirection(-sx);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_D){
                    setXDirection(sx);
                    move();
                }
                break;
            case 2:
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    setYDirection(-sy);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    setYDirection(sy);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    setXDirection(-sx);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    setXDirection(sx);
                    move();
                }
                break;
        }

    }

    public void keyReleased (KeyEvent e){
        switch (id){
            case 1:
                if(e.getKeyCode()==KeyEvent.VK_W){
                    setYDirection(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_X){
                    setYDirection(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_A){
                    setXDirection(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_D){
                    setXDirection(0);
                    move();
                }
                break;
            case 2:
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    setYDirection(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    setYDirection(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    setXDirection(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    setXDirection(0);
                    move();
                }
                break;
        }


    }

    public void setYDirection (int yDirection){

        yVelocity = yDirection;

    }
    public void setXDirection (int xDirection){

        xVelocity = xDirection;

    }

    public void move (){
        y = y + yVelocity;
        x = x + xVelocity;

    }

    public void draw(Graphics g) {
        if(id==1)

            /*if(BeginningFrame.getPaddle1colorText.equals("red")){g.setColor(Color.red);}
            else if (BeginningFrame.getPaddle1colorText.equals("blue")){g.setColor(Color.blue);}*/
            g.setColor(Color.blue);





        else
           /* if(BeginningFrame.getPaddle2colorText.equals("red")){g.setColor(Color.red);}
            else if (BeginningFrame.getPaddle2colorText.equals("blue")){g.setColor(Color.blue);}*/
        g.setColor(Color.red);

        g.fillRect(x, y, width, height);



    }



}




