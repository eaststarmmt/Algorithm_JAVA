import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static int T, W;
    static int[] plum;
    static int[][][] dp;
    static final int INF = (int) 1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        plum = new int[T];
        dp = new int[T][W + 1][2];

        for(int i = 0; i < T; i++) {
            for(int j = 0; j <= W; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        for(int i = 0; i < T; i++) {
            plum[i] = Integer.parseInt(br.readLine());
        }   // end of for
        System.out.println(Math.max(dynamicProgramming(0, W, 0), dynamicProgramming(0, W - 1, 1)));

    }

    private static int dynamicProgramming(int idx, int w, int pos) {
        if(idx >= T) return 0;
        if(w < 0) return -INF;

        int res = dp[idx][w][pos];
        if(res != -1) return res;

        res = Math.max(dynamicProgramming(idx + 1, w, pos), dynamicProgramming(idx, w - 1, pos ^ 1)) + (plum[idx] - 1 == pos ? 1 : 0);
        dp[idx][w][pos] = res;
        return res;
    }
}