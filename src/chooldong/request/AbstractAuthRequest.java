package chooldong.request;

public abstract class AbstractAuthRequest {  // 인증 요청 추상클래스
    public abstract String getToken(AuthRequestForm authForm);
}
