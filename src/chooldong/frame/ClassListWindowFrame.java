package chooldong.frame;

public class ClassListWindowFrame extends ListWindowFrame {
    public ClassListWindowFrame(String[] classList, String token) {
        super(classList, token);
        this.middleLabel.setText(this.name + "님 안녕하세요.");
    }

}