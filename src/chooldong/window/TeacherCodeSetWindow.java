package chooldong.window;

import chooldong.frame.ChooldongFrame;
import chooldong.frame.RoundedButton;
import chooldong.request.Request;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TeacherCodeSetWindow extends ChooldongFrame {
    JTextField randCodeField;
    String token;
    String lectureName;

    public TeacherCodeSetWindow(String token, String lectureName) {
        this.token = token;
        this.lectureName = lectureName;
        init();
    }

    public void onRegenBtnClicked() {
        this.randCodeField.setText(randomCodeGenerate());
    }

    public void onSetBtnClicked() {
        boolean response = Request.dataRequest.setChoolseokCode(this.token, this.lectureName, this.randCodeField.getText());
        if (response) {
            JOptionPane.showMessageDialog(this, "설정되었습니다.");
        } else {
            JOptionPane.showMessageDialog(this, "설정 실패");
        }
    }

    public String randomCodeGenerate() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        int length = 8;
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());

            char randomChar = alphabet.charAt(index);

            sb.append(randomChar);
        }
        return sb.toString();
    }

    public void init() {
        setDefault();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cp.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 200));
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        this.randCodeField = new JTextField(30);
        cp.add(randCodeField);


        RoundedButton regenerateBtn = new RoundedButton("재생성");
        RoundedButton setBtn = new RoundedButton("설정");

        cp.add(regenerateBtn);
        cp.add(setBtn);

        regenerateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onRegenBtnClicked();

            }
        });

        setBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSetBtnClicked();
            }
        });
    }

    public static void main(String[] args) {
        TeacherCodeSetWindow rc = new TeacherCodeSetWindow("홍길동", "융합프로그래밍2");
        rc.init();
        rc.showWindow();
    }

}