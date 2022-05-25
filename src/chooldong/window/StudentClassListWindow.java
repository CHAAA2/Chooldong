package chooldong.window;

import chooldong.frame.ClassListWindowFrame;

public class StudentClassListWindow extends ClassListWindowFrame {
    static final char userType = 's';
    public StudentClassListWindow(String[] classList, String token) {
        super(classList, token);
    }
}
