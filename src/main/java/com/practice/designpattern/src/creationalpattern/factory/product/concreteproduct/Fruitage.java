package creationalpattern.factory.product.concreteproduct;

import creationalpattern.factory.product.abstractproduct.Plant;
import utils.JFrameUtil;

import javax.swing.*;

public class Fruitage implements Plant {
    JFrame jf;

    public Fruitage(String lx) {
        jf = JFrameUtil.getJframe(lx,"植物：水果","");
    }

    @Override
    public void show() {
        jf.setVisible(true);
    }
}
