package chooldong.request;

import java.util.Objects;

public class MockAuth extends AbstractAuthRequest {
    @Override
    public String getToken(String id, char[] pw) {
        if (Objects.equals(id, "myid") && Objects.equals(pw, "passwd")) {
            return "my_token";
        }
        else {
            return null;  // 에러 처리 필요
        }
    }
}
