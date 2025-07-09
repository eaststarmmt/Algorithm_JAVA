import java.io.*;
import java.util.*;

class Main {
    static int[][] map, d;
    static int N, M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static final int INF = (int) 1e9;

    static void bfs(int startR, int startC) {
        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[]{0, startR, startC});
        d[startR][startC] = 0;

        while (!Q.isEmpty()) {
            int[] cur = Q.poll();
            int dist = cur[0];
            int r = cur[1];
            int c = cur[2];

            if (dist > d[r][c]) continue;

            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (map[nr][nc] == 1) {                     // 위 아래 조건 &&로 묶어 쓰면 메모리 초과 남
                        if (d[nr][nc] > d[r][c] + 1) {          // 1 이므로 벽 한번 더 부술예정 + 1보다 작거나 같으면 의미 없음
                            d[nr][nc] = d[r][c] + 1;
                            Q.add(new int[]{d[r][c] + 1, nr, nc});
                        }
                    } else if (d[nr][nc] > d[r][c]) {           // 0이므로 벽 없음. 이동하기 전 값과 같음
                        d[nr][nc] = d[r][c];
                        Q.add(new int[]{d[r][c], nr, nc});
                    }
                }
            }   // end of for
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[100][100];
        d = new int[100][100];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }   // end of for M
        }   // end of for N

        for(int i = 0; i < N; i++) {    // 거리를 무한으로 잡아서 최소값 계산
            Arrays.fill(d[i], INF);
        }   // end of for

        bfs(0, 0);
        System.out.println(d[N - 1][M - 1]);

    }
}