package chooldong.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import chooldong.request.*;

public class LogInFrame extends ChooldongFrame {
    protected JTextField idField;
    protected JPasswordField pwField;
    protected AbstractDataRequest dataRequest;
    protected AbstractAuthRequest authRequest;
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

        if (authRequest == null) {
            authRequest = new MockAuth();
        }
        if (dataRequest == null) {
            dataRequest = new MockData();
        }
    }

    public LogInFrame() {
        init();
    }

    public LogInFrame(AbstractDataRequest dataRequest, AbstractAuthRequest authRequest) {
        this.authRequest = authRequest;
        this.dataRequest = dataRequest;
        init();
    }

    public void requestAuth() {
        /*
         * 토큰 반환
         * */
        AuthRequestForm arf = new AuthRequestForm(this.idField.getText(), this.pwField.getPassword(), this.userType);
        this.arf = arf;
        this.token = authRequest.getToken(arf);
    }

    public ClassListWindowFrame getClassListWindow() {
        return null;  // override 필요
    }

    public void onLogInBtnPressed() {
        try {
            this.requestAuth();

            if (this.arf != null) {
                this.classList = this.dataRequest.getClassList(this.token);

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
