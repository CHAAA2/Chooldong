package chooldong.window;

import chooldong.frame.ClassListWindowFrame;
import chooldong.frame.LogInFrame;

public class TeacherLogin extends LogInFrame {
    public void init() {
        super.init();
        this.userType = 't';
    }

    @Override
    public ClassListWindowFrame getClassListWindow() {
        return new TeacherClassListWindow(this.classList, this.token);
    }

    public TeacherLogin(){
        super();
    }

}
