package chooldong.frame;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
        choolseokBtn.setEnabled(false);
        checkBtn.setEnabled(false);

        cl.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (cl.getSelectedValue() != null) {
                    choolseokBtn.setEnabled(true);
                    checkBtn.setEnabled(true);
                }
            }
        });

    }

    public void onChoolseokBtnClicked() {
    }

    public void onCheckBtnClicked() {
    }
}