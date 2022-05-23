package chooldong.window;

import chooldong.frame.LogIn;
import chooldong.frame.RoundedButton;
import chooldong.request.AbstractAuthRequest;
import chooldong.request.AbstractDataRequest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherLogin extends LogIn {
    public void tlInit() {
        RoundedButton gen = new RoundedButton("생성");
        gen.setBackground(Color.white);
        gen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onGenBtnPressed();
            }
        });
        cp.add(gen);

    }
    public TeacherLogin(AbstractDataRequest dataRequest, AbstractAuthRequest authRequest) {
        this.dataRequest = dataRequest;
        this.authRequest = authRequest;
        tlInit();
    }

    public TeacherLogin(){
        tlInit();
    }

    public void onGenBtnPressed() {
        System.out.println(this.idField.getText());
        System.out.println(this.pwField.getPassword());
    }

    public static void main(String[] args) {  // 테스트
        TeacherLogin tl = new TeacherLogin();
        tl.showWindow();
    }
}
