package chooldong.frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassListWindowFrame extends ChooldongFrame {
    public String token;
    public JList<String> cl;
    public ClassListWindowFrame(String[] classList, String token) {
        this.token = token;
        this.setDefault();
        this.cl = new JList<>();
        cl.setListData(classList);
        this.cp.add(cl);
        RoundedButton choolseokBtn = new RoundedButton("출석");
        choolseokBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onChoolseokBtnClicked();
            }
        });
        RoundedButton checkBtn = new RoundedButton("조회");
        checkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCheckBtnClicked();
            }
        });
        this.cp.add(choolseokBtn);
        this.cp.add(checkBtn);
    }

    public void onChoolseokBtnClicked() {
    }

    public void onCheckBtnClicked() {
    }
}