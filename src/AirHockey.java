package src;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.*;
import java.util.Timer;

import javax.swing.*;


public class AirHockey extends JPanel implements KeyListener, Runnable, ActionListener {


    TimerTask timerTask2;
    Timer timer2;
    TimerTask timerTask;
    Timer timer;
    int ballx = 271;
        int bally = 319;
        int ballw = 50;
        int ballh = 50;

        int bat1x = 271;
        int bat1y = 620;
        int bat1w = 50;
        int bat1h = 50;

        int bat2x = 271;
        int bat2y = 0;
        int bat2w = 50;
        int bat2h = 50;

        int goal1x = 180;
        int goal1y = 675;
        int goal1w = 240;
        int goal1h = 5;

        int goal2x = 180;
        int goal2y = 0;
        int goal2w = 240;
        int goal2h = 5;

        String status = "unfinished";
        int scoreP1=0;
        int scoreP2=0;

        boolean left1 = false;
        boolean right1 = false;
        boolean left2 = false;
        boolean right2 = false;
        boolean up1 = false;
        boolean down1 = false;
        boolean up2 = false;
        boolean down2 = false;
        Random random = new Random();
        Gift gift = new Gift(0 , 0 , 0 , 0, 4, 0);

        Rectangle ball = new Rectangle(ballx, bally, ballw, ballh);
        Rectangle bat1 = new Rectangle(bat1x, bat1y, bat1w, bat1h);
        Rectangle bat2 = new Rectangle(bat2x, bat2y, bat2w, bat2h);
        Rectangle goal1= new Rectangle(goal1x, goal1y, goal1w, goal1h);
        Rectangle goal2= new Rectangle(goal2x, goal2y, goal2w, goal2h);

        LinkedList linkedList = new LinkedList<>();
        JButton back;
        JButton resume;
        boolean khar = false;
        boolean gav = false;
        long startTime = 0;
        boolean sag = false;
        int nobat = 5;

        boolean jayezeEstef = true;
        boolean end = false;
        int z = AirHockkey.tedadGoal.getLast();
        int w = AirHockkey.times.getLast();
        JFrame frame;
        Thread t1;
        //boolean pause = false;
        int number = 0;
        long timeElapsed = 0;





        public AirHockey() {

            frame = new JFrame();
            frame.setSize(640 , 725);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(null);
            frame.setLocationRelativeTo(null);
            //frame.addKeyListener(this);

            this.setSize(600, 725);
            this.setLayout(null);
            this.setFocusable(true);
            this.requestFocus();
            this.requestFocusInWindow();
            frame.add(this);
//            Main main = new Main();
//            frame.add(main);


            //frame.addKeyListener(this);
            //this.addKeyListener(this);
            //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //this.setLocationRelativeTo(null);
            //this.setResizable(false);
            startTime = System.nanoTime()/1000000000L;

            back = new JButton("back");
            back.setBounds(590,0,40,80);
            back.addActionListener(this);
            frame.add(back);
            resume = new JButton("resume");
            resume.setBounds(590 , 100 , 40 , 80);
            resume.addActionListener(this);
            frame.add(resume);

            if(z == 0){
                z = -1;
            }
            if(w == 0){
                w = -1;
            }


            //this.setVisible(true);
            //frame.pack();
//            frame.addKeyListener(this);
//            this.addKeyListener(this);


            t1 = new Thread(this::run);
            t1.start();

            //frame.addKeyListener(this);

            timerTask = new TimerTask() {
                @Override
                public void run() {
                    gift = new Gift(random.nextInt(530), random.nextInt(620), 50, 50, random.nextInt(3), 0);
                    //nobat = 5;
                    //khar = true;
                }
            };
            timer = new Timer();
            timer.schedule(timerTask, 10000, 15000);

            timerTask2 = new TimerTask() {
                @Override
                public void run() {
                    //gav = true;
                    if(gift.nafar == 0){
                        gift.x = gift.x - 20;
                        gift.y = gift.y - 20;
                        gift.height = 100;
                        gift.width =100;
                        repaint();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        gift = new Gift(0, 0, 0, 0, 4, 0);
                        //nobat = 5;
                    }
                    else {
                        gift = new Gift(0 , 0, 0, 0, gift.type , gift.nafar);
                        //nobat = 5;
                    }
                }
            };
            timer2 = new Timer();
            timer2.schedule(timerTask2, 15000, 15000);

            frame.addKeyListener(this);
            this.addKeyListener(this);

            frame.setVisible(true);










        }
        long sigma = 0;




