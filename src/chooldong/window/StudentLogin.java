package chooldong.window;

import chooldong.frame.ClassListWindowFrame;
import chooldong.frame.LogInFrame;
import chooldong.frame.RoundedButton;
import chooldong.request.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentLogin extends LogInFrame {
    public void init() {
        super.init();
        this.userType = 's';
    }

    public StudentLogin(AbstractDataRequest dataRequest, AbstractAuthRequest authRequest) {
        super(dataRequest, authRequest);
    }

    public StudentLogin() {
        super();
    }

    @Override
    public StudentClassListWindow getClassListWindow() {
        return new StudentClassListWindow(this.classList, this.token);
    }

    public static void main(String[] args) {
        StudentLogin sl = new StudentLogin();
        sl.showWindow();
    }

}
