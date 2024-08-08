import java.io.*;
import java.util.*;
public class Main {
    static int R, C;
    static int[][] a, dp, visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    private static boolean check(int r, int c) {
        if(r < 1 || r > R || c < 1 || c > C || a[r][c] == 'H') return false;
        return true;
    }
    static int solve(int r, int c) {
        if(!check(r, c)) return 0;  // 게임이 종료 된 경우
        if(visited[r][c] != 0) {    // 무한번 갈 수 있는 경우
            System.out.println(-1);
            System.exit(0);
        }

        // 메모이제이션
        if(dp[r][c] != 0) return dp[r][c];    // 값이 있는 경우 그 값 리턴. 한 점을 기준으로 다른곳으로 퍼져서 다녀온 결과를 저장하는 방식이기 때문에 갱신될 일 없음

        visited[r][c] = 1;  // 루프를 확인하기 위해 방문 체크

        for(int i = 0; i < 4; i++) {
            int val = a[r][c] - '0';
            int nr = r + dr[i] * val;
            int nc = c + dc[i] * val;

            dp[r][c] = Math.max(dp[r][c], solve(nr, nc) + 1);  // 최댓값 갱신

        }   // end of for

        visited[r][c] = 0;  // 끝난 후 방문 체크 해제

        return dp[r][c];

    }



    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        a = new int[54][54];
        dp = new int[54][54];
        visited = new int[54][54];

        for(int i = 1; i <= R; i++) {
            String s = br.readLine();
            for(int j = 1; j <= C; j++) {
                a[i][j] = s.charAt(j - 1);
            }
        }

        System.out.println(solve(1, 1));
    }

}
