package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Frame31 extends JFrame implements ActionListener {
    static Color colorP1;
    static Color colorP2;

    JButton bt_start;
    JButton button1;
    TextField textField1;
    JButton button2;
    TextField textField2;
    JButton back;
    LinkedList linkedList = new LinkedList<>();
    JLabel colp1;
    JLabel colp2;
    Button colop1;
    Button colop2;

    Frame31(){
        this.setSize(600 , 725);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        colp1 = new JLabel();
        colp1.setBounds(200,35,150,30);
        this.add(colp1);
        colp1.setText("Select Colour Player 1 :D");
        colp2 = new JLabel();
        colp2.setBounds(200,115,150,30);
        this.add(colp2);
        colp2.setText("Select Colour Player 2 :D");

        colop1 = new Button("Pick a color");
        colop1.setBounds(35 , 35 , 100 , 30);
        this.add(colop1);
        colop1.addActionListener(this);
        colop2 = new Button("Pick a color");
        colop2.setBounds(35 , 115 , 100 , 30);
        this.add(colop2);
        colop2.addActionListener(this);

        JLabel inst1 = new JLabel("1) Player 1: Use UP / DOWN / RIGHT / LEFT  arrow keys to move.");
        inst1.setBounds(40,180,420,30);
        this.add(inst1);
        inst1.setForeground(Color.BLUE);
        JLabel inst2 = new JLabel("2) Player 2: Use W for UP /X for DOWN/ D for RIGHT / A for LEFT keys to move.");
        inst2.setBounds(40,210,420,30);
        this.add(inst2);
        inst2.setForeground(Color.GREEN);
        JLabel inst3 = new JLabel("3) Player who scores 7 points wins the game.");
        inst3.setBounds(40,240,420,30);
        this.add(inst3);
        inst3.setForeground(Color.ORANGE);
        JLabel inst4 = new JLabel("You must click on Save");
        inst4.setBounds(40,440,420,30);
        this.add(inst4);
        inst4.setForeground(Color.red);



        bt_start = new JButton("Start new game !");
        bt_start.setBounds(200, 570, 200, 50);
        this.add(bt_start);
        bt_start.addActionListener(this);

        back = new JButton("back");
        back.setBounds(200, 500, 200, 50);
        this.add(back);
        back.addActionListener(this);

        textField1 = new TextField("What is the name of player1?");
        this.add(textField1);
        textField1.setBounds(140,300,300,40);
        button1 = new JButton("save");
        this.add(button1);
        button1.setBounds(50,300,80,40);
        button1.addActionListener(this);

        textField2 = new TextField("What is the name of player2?");
        this.add(textField2);
        textField2.setBounds(140,370,300,40);
        button2 = new JButton("save");
        this.add(button2);
        button2.setBounds(50,370,80,40);
        button2.addActionListener(this);


        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Frame31();
    }
    boolean f1 = false;
    boolean f2 = false;
    boolean q1 = false;
    boolean q2 = false;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(bt_start)){
            if(q1 == false || q2 == false){
                if(q2 == true){
                    JOptionPane.showMessageDialog(this, "click on save for player 1");
                }
                else if(q1 == true){
                    JOptionPane.showMessageDialog(this, "click on save for player 2");
                }
                else{
                    JOptionPane.showMessageDialog(this, "click on save for player 1 & 2");
                }
            }
            else {
                if (!f1) {
                    JOptionPane.showMessageDialog(this, "Select colour of player 1");
                } else if (!f2) {
                    JOptionPane.showMessageDialog(this, "Select colour of player 2");
                } else {
                    dispose();
                    AirHockey airHockey = new AirHockey();
                    airHockey.setVisible(true);
                }
            }
        }
        else if(e.getSource().equals(button1)) {
            //AirHockey.players.get(AirHockey.numberOfGames + 1).get(0) = textField1.getText();
            linkedList.add(textField1.getText());
            q1 = true;

        }
        else if (e.getSource().equals(button2)) {
            linkedList.add(textField2.getText());
            q2 = true;
            AirHockkey.players.add(linkedList);
        }
        else if (e.getSource().equals(back)) {
            dispose();
            Frame21 frame21 = new Frame21();
            frame21.setVisible(true);
        }
        else if(e.getSource().equals(colop1)){
            JColorChooser colorChooser = new JColorChooser();
            Color color = JColorChooser.showDialog(null, "Color Player1" , Color.BLACK);
            Frame31.colorP1 = color;
            colp1.setForeground(color);
            f1 =true;
        }
        else if(e.getSource().equals(colop2)){
            JColorChooser colorChooser = new JColorChooser();
            Color color = JColorChooser.showDialog(null, "Color Player2" , Color.BLACK);
            Frame31.colorP2 = color;
            colp2.setForeground(color);
            f2 = true;
        }
    }
}
