import java.io.*;
import java.util.*;

class Main {
    static String s;
    static int[] cnt = new int[200];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[c]++;
        }   // end of for

        int flag = 0;
        String res = "";
        char mid = 0;
        for(int i = 'Z'; i >= 'A'; i--) {
            if(cnt[i] == 0) continue;
            if((cnt[i] & 1) != 0) {
                flag++;
                mid = (char) i;
                cnt[i]--;
            }

            if(flag == 2) {
                System.out.println("I'm Sorry Hansoo");
                System.exit(0);
            }
            for(int j = 0; j < cnt[i]; j+=2) {
                res += (char)i;
                res = (char)i + res;
            }   // end of for cnt[i]
        }   // end of for

        if(mid != 0) {
            res = res.substring(0, res.length() / 2) + mid + res.substring(res.length() / 2);
        }
        System.out.println(res);
    }
}