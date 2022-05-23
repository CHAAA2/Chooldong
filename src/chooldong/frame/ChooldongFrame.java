package chooldong.frame;

import javax.swing.*;
import java.awt.*;

public class ChooldongFrame extends JFrame {
    public ChooldongPanel cp;
    public ChooldongFrame() {
        this.cp = new ChooldongPanel();
    }
    public void setDefault(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setContentPane(cp);
    }
    public void showWindow() {
        setVisible(true);
    }
}

