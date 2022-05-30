package chooldong.window;

import chooldong.frame.ClassListWindowFrame;

public class TeacherClassListWindow extends ClassListWindowFrame {
    static final char userType = 't';
    public TeacherClassListWindow(String[] classList, String token) {
        super(classList, token);
    }

    @Override
    public void onChoolseokBtnClicked() {
        super.onChoolseokBtnClicked();
        TeacherCodeSetWindow tcsw = new TeacherCodeSetWindow(this.token, this.cl.getSelectedValue());
        tcsw.setDefault();
        tcsw.showWindow();
    }
}
