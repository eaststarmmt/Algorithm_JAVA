import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int[][] visited;
    static int R, C, K;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    static int dfs(int r, int c) {
        if(r == 0 && c == C - 1) {
            if(visited[r][c] == K) return 1;
            return 0;
        }

        int cnt = 0;
        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc] != 0 || map[nr][nc] == 'T') continue;
            visited[nr][nc] = visited[r][c] + 1;
            cnt += dfs(nr, nc);
            visited[nr][nc] = 0;
        }

        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[6][6];
        visited = new int[6][6];

        for(int i = 0; i < R; i++) {
            String s = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }   // end of for j
        }   // end of for i

        visited[R - 1][0] = 1;
        System.out.println(dfs(R - 1, 0));
    }
}