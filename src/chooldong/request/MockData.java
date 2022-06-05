package chooldong.request;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Objects;

public class MockData extends AbstractDataRequest {  // 데이터 요청 mock 클래스
    static MockDB mdb = new MockDB();

    @Override
    public String[] getClassList(String token) {
        return MockDB.persons.get(token).classes;
    }

    @Override
    public String getStudentChoolseockState(String token, String lectureName) {
        return MockDB.lectures.get(lectureName).choolseok.get(token);
    }

    @Override
    public HashMap<String, String> getTeacherChoolseokState(String token, String lectureName) {
        if (Objects.equals(MockDB.lectures.get(lectureName).teacher, token)) {
            return MockDB.lectures.get(lectureName).choolseok;
        }
        return null;
    }

    @Override
    public String[] getStudentList(String lecturename) {
        return MockDB.lectures.get(lecturename).students;
    }

    @Override
    public String getTeacherName(String lecturename) {
        return MockDB.lectures.get(lecturename).teacher;
    }

    @Override
    public void setManualChoolseockState(String token, String lecturename, String student, String state) {
        String teacherName = MockDB.lectures.get(lecturename).teacher;
        if (Objects.equals(teacherName, token)) {
            MockDB.lectures.get(lecturename).choolseok.replace(student, state);
        }
        else {
            System.out.println("wrong teacher");
        }
    }

    @Override
    public boolean setChoolseokCode(String token, String lecturename, String code) {
        if (Objects.equals(MockDB.lectures.get(lecturename).teacher, token)) {
            MockDB.lectures.get(lecturename).code = code;
            return true;
        }
        else {
            System.out.println("wrong teacher");
            return false;
        }
    }

    @Override
    public boolean submitChoolseokCode(String lectureName, String token, String code) {
        if (Objects.equals(MockDB.lectures.get(lectureName).code, code)) {
            MockDB.lectures.get(lectureName).choolseok.replace(token, "출석");
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String getName(String token) {
        return token;
    }

    @Override
    public ImageIcon getPicture(String name) {
        String picUrl = MockDB.persons.get(name).pic;
        return new ImageIcon(picUrl);
    }

    public static void main(String[] args) {
        MockData md = new MockData();
        System.out.println(MockDB.lectures.get("융합프로그래밍2").code);
        md.setChoolseokCode("홍길동", "융합프로그래밍2", "absdf");
        System.out.println(MockDB.lectures.get("융합프로그래밍2").code);
        md.setManualChoolseockState("홍길동", "융합프로그래밍2", "윤석열", "출석");
        System.out.println(MockDB.lectures.get("융합프로그래밍2").choolseok.get("윤석열"));
    }
}
