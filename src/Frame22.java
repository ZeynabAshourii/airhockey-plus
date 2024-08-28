package src;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.LinkedList;

public class Frame22 extends JFrame implements ActionListener {
    final String[] columnNames;
    final DefaultTableModel tableModel;
    JTable table;
    JButton back;
    Frame22(){
        this.setSize(600 , 725);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        back = new JButton("back");
        this.add(back , BorderLayout.AFTER_LAST_LINE);
        back.setBounds(0,0,100, 50);
        back.setFocusable(false);
        back.addActionListener(this);
        columnNames = new String[]{"P1 : goal1 / P2 : goal2" , "Status" , "Mode"};
        //
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        //table.setBounds(0 , 0 , 60 , 700);
        //
        table.setEnabled(false);

        JScrollPane p = new JScrollPane();




//        for(int i = 0; i < AirHockkey.players.size(); i++){
//            TextArea textArea = new TextArea();
//            this.add(textArea);
//            textArea.setBounds(0 , 50 + 100*i , 600 , 100);
//            textArea.setText(AirHockkey.players.get(i).get(0) + " : " + AirHockkey.goals.get(i).get(0) + " " + AirHockkey.players.get(i).get(1) + " : " + AirHockkey.goals.get(i).get(1) + "\n" + "vaziat bazi : " + AirHockkey.status.get(i) + "\n" + "game mode : " + AirHockkey.mode.get(i));
//            //textArea.setText(AirHockkey.players.get(i).get(0) + " " + AirHockkey.players.get(i).get(1) );
//            //textArea.setText(AirHockkey.players.get(i).get(0) + " : " + AirHockkey.goals.get(i).get(0) + " " + AirHockkey.players.get(i).get(1) + " : " + AirHockkey.goals.get(i).get(1) + "\n" + "vaziat bazi : " + AirHockkey.status.get(i) + "\n" );

//        }

        p.setViewportView(table);

//        p.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
//            @Override
//            public void adjustmentValueChanged(AdjustmentEvent e) {
//                if(!e.getValueIsAdjusting()) {
//                    JScrollBar source = (JScrollBar) e.getAdjustable();
//                    int extent = source.getModel().getExtent();
//                    int maximum = source.getModel().getMaximum();
//                    if (e.getValue() + extent == maximum) {
//                        retrieveData();
//                    }
//                }
//            }
//        });


        retrieveData();


        this.add(p, BorderLayout.NORTH);

        this.setVisible(true);
    }
    private void retrieveData(){

        for (int i = 0; i < AirHockkey.players.size(); i++){
            Object[] rowData = new Object[columnNames.length];
            //
            rowData[0] = AirHockkey.players.get(i).get(0) + " : " + AirHockkey.goals.get(i).get(0) + " " + AirHockkey.players.get(i).get(1) + " : " + AirHockkey.goals.get(i).get(1);
            rowData[1] = AirHockkey.status.get(i);
            rowData[2] = AirHockkey.mode.get(i);
            //
            tableModel.addRow(rowData);
        }
        for(int i = 0; i < 26; i ++){

            Object[] rowData = new Object[columnNames.length];
            rowData[0] = "";
            rowData[1] = "";
            rowData[2] = "";
            tableModel.addRow(rowData);
        }

        //tableModel.fireTableDataChanged();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(back)){
            dispose();
            MyFrame frame = new MyFrame();
            frame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Frame22();
    }

}
