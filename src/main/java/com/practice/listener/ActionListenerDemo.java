package com.practice.listener;

import javax.swing.*;

public class ActionListenerDemo {


    public static void main(String[] args) {

        JFrame f = new JFrame();			//��������
        JPanel p = new JPanel();			//�������
        JButton btn = new JButton("����");	//����һ����ť

        //�ⲿ���ʵ��

        //����������ActionListener
        //new ActionListener();���󣬽ӿڲ���new
        //����ʵ������InterfaceDemo
        listener.InterfaceDemo a = new listener.InterfaceDemo();
        //��������InterfaceDemo�󶨵�btn��ť��
        btn.addActionListener(a);

        p.add(btn);							//����ť��ӵ������
        f.add(p);							//�������ӵ�������

        f.setSize(400,300);					//���ô���Ĵ�С
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ùرմ���ĺ�̨
        f.setVisible(true);					//���ô���ɼ�
    }
}
