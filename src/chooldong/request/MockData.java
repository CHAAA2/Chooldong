package chooldong.request;

public class MockData extends AbstractDataRequest {  // 데이터 요청 mock 클래스
    private String[] mockClassList(char userType) {
        if(userType=='s') {
            return new String[]{"융합프로그래밍2", "융합캡스톤디자인", "자료구조및알고리즘2", "웹프로그래밍"};
        }
        else {
            return new String[]{"자료구조및알고리즘2", "웹프로그래밍"};
        }
    }

    @Override
    public String[] getClassList(String token, char userType) {
        String[] toReturn = {"융합프로그래밍2", "융합캡스톤디자인", "자료구조및알고리즘2", "웹프로그래밍"};
        if (token.equals("my_token")) {
            return mockClassList(userType);
        }
        else {
            return null;
        }
    }
}
