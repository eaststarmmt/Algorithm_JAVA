import java.io.*;
import java.util.*;
public class Main {
    static long X, Y, Z;
    static long res = -1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        Z = 1L * 100 * Y / X;   // 100을 먼저 안곱하면 0이 될 수도 있음

        long lo = 1;
        long hi = (long)1e9;

        while(lo <= hi) {
            long mid = (lo + hi) / 2;

            if(check(mid)) {
                hi = mid - 1;
                res = mid;
            } else {
                lo = mid + 1;
            }
        }   // end of while

        System.out.println(res);
    }

    static boolean check(long mid) {
        long avg = 1L * 100 * (Y + mid) / (X + mid);
        return avg > Z;
    }
}
