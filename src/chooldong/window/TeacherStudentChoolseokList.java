package chooldong.window;

import chooldong.component.ChooldongIcon;
import chooldong.frame.ListWindowFrame;
import chooldong.component.ChooldongBtn;
import chooldong.request.Request;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class TeacherStudentChoolseokList extends ListWindowFrame {
    String lectureName;
    ChooldongBtn lateBtn;

    public TeacherStudentChoolseokList(String[] listArray, String token, String lectureName) {
        super(listArray, token);
        this.cp.setLayout(new GridLayout());
        this.lectureName = lectureName;

        this.btnOne.setText("출석");
        this.btnTwo.setText("결석");
        this.lateBtn = new ChooldongBtn("지각");
        this.btnPanel.setLayout(new GridLayout(3, 1));
        this.btnPanel.add(lateBtn);
        this.lateBtn.setEnabled(false);

        this.lateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onLateBtnClicked();
            }
        });
        this.middlePanel.remove(2);
        this.middlePanel.setLayout(new GridLayout(2,1 ));
    }

    public void updateChoolseokState() {
        HashMap<String, String> choolseokState = Request.dataRequest.getTeacherChoolseokState(this.token, this.lectureName);
        String state = choolseokState.get(this.cl.getSelectedValue());
        switch (state) {
            case "결석" -> this.middleLabel.setIcon(ChooldongIcon.absentIcon);
            case "미처리" -> this.middleLabel.setIcon(ChooldongIcon.defaultIcon);
            case "지각" -> this.middleLabel.setIcon(ChooldongIcon.lateIcon);
            case "출석" -> this.middleLabel.setIcon(ChooldongIcon.okIcon);
        }
        this.middleLabel.setText(state);
    }

    @Override
    protected void setBtnEnable() {
        super.setBtnEnable();
        this.lateBtn.setEnabled(true);
    }

    @Override
    public void onValueChanged() {
        super.onValueChanged();
        System.out.println(this.cl.getSelectedValue());
        ImageIcon icon = Request.dataRequest.getPicture(this.cl.getSelectedValue());
        icon.setImage(icon.getImage().getScaledInstance(200, 280, 0));
        this.upperLabel.setIcon(icon);
        updateChoolseokState();
    }

    public void setChoolseokState(String state) {
        Request.dataRequest.setManualChoolseockState(this.token, this.lectureName, this.cl.getSelectedValue(), state);
    }

    @Override
    public void onBtnOneClicked() {
        super.onBtnOneClicked();
        setChoolseokState("출석");
        updateChoolseokState();
    }

    @Override
    public void onBtnTwoClicked() {
        setChoolseokState("결석");
        updateChoolseokState();
    }

    public void onLateBtnClicked() {
        setChoolseokState("지각");
        updateChoolseokState();
    }
}