        public void paint(Graphics g){
            super.paint(g);
            Image ballimg = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/soccer-ball.gif"));

            g.setColor(new Color(0 , 100 , 0));
            g.fillRect(0, 0, 595, 725);
            g.setColor(Color.LIGHT_GRAY);
            g.drawLine(0, 344, 800, 344);
            g.drawRect(0, 0, 593, 689);
            g.drawRect(100, 0, 400, 150);
            g.drawRect(100, 539, 400, 150);
            g.drawOval(196, 244, 200, 200);

            g.setColor(Frame31.colorP1);
            g.fillOval(bat1.x , bat1.y , bat1.width , bat1.height );
            g.setColor(Frame31.colorP2);
            g.fillOval(bat2.x , bat2.y , bat2.width , bat2.height );

            g.setColor(Color.BLACK);
            g.fill3DRect(goal1.x-30, goal1.y, goal1.width+60, goal1.height,true);
            g.fill3DRect(goal2.x-30, goal2.y, goal2.width+60, goal2.height,true);
            Font f = new Font("Arial", Font.BOLD, 20);
            g.setFont(f);
            g.setColor(Color.LIGHT_GRAY);
            g.drawString("Player 1: Score = " + String.valueOf(scoreP1), 210, 503);
            g.drawString("Player 2: Score = " + String.valueOf(scoreP2), 210, 200);
            long endTime = System.nanoTime()/1000000000L;

            timeElapsed = endTime - startTime + sigma;
            g.drawString( " time : " + String.valueOf(timeElapsed), 250 , 350 );
            g.drawImage(ballimg, ball.x, ball.y, ball.width, ball.height, this);


            if(timeElapsed == w){
                status = "Time Limit";
                end = true;
            }
            if(!end && (number%2 == 0)) {




            /*

            if(khar) {
                //gift = new Gift(random.nextInt(530), random.nextInt(620), 50, 50, random.nextInt(3), 0);

                if (gift.type == 0) {
                    g.setColor(new Color(120, 17, 134));
                } else if (gift.type == 1) {
                    g.setColor(new Color(10, 17, 134));
                } else if (gift.type == 2) {
                    g.setColor(new Color(120, 107, 234));

                }
                g.fillRect(gift.x, gift.y, 50, 50);
                //System.out.println("khar is " + khar + "Gav is " + gav);
                if (gav) {
                    //System.out.println(gift.nafar);
                    /*if (gift.nafar == 0) {
                        try {
                            g.fillRect(gift.x, gift.y, 100, 100);
                            Thread.sleep(100);
                            g.fillRect(gift.x, gift.y, 100, 100);
                        } catch (InterruptedException e) {
                            //throw new RuntimeException(e);
                        }
                    }


                    gift = new Gift(random.nextInt(530), random.nextInt(620), 50, 50, random.nextInt(3), 0);
                    khar = false;
                    gav = false;
                    nobat = 5;
                }
            }
            */


                if (gift.type == 0) {
                    g.setColor(Color.red);
                } else if (gift.type == 1) {
                    g.setColor(new Color(0, 0, 100));
                } else if (gift.type == 2) {
                    g.setColor(Color.white);

                }
                if (gift.type != 4) {
                    g.fillRect(gift.x, gift.y, gift.width, gift.height);
                }
            }




            g.setColor(Color.GREEN);
            if(end)
            {
                g.drawString(status, 240, 340);
            }

        }



        int movex = 7 - random.nextInt(15);
        int movey = (int) Math.sqrt(80-movex*movex);
        int batspeed=5;

        int v = 10;
        boolean daste1 = true;
        boolean daste2 = true;
        boolean ayne = false;

