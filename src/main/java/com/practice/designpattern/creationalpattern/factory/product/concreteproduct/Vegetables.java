package creationalpattern.factory.product.concreteproduct;

import creationalpattern.factory.product.abstractproduct.Plant;
import utils.JFrameUtil;

import javax.swing.*;

public class Vegetables implements Plant {
    JFrame jf;

    public Vegetables(String lx) {
        jf = JFrameUtil.getJframe(lx,"植物：蔬菜","P_Vegetables.jpg");
    }

    @Override
    public void show() {
        jf.setVisible(true);
    }
}
