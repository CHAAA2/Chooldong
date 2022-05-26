package chooldong.component;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class RandomCode_2 {
    public static int count;

    public static void main(String[] args) {
        count = 0;

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        Random random = new Random();

        Timer m = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                if(count < 3) {
                    int length = 8;
                    StringBuilder sb = new StringBuilder();
                    for (int i=0; i < length; i++) {
                        int index = random.nextInt(alphabet.length());
                        char randomChar = alphabet.charAt(index);
                        sb.append(randomChar);
                    }

                    String randomString = sb.toString();
                    System.out.println(randomString);
                    count++;
                } else {
                    m.cancel();
                }
            }
        };

        m.schedule(task,0,1000);

    }

}