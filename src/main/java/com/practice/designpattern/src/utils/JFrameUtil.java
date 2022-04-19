package utils;

import javax.swing.*;
import java.awt.*;

public class JFrameUtil {

    public static JFrame getJframe(String lx,String title,String fileName) {
        JFrame jf = new JFrame(lx);
        Container container = jf.getContentPane();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,1));
        panel.setBorder(BorderFactory.createTitledBorder(title));
        JScrollPane sp = new JScrollPane(panel);
        container.add(sp,BorderLayout.CENTER);
        JLabel jLabel = new JLabel(new ImageIcon("src/source/image/" + fileName));
        panel.add(jLabel);
        jf.pack();
        jf.setVisible(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return jf;
    }
}
