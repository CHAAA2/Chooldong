package chooldong.request;

public class AuthRequestForm {
    String id;
    char[] pw;
    char userType;

    public AuthRequestForm(String id, char[] pw, char userType) {
        this.id = id;
        this.pw = pw;
        this.userType = userType;
    }
}
