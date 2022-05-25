package chooldong.window;

import chooldong.frame.LogInFrame;

public class StudentLogin extends LogInFrame {
    public void init() {
        super.init();
        this.userType = 's';
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
