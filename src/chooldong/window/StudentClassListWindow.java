package chooldong.window;

import chooldong.ChooldongIcon;
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

    public String getChoolseokState() {
        return Request.dataRequest.getStudentChoolseockState(this.token, this.cl.getSelectedValue());
    }

    public void setUpperLabelIcon() {
        String state = getChoolseokState();
        switch (state) {
            case "출석" -> {
                this.stateLabel.setIcon(ChooldongIcon.okIcon);
            }
            case "미처리" -> {
                this.stateLabel.setIcon(ChooldongIcon.defaultIcon);
            }
            case "결석" -> {
                this.stateLabel.setIcon(ChooldongIcon.absentIcon);
            }
            case "지각" -> {
                this.stateLabel.setIcon(ChooldongIcon.lateIcon);
            }
        }
    }

    @Override
    public void onValueChanged() {
        super.onValueChanged();
        this.hello.setText(this.cl.getSelectedValue() + " 수업의 출석상태는 \"" + getChoolseokState() + "\" 입니다.");
        this.setUpperLabelIcon();
    }
}
