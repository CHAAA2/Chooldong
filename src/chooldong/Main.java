package chooldong;

import chooldong.window.Welcome;

public class Main {
    public static void main(String[] args) {
        Welcome wc = new Welcome();
        wc.showWindow();
        String asdf = System.getProperty("user.dir");
        System.out.println(asdf);
    }
}

