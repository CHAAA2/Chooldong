package chooldong.request;

import java.util.Arrays;
import java.util.Objects;

public class MockAuth extends AbstractAuthRequest {  // 인증 요청 mock 클래스
    @Override
    public String getToken(String id, char[] pw, char userType) {
        String StringPw = new String(pw);
        if (Objects.equals(id, "myid") && Objects.equals(StringPw, "passwd")) {
            return "my_token";
        }
        else {
            return null;  // 에러 처리 필요
        }
    }
}
