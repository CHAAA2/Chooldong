package chooldong.frame;

import javax.swing.*;
import java.awt.*;

public class ChooldongPanel extends JPanel {
    private final Image img;

    public ChooldongPanel(Image img) {
        this.img = img;
    }
    public ChooldongPanel() {
        ImageIcon icon = new ImageIcon("res/ChooldongSub.jpg");
        this.img = icon.getImage(); // 이미지 객체
    }
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}