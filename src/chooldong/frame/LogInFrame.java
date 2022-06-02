package chooldong.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import chooldong.request.*;

public class LogInFrame extends ChooldongFrame {
    protected JTextField idField;
    protected JPasswordField pwField;
    protected char userType;
    protected AuthRequestForm arf;
    protected String token;
    protected String[] classList;
    protected ClassListWindowFrame classListWindowFrame;

    public void init() {
        setDefault();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        cp.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 200));
        this.idField = new JTextField(20);
        this.pwField = new JPasswordField(20);

        RoundedButton viewBtn = new RoundedButton("조회");

        viewBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onLogInBtnPressed();
            }
        });

        cp.add(new JLabel("ID"));
        cp.add(idField);
        cp.add(new JLabel("Password"));
        cp.add(pwField);
        cp.add(viewBtn);

    }

    public LogInFrame() {
        init();
    }


    public void requestAuth() {
        /*
         * 토큰 반환
         * mock 요청에서는 이름 반환
         * */
        AuthRequestForm arf = new AuthRequestForm(this.idField.getText(), this.pwField.getPassword(), this.userType);
        this.arf = arf;
        this.token = Request.authRequest.getToken(arf);
    }

    public ClassListWindowFrame getClassListWindow() {
        return null;  // override 필요
    }

    public void onLogInBtnPressed() {
        try {
            this.requestAuth();

            if (this.arf != null) {
                this.classList = Request.dataRequest.getClassList(this.token);

                classListWindowFrame = this.getClassListWindow();
                classListWindowFrame.setDefault();
                classListWindowFrame.showWindow();
                this.dispose();
            } else {
                this.onLogInFailed();
            }
        } catch (Exception e) {
            this.onLogInFailed();
        }
    }

    public void onLogInFailed() {
        JOptionPane.showMessageDialog(null, "로그인 실패");
    }

}
