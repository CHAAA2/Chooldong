package chooldong.request;

public class MockData extends AbstractDataRequest {

    @Override
    public String[] getStudentClassList(String token) {
        String[] toReturn = {"융합프로그래밍2", "융합캡스톤디자인", "자료구조및알고리즘2", "웹프로그래밍"};
        if (token.equals("my_token")) {
            return toReturn;
        }
        else {
            return null;
        }
    }
}
