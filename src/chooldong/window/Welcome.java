package chooldong.window;
import chooldong.frame.ChooldongFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Welcome extends ChooldongFrame {
    public Welcome() {
        setDefault();
        setTitle("출동");
        this.c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                StudentOrTeacher sot = new StudentOrTeacher();
                sot.showWindow();
                setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        Welcome wc = new Welcome();
        wc.showWindow();
    }
}
