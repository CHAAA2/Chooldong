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
            }
        });
        super.c.add(choolBtn);
    }

    @Override
    public void onViewBtnPressed() {
        super.onViewBtnPressed();
    }

    public void onChoolBtnPressed() {  // 버튼 눌렀을 때 동작할
        System.out.println(this.idField.getText());
        System.out.println(this.pwField.getPassword());
    }
}
