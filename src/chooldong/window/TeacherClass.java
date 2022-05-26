package chooldong.window;

import chooldong.component.RandomCode;
import chooldong.frame.ChooldongFrame;
import chooldong.frame.ClassListWindowFrame;
import chooldong.frame.LogInFrame;
import chooldong.frame.RoundedButton;
import chooldong.request.AbstractAuthRequest;
import chooldong.request.AbstractDataRequest;
import chooldong.request.MockAuth;
import chooldong.request.MockData;


import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;

public class TeacherClass extends ChooldongFrame {
    AbstractAuthRequest authRequest;
    AbstractDataRequest dataRequest;
    String lectureName;
    String teacherName;
    public TeacherClass(String lectureName, String teacherName) {
        this.lectureName = lectureName;
        this.teacherName = teacherName;
    }
    public void tinit() {
        setTitle("TeacherClass");
        setDefault();  // 상속됨
        cp.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 200));
        RoundedButton add = new RoundedButton("생성");
        add.setPreferredSize(new Dimension(200, 100));
        add.setFont(new Font("고딕", Font.BOLD, 30));

        RoundedButton search = new RoundedButton("조회");
        search.setPreferredSize(new Dimension(200, 100));
        search.setFont(new Font("고딕", Font.BOLD, 30));

        cp.add(add);  // 컨테이너에 버튼 추가
        cp.add(search);  // 컨테이너에 버튼 추가
    }

    private class TeacherListener implements ActionListener {
        private void onSoTBtnClicked(JButton b) {
            String btn = b.getText();
            System.out.println(btn);
            switch (btn) {
                case "생성" -> {
                    //RandomCode sl = new RandomCode("웹프로그래밍");
                    //sl.showWindow();

                }
                case "조회" -> {
                    //ClassListWindowFrame clwf = new ClassListWindowFrame();
                    //clwf.showWindow();

                }
            }
        }




        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }
    public static void main(String[] args) {  // 테스트용

        TeacherClass tc = new TeacherClass("융합프로그래밍2", "홍길동");
        tc.tinit();
        tc.showWindow();
    }
}
