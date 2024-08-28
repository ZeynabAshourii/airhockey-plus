package src;

import javax.swing.*;
import java.awt.*;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame21 extends JFrame implements ActionListener {
    JRadioButton timeLimited;
    JRadioButton goalLimited;
    JButton button1;
    TextField textField1;
    String x1;
    JButton button2;
    TextField textField2;
    String x2;
    JRadioButton checkbox;
    JButton start;
    JButton back;
    Frame21(){
        this.setSize(600 , 725);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        timeLimited = new JRadioButton("Time limited");
        goalLimited = new JRadioButton("Goal limited");
        this.add(timeLimited);
        this.add(goalLimited);
        timeLimited.setFocusable(false);
        goalLimited.setFocusable(false);
        timeLimited.setBounds(300 , 10 , 100 , 40);
        goalLimited.setBounds(190 , 10 , 100 , 40);
        //ButtonGroup group = new ButtonGroup();
        //group.add(timeLimited);
        //group.add(goalLimited);
        timeLimited.addActionListener(this);
        goalLimited.addActionListener(this);
        JLabel label = new JLabel();
        this.add(label);
        label.setBounds(50 , 300 , 420 , 30);

        label.setText("you must select at least on of the options and click on save");
        label.setForeground(new Color(200 , 0 , 70));
        start = new JButton(" Start !");
        this.add(start);
        start.setBounds(230 , 580 , 120 , 60);
        start.addActionListener(this);

        back = new JButton("back");
        back.setBounds(230, 500, 120, 60);
        this.add(back);
        back.addActionListener(this);
        AirHockkey.tedadGoal.add(0);
        AirHockkey.times.add(0);
        AirHockkey.margin.add(false);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(timeLimited)){
            textField2 = new TextField("Type how long you want to play");
            this.add(textField2);
            textField2.setBounds(140,200,300,40);
            button2 = new JButton("save");
            this.add(button2);
            button2.setBounds(50,200,80,40);
            button2.addActionListener(this);
        }
        else if (e.getSource().equals(goalLimited)) {
            checkbox = new JRadioButton("2margin");
            this.add(checkbox);
            checkbox.setBounds(140 , 145 , 300 , 40);
            checkbox.addActionListener(this);
            textField1 = new TextField("Type how point you want to play");
            this.add(textField1);
            textField1.setBounds(140,100,300,40);
            button1 = new JButton("save");
            this.add(button1);
            button1.setBounds(50,100,80,40);
            button1.addActionListener(this);
        }
        else if(e.getSource().equals(button1)) {
            x1 = textField1.getText();
            AirHockkey.tedadGoal.removeLast();
            AirHockkey.tedadGoal.add(Integer.valueOf(x1));
        }
        else if (e.getSource().equals(button2)) {
            x2 = textField2.getText();
            AirHockkey.times.removeLast();
            AirHockkey.times.add(Integer.valueOf(x2));
        }
        else if (e.getSource().equals(start)) {
            if(AirHockkey.times.getLast()==0 && AirHockkey.tedadGoal.getLast()==0) {
                JOptionPane.showMessageDialog(this, "you must select at least on of the options");
            }
            else {
                if(AirHockkey.times.getLast() > 0 && AirHockkey.tedadGoal.getLast() > 0){
                    if(AirHockkey.margin.getLast()){
                        AirHockkey.mode.add("Time limited : " + AirHockkey.times.getLast() + " Goal limited(2margin) : " + AirHockkey.tedadGoal.getLast() );
                    }
                    else{
                        AirHockkey.mode.add("Time limited : " + AirHockkey.times.getLast() + " Goal limited : " + AirHockkey.tedadGoal.getLast() );
                    }
                }
                else if (AirHockkey.tedadGoal.getLast() > 0){
                    if(AirHockkey.margin.getLast()){
                        AirHockkey.mode.add("Goal limited (2margin) : " + AirHockkey.tedadGoal.getLast());
                    }
                    else{
                        AirHockkey.mode.add("Goal limited : " + AirHockkey.tedadGoal.getLast());
                    }
                }
                else if (AirHockkey.times.getLast() > 0){
                    AirHockkey.mode.add("Time limited : " + AirHockkey.times.getLast());
                }
                dispose();
                Frame31 frame31 = new Frame31();
                frame31.setVisible(true);
            }
        }
        else if(e.getSource().equals(back)){
            dispose();
            MyFrame frame = new MyFrame();
            frame.setVisible(true);
        }
        else if (e.getSource().equals(checkbox)) {
            AirHockkey.margin.removeLast();
            AirHockkey.margin.add(true);
        }
    }

    public static void main(String[] args) {
        Frame21 frame21 = new Frame21();
    }
}
