package com.company;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{

    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = 500;
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    static final int BALL_DIAMETER = 50;
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT = 100;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle1;
    Paddle paddle2;
    Score score;
    Ball ball;

    GamePanel() {
        newPaddles();
        newBall();
        score = new Score(GAME_WIDTH,GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new ActionListener());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();

    }

    public void newBall() {
        ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),(GAME_HEIGHT/2)-(BALL_DIAMETER/2),BALL_DIAMETER/2,BALL_DIAMETER/2);

    }

    public void newPaddles() {
        paddle1 = new Paddle(0,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
        paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH ,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);
    }

    public void paint(Graphics g) {
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);

    }

    public void draw(Graphics g) {
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);

        //Toolkit.getDefaultToolkit().sync();

        //darvaze
        g.drawOval(-150,(GAME_HEIGHT/2)-150,300,300);
        g.drawOval(850,(GAME_HEIGHT/2)-150,300,300);


    }



    public void move() {
        paddle1.move();
        paddle2.move();
        ball.move();


    }

    public void checkCollision() {
        // paddle az safhe kharej nashe
        if(paddle1.y<=0)
            paddle1.y=0;
        if (paddle1.y>=(GAME_HEIGHT-PADDLE_HEIGHT))
            paddle1.y = GAME_HEIGHT- PADDLE_HEIGHT;
        if(paddle2.y<=0)
            paddle2.y=0;
        if (paddle2.y>=(GAME_HEIGHT-PADDLE_HEIGHT))
            paddle2.y = GAME_HEIGHT- PADDLE_HEIGHT;

        //paddle ha az zamin khodeshun kharej nashan
        if(paddle1.x>= (GAME_WIDTH/2)-PADDLE_WIDTH)
            paddle1.x=(GAME_WIDTH/2)-PADDLE_WIDTH;
        if (paddle1.x<=0)
            paddle1.x = 0;

        if(paddle2.x<=GAME_WIDTH/2)
            paddle2.x=GAME_WIDTH/2;
        if (paddle2.x>=GAME_WIDTH-25)
            paddle2.x = GAME_WIDTH - PADDLE_WIDTH;

        //ball az safhe kharej nashe
        if(ball.y <= 0) {
            ball.setYDirection(-ball.yVelocity);
        }
        if(ball.y >=GAME_HEIGHT-BALL_DIAMETER){
            ball.setYDirection(-ball.yVelocity);
        }

        if (ball.x +25 >= (paddle2.x  )){
            ball.xVelocity = Math.abs(ball.xVelocity);

            ball.setXDirection(-ball.xVelocity);
            ball.setYDirection(ball.yVelocity);


        }


        if(ball.intersects(paddle1)) {
            ball.xVelocity = Math.abs(ball.xVelocity);

            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);

        }
        if(ball.intersects(paddle2)) {
            ball.xVelocity = Math.abs(ball.xVelocity);

          ball.setXDirection(-ball.xVelocity);
            ball.setYDirection(ball.yVelocity);

        }

        //1 score ++
        if(ball.x<0 && ball.y>100 && ball.y<400){
            score.player2score++;
            newPaddles();
            newBall();
            System.out.println("player 2 score :"+score.player2score);
        }
        if(ball.x>GAME_WIDTH-BALL_DIAMETER && ball.y>100 && ball.y<400){
            score.player1score++;
            newPaddles();
            newBall();
            System.out.println("player 1 score :"+score.player1score);
        }

        }




    public void run() {

        // some kind of game loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double m = 0;
        while (true){
            long now = System.nanoTime();
            m += (now - lastTime)/ ns;
            lastTime = now;
            if (m>=1){
                move();
                checkCollision();
                repaint();
                m--;


            }
        }

    }

    public class ActionListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);

        }

        public void keyReleased(KeyEvent e) {
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);


        }


    }
}