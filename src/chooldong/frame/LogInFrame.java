package chooldong.frame;

import javax.swing.*;
import java.awt.event.*;

import chooldong.request.AbstractDataRequest;
import chooldong.request.AbstractAuthRequest;
import chooldong.request.MockAuth;
import chooldong.request.MockData;

public class LogInFrame extends ChooldongFrame {
    protected JTextField idField;
    protected JPasswordField pwField;
    protected AbstractDataRequest dataRequest;
    protected AbstractAuthRequest authRequest;
    protected char userType;

    public void init() {
        setDefault();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.idField = new JTextField(20);
        this.pwField = new JPasswordField(20);
        JButton viewBtn = new JButton("조회");
        viewBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onViewBtnPressed();
            }
        });

        cp.add(new JLabel("ID"));
        cp.add(idField);
        cp.add(new JLabel("Password"));
        cp.add(pwField);
        cp.add(viewBtn);

        if (authRequest==null){
            authRequest = new MockAuth();
        }
        if (dataRequest==null){
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

    public String requestAuth() {
        /*
        * 토큰 반환
        * */
        return authRequest.getToken(this.idField.getText(), this.pwField.getPassword(), this.userType);
    }

    public void onViewBtnPressed() {
        String token = this.requestAuth();
        String[] classList = this.dataRequest.getClassList(token, this.userType);
        ClassListWindowFrame clwf = new ClassListWindowFrame(classList);
        clwf.showWindow();
    }

}
