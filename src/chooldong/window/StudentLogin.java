package chooldong.window;

import chooldong.frame.LogIn;
import chooldong.request.AbstractAuthRequest;
import chooldong.request.AbstractDataRequest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentLogin extends LogIn {
    public StudentLogin(AbstractDataRequest dataReq, AbstractAuthRequest authReq) {
        JButton choolBtn = new JButton("출석");
        choolBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onChoolBtnPressed();
            }  // 클래스 내에 출석버튼 press시 실행할 메소드 따로 선언함.
        });
        super.c.add(choolBtn);  // 슈퍼 클래스의 컨테이너에 출석 버튼 추가
    }

    @Override
    public void onViewBtnPressed() {
        super.onViewBtnPressed();
    }

    public void onChoolBtnPressed() {  // 버튼 눌렀을 때 동작
        System.out.println(this.idField.getText());
        System.out.println(this.pwField.getPassword());
    }
}
