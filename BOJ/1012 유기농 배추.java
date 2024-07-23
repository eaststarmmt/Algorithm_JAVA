import java.io.*;
import java.util.*;

public class Main {
    static int[][] visited, map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int M, N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int test = 0; test < T; test++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[M][N];
            visited = new int[M][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }   // end of for

            int cnt = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == 0 && map[i][j] == 1) {
                        dfs(i, j);
                        cnt++;
                    }
                }   // end of for N
            }   // end of for M

            sb.append(cnt).append('\n');
        }   // end of for test
        System.out.print(sb);
    }   // end of for main

    private static void dfs(int r, int c) {
        visited[r][c] = 1;

        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
            if(visited[nr][nc] == 0 && map[nr][nc] == 1) dfs(nr, nc);
        }
    }
}   // end of for Main
