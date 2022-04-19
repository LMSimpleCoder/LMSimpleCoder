package creationalpattern.builder;

import utils.JFrameUtil;

import javax.swing.*;

// 产品
public class Parlour {
    private String wall;    //墙
    private String TV;    //电视
    private String sofa;    //沙发
    public void setWall(String wall) {
        this.wall = wall;
    }
    public void setTV(String TV) {
        this.TV = TV;
    }
    public void setSofa(String sofa) {
        this.sofa = sofa;
    }
    public void show() {
        String parlour = wall + TV + sofa;
        JFrame jf = JFrameUtil.getJframe(parlour,"建造者模式测试","A_Cattle.jpg");
        jf.setVisible(true);
    }
}
