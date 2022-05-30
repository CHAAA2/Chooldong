package chooldong.window;

import chooldong.frame.ClassListWindowFrame;
import chooldong.request.Request;

import javax.swing.*;
import java.util.Objects;

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
        String state = Request.dataRequest.getStudentChoolseockState(this.token, this.cl.getSelectedValue());
        if (!Objects.equals(state, "미처리")) {
            JOptionPane.showMessageDialog(this, "이미 처리되었습니다.");
        } else {
            StudentCodeEnterWindow scew = new StudentCodeEnterWindow(this.token, this.cl.getSelectedValue());
            scew.setDefault();
            scew.showWindow();
        }
    }
}