        @Override
        public void run() {

            while(!end ) {
                if(number%2 == 0) {
                    if (!ayne) {
                        if (ball.x >= 543) {
                            movex = -movex;
                        }
                        if (ball.x <= 10) {
                            movex = -movex;
                        }
                    } else if (ayne) {
                        if (ball.x >= 543) {
                            ball.x = 5;
                        }
                        if (ball.x <= 0) {
                            ball.x = 543;
                        }
                    }
                    if (bat1.x >= 535) {
                        bat1.x -= batspeed;
                    }
                    if (bat1.x <= 5) {
                        bat1.x += batspeed;
                    }
                    if (bat2.x >= 535) {
                        bat2.x -= batspeed;
                    }
                    if (bat2.x <= 5) {
                        bat2.x += batspeed;
                    }
                    if (daste1) {

                        if (bat1.intersects(ball)) {

                            Random rm = new Random();
                            if ((7 - rm.nextInt(15)) != movex) {
                                movex = 7 - rm.nextInt(15);
                            } else {
                                movex = movex + 1;
                            }
                            movey = -1 * (int) Math.sqrt(80 - movex * movex);
//                        //movex = 7;
//                        //movey = -6;
                            nobat = 1;


                        }
                    }
                    if (daste2) {
                        if (bat2.intersects(ball)) {

                            Random rm = new Random();
                            if ((7 - rm.nextInt(15)) != movex) {
                                movex = 7 - rm.nextInt(15);
                            } else {
                                movex = movex + 1;
                            }
                            movey = (int) Math.sqrt(80 - movex * movex);
                            //movex = 7;
                            //movey = 6;
                            nobat = 2;


                        }
                    }

                    if (ball.intersects(gift)) {
                        if (nobat == 1) {
                            gift.nafar = 1;
                            if (gift.type == 0) {
                                daste2 = false;
                                v = 6;
                            } else if (gift.type == 1) {
                                goal2.x = 130;
                                goal2.width = 340;
                            } else if (gift.type == 2) {
                                ayne = true;
                            }
                        } else if (nobat == 2) {
                            gift.nafar = 2;
                            if (gift.type == 0) {
                                daste1 = false;
                                v = 6;
                            } else if (gift.type == 1) {
                                goal1.x = 130;
                                goal1.width = 340;
                            } else if (gift.type == 2) {
                                ayne = true;
                            }
                        }

                        gift = new Gift(0, 0, 0, 0, 4, 6);
                        //nobat = 5;
                        timer.cancel();
                        timer2.cancel();
                        timerTask.cancel();
                        timerTask2.cancel();
                        timerTask = new TimerTask() {
                            @Override
                            public void run() {
                                gift = new Gift(random.nextInt(530), random.nextInt(620), 50, 50, random.nextInt(3), 0);
                                //nobat = 5;
                                //khar = true;
                            }
                        };
                        timer = new Timer();
                        timer.schedule(timerTask, 10000, 15000);

                        timerTask2 = new TimerTask() {
                            @Override
                            public void run() {
                                //gav = true;
                                if (gift.nafar == 0) {
                                    gift.x = gift.x - 20;
                                    gift.y = gift.y - 20;
                                    gift.height = 100;
                                    gift.width = 100;
                                    repaint();
                                    try {
                                        Thread.sleep(100);
                                    } catch (InterruptedException e) {
                                        throw new RuntimeException(e);
                                    }
                                    gift = new Gift(0, 0, 0, 0, 4, 0);
                                    //nobat = 5;
                                } else {
                                    gift = new Gift(0, 0, 0, 0, gift.type, gift.nafar);
                                    //nobat = 5;
                                }
                            }
                        };
                        timer2 = new Timer();
                        timer2.schedule(timerTask2, 15000, 15000);

                        //khar = false;


                    }


                    if (ball.y <= 0) {
                        movey = -movey;
                    }
                    if (ball.y >= 630) {
                        movey = -movey;
                    }
                    if (bat1.y <= 320) {
                        bat1.y += batspeed;
                    }
                    if (bat1.y >= 630) {
                        bat1.y -= batspeed;
                    }
                    if (bat2.y >= 310) {
                        bat2.y -= batspeed;
                    }
                    if (bat2.y <= 0) {
                        bat2.y += batspeed;
                    }

                    if (ball.intersects(goal1)) {
                        scoreP2++;
                        if (AirHockkey.margin.getLast() && z != -1) {
                            if (scoreP2 >= z && scoreP2 >= (scoreP1 + 2)) {

                                status = "Player 2 won";
                                repaint();
                                end = true;
                            }
                        } else {
                            if (scoreP2 == z) {

                                status = "Player 2 won";
                                repaint();
                                end = true;
                            }
                        }
                        if (end) {
                            break;
                        }
                        ball.x = ballx;
                        ball.y = 421;
                        bat1.x = bat1x;
                        bat1.y = bat1y;
                        bat2.x = bat2x;
                        bat2.y = bat2y;
                        goal1.x = 180;
                        goal1.width = 240;
                        goal2.x = 180;
                        goal2.width = 240;
                        daste1 = true;
                        daste2 = true;
                        v = 10;
                        //nobat = 5;
                        ayne = false;
                        movex = 0;
                        movey = 0;
                        repaint();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            //Logger.getLogger(AirHockey.class.getName()).log(Level.SEVERE, null, ex);
                        }


                    }
                    if (ball.intersects(goal2)) {
                        scoreP1++;
                        if (AirHockkey.margin.getLast() && z != -1) {
                            if (scoreP1 >= z && scoreP1 >= (scoreP2 + 2)) {

                                status = "Player 1 won";
                                repaint();
                                end = true;
                            }
                        } else {
                            if (scoreP1 == z) {

                                status = "Player 1 won";
                                repaint();
                                end = true;
                            }
                        }
                        if (end) {
                            break;
                        }
                        ball.x = ballx;
                        ball.y = 220;
                        bat1.x = bat1x;
                        bat1.y = bat1y;
                        bat2.x = bat2x;
                        bat2.y = bat2y;
                        goal1.x = 180;
                        goal1.width = 240;
                        goal2.x = 180;
                        goal2.width = 240;
                        daste1 = true;
                        daste2 = true;
                        //nobat = 5;
                        v = 10;
                        ayne = false;
                        movex = 0;
                        movey = 0;
                        repaint();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            //Logger.getLogger(AirHockey.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    ball.x += movex;
                    ball.y += movey;

                    if (left1 == true) {
                        bat1.x -= batspeed;
                        right1 = false;
                    }
                    if (right1 == true) {
                        bat1.x += batspeed;
                        left1 = false;
                    }
                    if (left2 == true) {
                        bat2.x -= batspeed;
                        right2 = false;
                    }
                    if (right2 == true) {
                        bat2.x += batspeed;
                        left2 = false;
                    }
                    if (up1 == true) {
                        bat1.y -= batspeed;
                        down1 = false;
                    }
                    if (down1 == true) {
                        bat1.y += batspeed;
                        up1 = false;
                    }
                    if (up2 == true) {
                        bat2.y -= batspeed;
                        down2 = false;
                    }
                    if (down2 == true) {
                        bat2.y += batspeed;
                        up2 = false;
                    }
                    repaint();
                    try {
                        Thread.sleep(v);
                    } catch (InterruptedException ex) {
                        //Logger.getLogger(AirHockey.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    //System.out.println("k");
//                    frame.addKeyListener(this);
//                    this.addKeyListener(this);
//                    frame.addKeyListener(this);
                    this.setFocusable(true);
                    this.requestFocus();
                    this.requestFocusInWindow();
                    startTime = System.nanoTime()/1000000000L;
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }


        @Override
        public void keyTyped(KeyEvent ke) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {
            int keycode = ke.getKeyCode();
            if(keycode==KeyEvent.VK_LEFT)
            {
                left1=true;
            }
            if(keycode==KeyEvent.VK_RIGHT)
            {
                right1=true;
            }
            if(keycode==KeyEvent.VK_UP)
            {
                up1=true;
            }
            if(keycode==KeyEvent.VK_DOWN)
            {
                down1=true;
            }
            if(keycode==KeyEvent.VK_A)
            {
                left2=true;
            }
            if(keycode==KeyEvent.VK_D)
            {
                right2=true;
            }
            if(keycode==KeyEvent.VK_W)
            {
                up2=true;
            }
            if(keycode==KeyEvent.VK_X)
            {
                down2=true;
            }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            int keyCode = ke.getKeyCode();
            if (keyCode == KeyEvent.VK_LEFT) {
                left1 = false;
            }

            if (keyCode == KeyEvent.VK_RIGHT) {
                right1 = false;
            }
            if (keyCode == KeyEvent.VK_UP) {
                up1 = false;
            }

            if (keyCode == KeyEvent.VK_DOWN) {
                down1 = false;
            }
            if (keyCode == KeyEvent.VK_A) {
                left2 = false;
            }

            if (keyCode == KeyEvent.VK_D) {
                right2 = false;
            }
            if (keyCode == KeyEvent.VK_W) {
                up2 = false;
            }

            if (keyCode == KeyEvent.VK_X) {
                down2 = false;
            }
        }


        @Override
        public void actionPerformed(ActionEvent e) {

            if(e.getSource().equals(back)) {
                linkedList.add(scoreP1);
                linkedList.add(scoreP2);
                AirHockkey.status.add(status);
                AirHockkey.goals.add(linkedList);
                frame.dispose();
                Frame31 frame31 = new Frame31();
                frame31.setVisible(true);
            }
            else if (e.getSource().equals(resume)) {
                number++;
                if(number %2 == 1){
                   // System.out.println(timeElapsed);
                    sigma = timeElapsed;
                }

            }


        }


    }



