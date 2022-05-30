package chooldong.component;

import chooldong.frame.ChooldongFrame;
import chooldong.frame.RoundedButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RandomCode_4 extends ChooldongFrame {
    JTextField jtf;
    public RandomCode_4(){
        setDefault();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cp.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 200));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        this.jtf = new JTextField(30);
        cp.add(jtf);


        RoundedButton regenerate = new RoundedButton("조회");
        RoundedButton check = new RoundedButton("재성성");

        cp.add(regenerate);
        cp.add(check);

        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onBtnClicked();

            }
        });
    }
    public void onBtnClicked() {

        String rdc = randomCodeGenerate();
        System.out.println(rdc);
        this.jtf.setText(rdc);
    }
    public String randomCodeGenerate() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        int length = 8;
        for (int i=0; i < length; i++) {
            int index = random.nextInt(alphabet.length());

            char randomChar = alphabet.charAt(index);

            sb.append(randomChar);
        }
        return sb.toString();
    }
    public void init() {


    }

    public static void main(String[] args) {

        RandomCode_4 rc = new RandomCode_4();
        rc.init();
        rc.showWindow();

    }

}