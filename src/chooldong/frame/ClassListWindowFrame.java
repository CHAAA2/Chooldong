package chooldong.frame;

import chooldong.request.Request;

import javax.swing.*;

public class ClassListWindowFrame extends ListWindowFrame {
    public ClassListWindowFrame(String[] classList, String token) {
        super(classList, token);
        JLabel hello = new JLabel(Request.dataRequest.getName(this.token) + "님 안녕하세요.");
        this.cp.add(hello);
        this.cp.add(new JLabel());
    }

}