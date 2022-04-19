package com.practice.listener;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AnonymousEvent extends JFrame{
    JButton btn;

    public AnonymousEvent(){
        super("Java�¼���������");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn=new JButton("���");
        /*�����ڲ���******************************/
        btn.addActionListener(e -> {
            Container c=getContentPane();
            c.setBackground(Color.red);
        }
        );
        getContentPane().add(btn);

        setBounds(200,200,300,160);
        setVisible(true);
    }

    public static void main(String args[]){
        new AnonymousEvent();
    }
}
