package chooldong.window;
import chooldong.frame.ChooldongFrame;
import chooldong.frame.ChooldongPanel;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Welcome extends ChooldongFrame {

    public Welcome() {  // 인자 없이 생성
        init();
    }

    public void init() {
        ImageIcon icon = new ImageIcon("res/ChooldongTitle.jpg");
        Image img = icon.getImage(); // 이미지 객체
        this.cp = new ChooldongPanel(img);

        StudentOrTeacher sot = new StudentOrTeacher();
        setDefault();  // 상속됨
        setTitle("출동");
        cp.addMouseListener(new MouseAdapter() {  // 마우스 이벤트 리스너
            @Override
            public void mouseClicked(MouseEvent e) {  // 마우스 클릭시 실행
                sot.showWindow();  // sot.setVisible(true)
                dispose();  // 창 닫음
            }
        });
    }

    public static void main(String[] args) {  // 테스트용
        Welcome wc = new Welcome();
        wc.showWindow();
    }
}

