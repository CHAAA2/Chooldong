package chooldong.window;

import chooldong.frame.ClassListWindowFrame;
import chooldong.request.Request;

import javax.swing.*;

public class StudentClassListWindow extends ClassListWindowFrame {
    static final char userType = 's';
    public StudentClassListWindow(String[] classList, String token) {
        super(classList, token);
    }

    @Override
    public void onCheckBtnClicked() {
        super.onCheckBtnClicked();
        String state = Request.dataRequest.getStudentChoolseockState(this.token, this.cl.getSelectedValue());
        JOptionPane.showMessageDialog(this, state);
    }

    @Override
    public void onChoolseokBtnClicked() {
        super.onChoolseokBtnClicked();
    }
}
