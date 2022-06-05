package chooldong.frame;

import chooldong.request.Request;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;

public class ClassListWindowFrame extends ListWindowFrame {
    protected JTextPane hello;
    protected JLabel stateLabel;
    protected String name;
    protected JPanel middlePanel;
    public ClassListWindowFrame(String[] classList, String token) {
        super(classList, token);
        this.name = Request.dataRequest.getName(token);
        this.hello = new JTextPane();
        this.hello.setText(this.name + "님 안녕하세요.");

        this.middlePanel = new JPanel();
        this.middlePanel.setLayout(new GridLayout(3,1));
        this.middlePanel.setOpaque(false);
        this.middlePanel.setVisible(true);

        this.stateLabel = new JLabel();
        this.stateLabel.setHorizontalAlignment(JLabel.CENTER);
        this.middlePanel.add(this.stateLabel);

        SimpleAttributeSet attribs = new SimpleAttributeSet();
        StyleConstants.setAlignment(attribs, StyleConstants.ALIGN_CENTER);
        this.hello.setParagraphAttributes(attribs, true);
        this.hello.setOpaque(false);
        this.cp.add(middlePanel);
        this.middlePanel.add(hello);
        this.middlePanel.add(new JLabel());
//        this.middlePanel.add(this.stateLabel);
        this.cp.add(new JLabel());

    }

}