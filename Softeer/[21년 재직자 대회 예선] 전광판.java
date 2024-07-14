import java.io.*;
import java.util.*;

public class Main {
    static Map<Character, String> m;
    static int T;
    static String s1, s2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        m = new HashMap<>();

        m.put('0', "1110111");
        m.put('1', "0010010");
        m.put('2', "1011101");
        m.put('3', "1011011");
        m.put('4', "0111010");
        m.put('5', "1101011");
        m.put('6', "1101111");
        m.put('7', "1110010");
        m.put('8', "1111111");
        m.put('9', "1111011");
        m.put(' ', "0000000");

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            s1 = "     " + st.nextToken();
            s2 = "     " + st.nextToken();

            s1 = s1.substring(s1.length() - 5);
            s2 = s2.substring(s2.length() - 5);

            sb.append(count(s1, s2)).append('\n');
        }   // end of while

        System.out.print(sb);
    }

    static int count(String x, String y) {
        int res = 0;
        for(int i = 0; i < 5; i++) {
            res += dif(x.charAt(i), y.charAt(i));
        }   // end of for

        return res;
    }

    static int dif(char c1, char c2) {
        int res = 0;

        String x = m.get(c1);
        String y = m.get(c2);

        for(int i = 0; i < x.length(); i++) {
            if(x.charAt(i) != y.charAt(i)) res++;
        }
        return res;
    }
}
