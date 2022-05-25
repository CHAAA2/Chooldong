package chooldong.window;

import chooldong.frame.ClassListWindowFrame;
import chooldong.frame.LogInFrame;
import chooldong.frame.RoundedButton;
import chooldong.request.AbstractAuthRequest;
import chooldong.request.AbstractDataRequest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherLogin extends LogInFrame {
    public void init() {
        super.init();
        this.userType = 't';
    }

    @Override
    public ClassListWindowFrame getClassListWindow() {
        return new TeacherClassListWindow(this.classList, this.token);
    }

    public TeacherLogin(AbstractDataRequest dataRequest, AbstractAuthRequest authRequest) {
        super(dataRequest, authRequest);
    }

    public TeacherLogin(){
        super();
    }

}
