package chooldong.window;

import chooldong.frame.ClassListWindowFrame;
import chooldong.request.Request;

public class TeacherClassListWindow extends ClassListWindowFrame {
    static final char userType = 't';
    public TeacherClassListWindow(String[] classList, String token) {
        super(classList, token);
        this.btnOne.setText("출석코드");
        this.btnTwo.setText("수동출석");
    }

    @Override
    public void onBtnOneClicked() {
        super.onBtnOneClicked();
        TeacherCodeSetWindow tcsw = new TeacherCodeSetWindow(this.token, this.cl.getSelectedValue());
        tcsw.setDefault();
        tcsw.showWindow();
    }

    @Override
    public void onBtnTwoClicked() {
        super.onBtnTwoClicked();
        String[] studentList = Request.dataRequest.getStudentList(this.cl.getSelectedValue());
        TeacherStudentChoolseokList tscl = new TeacherStudentChoolseokList(studentList, this.token, this.cl.getSelectedValue());
        tscl.showWindow();
    }
}
