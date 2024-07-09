import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> res;
    static int N;
    static int a[][],visited[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};

    private static Integer dfs(int r, int c) {
        int res = 1;
        visited[r][c] = 1;

        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            // validation check
            if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
            if(visited[nr][nc] != 0) continue;
            if(a[nr][nc] == 0) continue;

            res += dfs(nr, nc);
        }

        return res;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        a = new int[N][N];
        visited = new int[N][N];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < s.length(); j++) {
                a[i][j] = s.charAt(j) - '0';
            }
        }

        res = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visited[i][j] != 0 || a[i][j] == 0) continue;
                res.add(dfs(i, j));
            }
        }

        res.sort((s1, s2) -> {
            return s1 - s2;
        });

        sb.append(res.size()).append('\n');

        for(int x : res) {
            sb.append(x).append('\n');
        }

        System.out.println(sb);
    }
}
