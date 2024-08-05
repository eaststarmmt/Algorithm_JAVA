import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] dif = new boolean[50][50];
    static int[][] a = new int[50][50];
    static int[][] b = new int[50][50];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j < m; j++) {
                b[i][j] = s.charAt(j) - '0';
            }
        }

        int cnt = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (a[i][j] != b[i][j]) {	// 서로 다르면 a 뒤집음
                    cnt++;
                    reverse(i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {	// 다시 처음부터 비교
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i][j]) {	// 하나라도 다르면 바로 중단하고 -1 출력
                    System.out.println(-1);
                    return ;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void reverse(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                a[i][j] = 1 - a[i][j];
            }
        }
    }

}