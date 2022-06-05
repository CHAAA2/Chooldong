package chooldong.window;

import chooldong.frame.ChooldongFrame;
import chooldong.component.ChooldongBtn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentOrTeacher extends ChooldongFrame {
    public void init() {
        setTitle("login");
        setDefault();  // 상속됨
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cp.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 200));
        ChooldongBtn student = new ChooldongBtn("학습자");
        student.setPreferredSize(new Dimension(200, 100));
        student.setFont(new Font("고딕",Font.BOLD,30));
        student.addActionListener(new SotListener());

        ChooldongBtn teacher = new ChooldongBtn("교수자");
        teacher.setPreferredSize(new Dimension(200, 100));
        teacher.setFont(new Font("고딕",Font.BOLD,30));
        teacher.addActionListener(new SotListener());

        cp.add(teacher);  // 컨테이너에 버튼 추가
        cp.add(student);  // 컨테이너에 버튼 추가
    }
    public StudentOrTeacher() {  // 인자 없이 생성시 모킹 객체
        init();
    }

    private class SotListener implements ActionListener {
        private void onSoTBtnClicked(JButton b) {
            String btn = b.getText();
            System.out.println(btn);
            switch (btn) {
                case "학습자" -> {
                    StudentLogin sl = new StudentLogin();
                    sl.showWindow();

                }
                case "교수자" -> {
                    TeacherLogin tl = new TeacherLogin();
                    tl.showWindow();

                }
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            onSoTBtnClicked(b);
        }
    }

    public static void main(String[] args) {  // 테스트용
        StudentOrTeacher sot = new StudentOrTeacher();
        sot.showWindow();
    }

}
