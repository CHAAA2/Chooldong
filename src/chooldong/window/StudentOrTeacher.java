package chooldong.window;

import chooldong.frame.ChooldongFrame;
import chooldong.frame.LogIn;
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
        setDefault();

        JButton student = new JButton("학습자");
        student.addActionListener(new SotListener());
        JButton teacher = new JButton("교수자");
        teacher.addActionListener(new SotListener());

        c.add(teacher);
        c.add(student);
    }
    public StudentOrTeacher() {
        this.authRequest = new MockAuth();
        this.dataRequest = new MockData();
        init();
    }
    public StudentOrTeacher(AbstractDataRequest dataRequest, AbstractAuthRequest authRequest){
        this.dataRequest = dataRequest;
        this.authRequest = authRequest;
        init();
    }

    private class SotListener implements ActionListener {
        private void onSoTBtnClicked(JButton b) {
            LogIn l = null;
            switch (b.getText()) {
                case "학습자": {
                    l = new StudentLogin(dataRequest, authRequest);

                }
                case "교수자": {
                    l = new TeacherLogin(dataRequest, authRequest);
                }
                default: {
                    l.showWindow();
//                    setVisible(false);
                }
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton) e.getSource();
            onSoTBtnClicked(b);
        }
    }

    public static void main(String[] args) {
        StudentOrTeacher sot = new StudentOrTeacher();
        sot.showWindow();
    }

}
