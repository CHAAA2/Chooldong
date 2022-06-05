package chooldong.window;

import chooldong.frame.ChooldongFrame;
import chooldong.component.RoundedButton;
import chooldong.request.Request;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentCodeEnterWindow extends ChooldongFrame {
    protected JTextField randomCodeField;
    String token;
    String lectureName;

    public StudentCodeEnterWindow() {
        super();
        init();
    }

    public StudentCodeEnterWindow(String token, String lectureName) {
        super();
        init();
        this.token = token;
        this.lectureName = lectureName;
    }

    public void init() {
        setDefault();
        cp.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 200));
        this.randomCodeField = new JTextField(40);
        cp.add(new JLabel("출석코드를 입력하세요"));
        cp.add(randomCodeField);
        RoundedButton check = new RoundedButton("출석");
        check.setPreferredSize(new Dimension(200, 100));
        check.setFont(new Font("고딕", Font.BOLD, 30));
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCheckBtnClicked();
            }
        });
        cp.add(check);
    }

    public void onCheckBtnClicked() {
        String code = this.randomCodeField.getText();
        boolean res = Request.dataRequest.submitChoolseokCode(this.lectureName, this.token, code);
        if (res) {
            JOptionPane.showMessageDialog(this, "출석 성공");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "출석 실패");
        }
    }

    public static void main(String[] args) {  // 테스트용
        StudentCodeEnterWindow rc = new StudentCodeEnterWindow();
        rc.init();
        rc.showWindow();
    }
}
