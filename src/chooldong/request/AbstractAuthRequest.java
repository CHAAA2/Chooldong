package chooldong.request;

public abstract class AbstractAuthRequest {
    public abstract String getToken(String id, char[] pw);

}
