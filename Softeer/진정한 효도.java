import java.io.*;
import java.util.*;

public class Main {
    final static int INF = (int)1e9;
    static int a[][];
    static int res = INF;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        a = new int[3][3];

        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }   // end of for
        }   // end of for

        for(int i = 0; i < 3; i++) {
            res = Math.min(res, check(a[i][0], a[i][1], a[i][2]));
            res = Math.min(res, check(a[0][i], a[1][i], a[2][i]));
        }   // end of for

        System.out.println(res);
    }

    private static int check(int a, int b, int c) {
        int mid = a + b + c - Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c));
        return Math.abs(mid - a) + Math.abs(mid - b) + Math.abs(mid - c);
    }
}
