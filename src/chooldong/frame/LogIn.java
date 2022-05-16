package chooldong.frame;

import javax.swing.*;
import java.awt.event.*;

import chooldong.request.AbstractDataRequest;
import chooldong.request.AbstractAuthRequest;
import chooldong.request.MockAuth;
import chooldong.request.MockData;

public class LogIn extends ChooldongFrame {
    protected JTextField idField;
    protected JPasswordField pwField;
    protected AbstractDataRequest dataRequest;
    protected AbstractAuthRequest authRequest;

    public void init() {
        setDefault();

        this.idField = new JTextField(20);
        this.pwField = new JPasswordField(20);
        JButton viewBtn = new JButton("조회");
        viewBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onViewBtnPressed();
            }
        });

        c.add(new JLabel("ID"));
        c.add(idField);
        c.add(new JLabel("Password"));
        c.add(pwField);
        c.add(viewBtn);

        if (authRequest==null){
            authRequest = new MockAuth();
        }
        if (dataRequest==null){
            dataRequest = new MockData();
        }
    }

    public LogIn() {
        init();
    }

    public LogIn(AbstractDataRequest dataRequest, AbstractAuthRequest authRequest) {
        this.authRequest = authRequest;
        this.dataRequest = dataRequest;
        init();
    }

    public void requestAuth() {
        authRequest.getToken(this.idField.getText(), this.pwField.getPassword());

    }

    public void onViewBtnPressed() {
         System.out.println(this.idField.getText());
         System.out.println(this.pwField.getPassword());
     }

}
