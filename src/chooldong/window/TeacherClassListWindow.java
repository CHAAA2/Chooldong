package chooldong.window;

import chooldong.frame.ClassListWindowFrame;
import chooldong.request.Request;

import javax.swing.*;

public class TeacherClassListWindow extends ClassListWindowFrame {
    static final char userType = 't';
    public TeacherClassListWindow(String[] classList, String token) {
        super(classList, token);
        this.choolseokBtn.setText("출석코드");
        this.checkBtn.setText("수동출석");
    }

    @Override
    public void onChoolseokBtnClicked() {
        super.onChoolseokBtnClicked();
        TeacherCodeSetWindow tcsw = new TeacherCodeSetWindow(this.token, this.cl.getSelectedValue());
        tcsw.setDefault();
        tcsw.showWindow();
    }

    @Override
    public void onCheckBtnClicked() {
        super.onCheckBtnClicked();
    }
}
