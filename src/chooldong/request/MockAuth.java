package chooldong.request;

import java.util.Arrays;
import java.util.Objects;

public class MockAuth extends AbstractAuthRequest {  // 인증 요청 mock 클래스
    @Override
    public String getToken(String id, char[] pw, char userType) {
        Person p = MockDB.persons.get(id);
        String spw = new String(pw);
        if (p != null && p.login(spw)) {
            return p.name;
        }
        else {
            return null;
        }
    }
}
