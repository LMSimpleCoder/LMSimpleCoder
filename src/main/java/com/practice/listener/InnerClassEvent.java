package com.practice.listener;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InnerClassEvent extends JFrame{
        JButton btn;

public InnerClassEvent(){
        super("Java�¼���������");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn=new JButton("���");
        btn.addActionListener(new InnerClass());
        getContentPane().add(btn);

        setBounds(200,200,300,160);
        setVisible(true);
        }

/*�ڲ���*********************************/
class InnerClass implements ActionListener{
    @Override
    public void actionPerformed (ActionEvent e){
        Container c=getContentPane();
        c.setBackground(Color.red);
    }
}
    /**************************************/
    public static void main(String args[]){
        new InnerClassEvent();
    }
}
