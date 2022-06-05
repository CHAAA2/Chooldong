package chooldong.component;

import javax.swing.*;
import java.awt.*;

public class ChooldongIcon {
    public static ImageIcon absentIcon = new ImageIcon(getImage("res/absent.png", 100, 100));
    public static ImageIcon okIcon = new ImageIcon(getImage("res/ok.png", 100, 100));
    public static ImageIcon lateIcon = new ImageIcon(getImage("res/late.png", 100, 100));
    public static ImageIcon defaultIcon = new ImageIcon(getImage("res/default.png", 100, 100));

    public static Image getImage(String path, int width, int height) {
        ImageIcon ii = new ImageIcon(path);
        return ii.getImage().getScaledInstance(width, height, 0);
    }
}