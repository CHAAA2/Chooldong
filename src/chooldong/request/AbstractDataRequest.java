package chooldong.request;

import java.io.IOException;
import java.util.HashMap;

public abstract class AbstractDataRequest {  // 데이터 요청 추상 클래스
    public abstract String[] getClassList(String token);
    public abstract String getStudentChoolseockState(String token, String lectureName);
    public abstract HashMap<String, String> getTeacherChoolseokState(String token, String lectureName);
    public abstract String[] getStudentList(String lecturename);
    public abstract String getTeacherName(String lecturename);
    public abstract void setManualChoolseockState(String token, String lecturename, String student, String state);
    public abstract void setChoolseokCode(String token, String lecturename, String code);
    public abstract boolean submitChoolseokCode(String lecturename, String token, String code);

}
