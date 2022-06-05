package chooldong.frame;

import chooldong.request.Request;

public class ClassListWindowFrame extends ListWindowFrame {
    protected String name;
    public ClassListWindowFrame(String[] classList, String token) {
        super(classList, token);
        this.name = Request.dataRequest.getName(token);
        this.middleLabel.setText(this.name + "님 안녕하세요.");
    }

}