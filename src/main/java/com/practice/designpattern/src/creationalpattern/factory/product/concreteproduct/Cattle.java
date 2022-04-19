package creationalpattern.factory.product.concreteproduct;

import creationalpattern.factory.product.abstractproduct.Animal;
import utils.JFrameUtil;

import javax.swing.*;

public class Cattle implements Animal {
    JFrame jf;

    public Cattle(String lx) {
        jf = JFrameUtil.getJframe(lx,"动物：牛","A_Cattle.jpg");
    }

    @Override
    public void show() {
        jf.setVisible(true);
    }
}
