package chooldong.window;

import chooldong.ChooldongIcon;
import chooldong.frame.ListWindowFrame;
import chooldong.frame.RoundedButton;
import chooldong.request.Request;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class TeacherStudentChoolseokList extends ListWindowFrame {
    JLabel imgLabel;
    String lectureName;
    RoundedButton lateBtn;
    public TeacherStudentChoolseokList(String[] listArray, String token, String lectureName) {
        super(listArray, token);
        this.cp.setLayout(new GridLayout());
        this.imgLabel = new JLabel();
        this.cp.add(this.imgLabel);
        this.lectureName = lectureName;
        this.space.setHorizontalAlignment(JLabel.CENTER);

        this.choolseokBtn.setText("출석");
        this.checkBtn.setText("결석");
        this.lateBtn = new RoundedButton("지각");
        this.btnPanel.setLayout(new GridLayout(3,1));
        this.btnPanel.add(lateBtn);
        this.lateBtn.setEnabled(false);

        this.lateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onLateBtnClicked();
            }
        });
    }

    public void updateChoolseokState() {
        HashMap<String, String> choolseokState = Request.dataRequest.getTeacherChoolseokState(this.token, this.lectureName);
        String state = choolseokState.get(this.cl.getSelectedValue());
        switch (state) {
            case "결석" -> {
                this.space.setIcon(ChooldongIcon.absentIcon);
            }
            case "미처리" -> this.space.setIcon(ChooldongIcon.defaultIcon);
            case "지각" -> this.space.setIcon(ChooldongIcon.lateIcon);
            case "출석" -> this.space.setIcon(ChooldongIcon.okIcon);
        }
        this.space.setText(state);
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
        icon.setImage(icon.getImage().getScaledInstance(200, 280,0));
        this.imgLabel.setIcon(icon);
        updateChoolseokState();
    }

    public void setChoolseokState(String state) {
        Request.dataRequest.setManualChoolseockState(this.token, this.lectureName, this.cl.getSelectedValue(), state);
    }

    @Override
    public void onChoolseokBtnClicked() {
        super.onChoolseokBtnClicked();
        setChoolseokState("출석");
        updateChoolseokState();
    }

    @Override
    public void onCheckBtnClicked() {
        setChoolseokState("결석");
        updateChoolseokState();
    }

    public void onLateBtnClicked() {
        setChoolseokState("지각");
        updateChoolseokState();
    }
}
