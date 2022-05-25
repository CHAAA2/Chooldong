package chooldong.frame;

import javax.swing.*;

public class ClassListWindowFrame extends ChooldongFrame {
    String token;
    public ClassListWindowFrame(String[] classList, String token) {
        this.token = token;
        this.setDefault();
        JList<String> cl = new JList<>();
        cl.setListData(classList);
        this.cp.add(cl);
        RoundedButton choolseokBtn = new RoundedButton("출석");
        RoundedButton checkBtn = new RoundedButton("조회");
        this.cp.add(choolseokBtn);
        this.cp.add(checkBtn);
    }
}