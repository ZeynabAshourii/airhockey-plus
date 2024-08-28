package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class MyFrame extends JFrame implements ActionListener {
    JButton game;
    JButton previousGames;
    JButton exit;
    MyFrame(){
        this.setSize(600 , 725);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        game = new JButton("Start new game");
        this.add(game);
        game.setBounds(220,200,140, 50);
        game.setFocusable(false);
        game.addActionListener(this);
        previousGames = new JButton("Previous games");
        this.add(previousGames);
        previousGames.setBounds(220 , 260 , 140 , 50);
        previousGames.setFocusable(false);
        previousGames.addActionListener(this);
        exit = new JButton("Exit");
        this.add(exit);
        exit.setBounds(220 , 320 , 140 , 50);
        exit.setFocusable(false);
        exit.addActionListener(this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(game)){
            dispose();
            Frame21 frame21 = new Frame21();
            frame21.setVisible(true);

        }
        else if(e.getSource().equals(previousGames)){
            dispose();
            Frame22 frame22 = new Frame22();
            frame22.setVisible(true);
        }
        else if(e.getSource().equals(exit)){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        MyFrame airHockey = new MyFrame();
    }

}
