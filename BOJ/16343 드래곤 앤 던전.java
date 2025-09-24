import java.io.*;
import java.util.*;
public class Main {
    final static long INF = (long)1e18;
    static int N, atk;
    static List<int[]> A;
    static long output;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        atk = Integer.parseInt(st.nextToken());
        A = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            A.add(new int[]{t, a, h});
        }

        long lo = 0;
        long hi = INF;

        while(lo <= hi) {
            long mid = (lo + hi) / 2;

            if(check(mid)) {
                output = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }   // end of while
        System.out.println(output);
    }

    static boolean check(long maxHp) {
        long curHp = maxHp;
        long curAtk = atk;
        for(int [] arr : A) {
            int t = arr[0];
            int a = arr[1];
            int h = arr[2];

            long cnt;

            if(t == 1) {
                cnt = h / curAtk;
                if(h % curAtk != 0) cnt++;
                curHp -= a * (cnt - 1);
            } else {
                curHp = Math.min(maxHp, curHp + h);
                curAtk += a;
            }
            if(curHp <= 0) return false;
        }   // end of for
        return true;
    }

}