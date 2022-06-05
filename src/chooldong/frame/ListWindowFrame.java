package chooldong.frame;

import chooldong.request.Request;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListWindowFrame extends ChooldongFrame{
    public String token;
    public JList<String> cl;
    public RoundedButton choolseokBtn;
    public RoundedButton checkBtn;
    public JPanel btnPanel;
    public JLabel space;

    public ListWindowFrame(String[] listArray, String token) {
        this.cp.setLayout(new GridLayout());
        this.token = token;

        this.cl = new JList<>();
        cl.setListData(listArray);
        this.cp.add(cl);

        this.btnPanel = new JPanel();
        this.btnPanel.setLayout(new GridLayout(2,1));
        this.cp.add(btnPanel);

        this.choolseokBtn = new RoundedButton("출석");
        choolseokBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onChoolseokBtnClicked();
            }
        });
        this.checkBtn = new RoundedButton("조회");
        checkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCheckBtnClicked();
            }
        });
        this.btnPanel.add(choolseokBtn);
        this.btnPanel.add(checkBtn);
        choolseokBtn.setEnabled(false);
        checkBtn.setEnabled(false);

        this.space = new JLabel();
        this.cp.add(space);
        cl.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                onValueChanged();
            }
        });
        this.setDefault();
    }

    protected void setBtnEnable() {
            choolseokBtn.setEnabled(true);
            checkBtn.setEnabled(true);
    }

    public void onValueChanged() {
        setBtnEnable();
    }

    public void onChoolseokBtnClicked() {
    }

    public void onCheckBtnClicked() {
    }

}
