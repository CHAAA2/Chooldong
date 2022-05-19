package chooldong.frame;

import javax.swing.*;
import java.awt.*;

public class ChooldongPanel extends JPanel {
    private ImageIcon icon = new ImageIcon("res/ChooldongSub.jpg");
    private Image img = icon.getImage(); // 이미지 객체
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}