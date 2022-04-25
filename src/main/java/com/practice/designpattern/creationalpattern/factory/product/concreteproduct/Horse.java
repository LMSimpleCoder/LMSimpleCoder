package creationalpattern.factory.product.concreteproduct;

import creationalpattern.factory.product.abstractproduct.Animal;
import utils.JFrameUtil;

import javax.swing.*;

public class Horse implements Animal {
    JFrame jf;

    public Horse(String lx) {
        jf = JFrameUtil.getJframe(lx,"动物：马","");
    }

    @Override
    public void show() {
        jf.setVisible(true);
    }
}
