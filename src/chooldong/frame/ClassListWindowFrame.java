package chooldong.frame;

import javax.swing.*;

public class ClassListWindowFrame extends ChooldongFrame {

    public ClassListWindowFrame(String[] classList) {
        this.setDefault();
        JList<String> cl = new JList<>();
        cl.setListData(classList);
        this.cp.add(cl);
    }

    public static void main(String[] args) { // 테스트용
        String[] lsi = {"융합프로그래밍2", "융합캡스톤디자인", "자료구조및알고리즘2", "웹프로그래밍"};  // 테스트용 데이터
        ClassListWindowFrame clwf = new ClassListWindowFrame(lsi);
        clwf.showWindow();
    }
}