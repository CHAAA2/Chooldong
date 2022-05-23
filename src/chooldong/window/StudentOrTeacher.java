package chooldong.window;

import chooldong.frame.ChooldongFrame;
import chooldong.request.AbstractAuthRequest;
import chooldong.request.AbstractDataRequest;
import chooldong.request.MockAuth;
import chooldong.request.MockData;

import javax.swing.*;
import java.awt.event.*;

public class StudentOrTeacher extends ChooldongFrame {
    AbstractAuthRequest authRequest;
    AbstractDataRequest dataRequest;

    public void init() {
        setTitle("login");
        setDefault();  // 상속됨

        JButton student = new JButton("학습자");
        student.addActionListener(new SotListener());
        JButton teacher = new JButton("교수자");
        teacher.addActionListener(new SotListener());

        cp.add(teacher);  // 컨테이너에 버튼 추가
        cp.add(student);  // 컨테이너에 버튼 추가
    }
    public StudentOrTeacher() {  // 인자 없이 생성시 모킹 객체
        this.authRequest = new MockAuth();
        this.dataRequest = new MockData();
        init();
    }
    public StudentOrTeacher(AbstractDataRequest dataRequest, AbstractAuthRequest authRequest){  // 인자 지정
        this.dataRequest = dataRequest;
        this.authRequest = authRequest;
        init();
    }

    private class SotListener implements ActionListener {
        private void onSoTBtnClicked(JButton b) {
            String btn = b.getText();
            System.out.println(btn);
            switch (btn) {
                case "학습자" -> {
                    StudentLogin sl = new StudentLogin(dataRequest, authRequest);
                    sl.showWindow();

                }
                case "교수자" -> {
                    TeacherLogin tl = new TeacherLogin(dataRequest, authRequest);
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
