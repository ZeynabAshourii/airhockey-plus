package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame51 extends JFrame implements ActionListener {
    JButton resume;
    JButton back;
    Frame51(){
        this.setSize(600 , 725);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        resume = new JButton("Resume");
        resume.setBounds(220 , 220 , 100 , 100);
        this.add(resume);
        resume.addActionListener(this);
        back = new JButton("Back");
        back.setBounds(220 , 340 , 100 , 100);
        this.add(back);
        back.addActionListener(this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(resume)){

        }
        else if (e.getSource().equals(back)) {

        }
    }

    public static void main(String[] args) {
        new Frame51();
    }
}
