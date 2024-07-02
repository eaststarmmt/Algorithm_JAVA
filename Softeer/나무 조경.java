import java.io.*;
import java.util.*;

public class Main {
    static int N, res;
    static int a[][], visited[][];
    static int dr[] = {1, 0};
    static int dc[] = {0, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        a = new int[N][N];
        visited = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }   // end of for j
        }   // end of for i

        comb(0, 0);
        System.out.println(res);
    }

    private static void comb(int cnt, int sum) {
        res = Math.max(res, sum);

        if(cnt == 4) return;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visited[i][j] != 0) continue;
                visited[i][j] = 1;

                for(int k = 0; k < 2; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];

                    if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    if(visited[nr][nc] != 0) continue;
                    visited[nr][nc] = 1;
                    comb(cnt + 1, sum + a[i][j] + a[nr][nc]);
                    visited[nr][nc] = 0;
                }
                visited[i][j] = 0;

            }
        }
    }
}
