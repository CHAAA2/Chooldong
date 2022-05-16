package chooldong.frame;

import javax.swing.*;
import java.awt.*;

public class ChooldongFrame extends JFrame {
    protected Container c;
    public void setDefault(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        c = getContentPane();
        c.setLayout(new FlowLayout());
    }
    public void showWindow() {
        setVisible(true);
    }
}
