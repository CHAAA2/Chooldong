package chooldong.window;

import chooldong.frame.LogInFrame;
import chooldong.request.AbstractAuthRequest;
import chooldong.request.AbstractDataRequest;
import chooldong.request.MockAuth;
import chooldong.request.MockData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentLogin extends LogInFrame {
    public void slinit() {
        this.userType = 's';
        JButton choolBtn = new JButton("출석");
        choolBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onChoolBtnPressed();
            }  // 클래스 내에 출석버튼 press시 실행할 메소드 따로 선언함.
        });
        cp.add(choolBtn);  // 슈퍼 클래스의 컨테이너에 출석 버튼 추가
    }

    public StudentLogin(AbstractDataRequest dataRequest, AbstractAuthRequest authRequest) {
        this.dataRequest = dataRequest;
        this.authRequest = authRequest;
        slinit();
    }

    public StudentLogin() {
        this.dataRequest = new MockData();
        this.authRequest = new MockAuth();
        slinit();
    }

    public void onChoolBtnPressed() {  // 버튼 눌렀을 때 동작
        System.out.println(this.idField.getText());
        System.out.println(this.pwField.getPassword());
    }

    public static void main(String[] args) {
        StudentLogin sl = new StudentLogin();
        sl.showWindow();
    }
}
