package chooldong.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import chooldong.component.RandomCode;
import chooldong.frame.ChooldongFrame;
import chooldong.frame.RoundedButton;
import chooldong.request.AbstractDataRequest;
import chooldong.request.AbstractAuthRequest;
import chooldong.request.MockAuth;
import chooldong.request.MockData;

public class RandomCodeEnter extends ChooldongFrame {

    protected JTextField RandomCode;
    protected AbstractDataRequest dataRequest;
    protected AbstractAuthRequest authRequest;

    public void init() {
        setDefault();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cp.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 200));
        this.RandomCode = new JTextField(40);


        cp.add(new JLabel("출석코드를 입력하세요"));
        cp.add(RandomCode);

        setTitle("RandomCodeEnter");
        cp.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 200));
        RoundedButton check = new RoundedButton("출석");
        check.setPreferredSize(new Dimension(200, 100));
        check.setFont(new Font("고딕",Font.BOLD,30));

    }


    public static void main(String[] args) {  // 테스트용
        RandomCodeEnter rc = new RandomCodeEnter();
        rc.init();
        rc.showWindow();
    }
}