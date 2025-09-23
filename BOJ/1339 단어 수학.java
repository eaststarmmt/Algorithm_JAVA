import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Integer[] sum;
    static String[] a;

    static void setSum(String s) {
        for(int i = s.length() - 1, digits = 1; i >= 0; i--,digits*=10) {
            sum[s.charAt(i) - 'A'] += digits;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        a = new String[N];
        sum = new Integer[30];

        for(int i = 0; i < 30; i++) {
            sum[i] = 0;
        }

        for(int i = 0; i < N; i++) {
            a[i] = br.readLine();
        }

        for(String s : a) {
            setSum(s);
        }

        Arrays.sort(sum, Collections.reverseOrder());
        int output = 0;
        for(int i = 0, num = 9; i < 30; i++,num--) {
            if(num == 0) break;
            output += sum[i] * num;
        }
        System.out.println(output);
    }
}