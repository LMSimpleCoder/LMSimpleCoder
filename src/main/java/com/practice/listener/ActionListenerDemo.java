package com.practice.listener;

import java.awt.event.ActionListener;

import javax.swing.*;

public class ActionListenerDemo {


    public static void main(String[] args) {

        JFrame f = new JFrame();			//创建窗体
        JPanel p = new JPanel();			//创建面板
        JButton btn = new JButton("点我");	//创建一个按钮

        //外部类的实现

        //创建监听器ActionListener
        //new ActionListener();错误，接口不能new
        //创建实现子类InterfaceDemo
        ActionListener a = new InterfaceDemo();
        //将监听器InterfaceDemo绑定到btn按钮上
        btn.addActionListener(a);

        p.add(btn);							//将按钮添加到面板中
        f.add(p);							//将面板添加到窗体中

        f.setSize(400,300);					//设置窗体的大小
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭窗体的后台
        f.setVisible(true);					//设置窗体可见
    }
}
