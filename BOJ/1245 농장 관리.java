import java.io.*;
import java.util.*;
class Main {
    static int N, M;
    static boolean[][] visited = new boolean[100][70];
    static int[][] map = new int[100][70];
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
    static boolean peek;

    private static void dfs(int r, int c) {
        for(int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if(map[nr][nc] > map[r][c]) peek = false;   // 더 높은게 있으면 불가능
                if(visited[nr][nc] || map[r][c] != map[nr][nc]) continue;
                visited[nr][nc] = true;
                dfs(nr, nc);
            }
        }   // end of for
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }   // end of for j
        }   // end of for i

        int res = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j]) {
                    peek = true;
                    dfs(i, j);
                    if(peek) res++;
                }
            }   // end of for j
        }   // end of for i

        System.out.println(res);
    }   // end of main
}