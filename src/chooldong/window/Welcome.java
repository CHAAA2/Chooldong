package chooldong.window;
import chooldong.frame.ChooldongFrame;
import chooldong.request.AbstractAuthRequest;
import chooldong.request.AbstractDataRequest;
import chooldong.request.MockAuth;
import chooldong.request.MockData;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Welcome extends ChooldongFrame {
    AbstractAuthRequest authRequest;
    AbstractDataRequest dataRequest;

    public Welcome() {  // 인자 없이 생성
        this.dataRequest = new MockData();
        this.authRequest = new MockAuth();
        init();
    }

    public Welcome(AbstractDataRequest dataRequest, AbstractAuthRequest authRequest) {  // 요청 객체 지정
        this.authRequest = authRequest;
        this.dataRequest = dataRequest;
        init();
    }

    public void init() {
        setDefault();  // 상속됨
        setTitle("출동");

        cp.addMouseListener(new MouseAdapter() {  // 마우스 이벤트 리스너
            @Override
            public void mouseClicked(MouseEvent e) {  // 마우스 클릭시 실행
                StudentOrTeacher sot = new StudentOrTeacher(dataRequest, authRequest);
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

