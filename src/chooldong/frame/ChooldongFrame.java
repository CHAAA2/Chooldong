package chooldong.frame;

import javax.swing.*;

/*
프로젝트에서 공통적으로 사용할 JFrame 설정
 */
public class ChooldongFrame extends JFrame {
    public ChooldongPanel cp;
    public ChooldongFrame() {
        this.cp = new ChooldongPanel();
    }
    public void setDefault(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800,600);
        setContentPane(cp);
    }
    public void showWindow() {
        setVisible(true);
    }

}

