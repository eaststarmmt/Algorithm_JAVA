import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, M, res;
    static int[][] a, visited;
    static List<int[]> v;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new int[N][N];
        visited = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }   // end of for j
        }   // end of for i

        v = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            v.add(new int[]{--r, --c});
        }   // end of for

        dfs(v.get(0), 1);
        System.out.println(res);
    }

    private static void dfs(int[] pos, int idx) {
        if(Arrays.equals(pos, v.get(idx))) {
            if(idx == M - 1) {
                res++;
                return;
            }
            ++idx;
        }

        int r = pos[0];
        int c = pos[1];

        visited[r][c] = 1;

        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            if(visited[nr][nc] != 0) continue;
            if(a[nr][nc] != 0) continue;
            dfs(new int[]{nr, nc}, idx);
        }   // end of for i

        visited[r][c] = 0;
    }
}
