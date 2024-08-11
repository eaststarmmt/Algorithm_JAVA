import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] d = new int[N + 1][3];
        int[][] color = new int[N + 1][3];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            color[i][0] = Integer.parseInt(st.nextToken());
            color[i][1] = Integer.parseInt(st.nextToken());
            color[i][2] = Integer.parseInt(st.nextToken());
        }

        d[1][0] = color[1][0];
        d[1][1] = color[1][1];
        d[1][2] = color[1][2];

        for(int i = 2; i <= N; i++) {
            d[i][0] = color[i][0] + Math.min(d[i - 1][1], d[i - 1][2]);
            d[i][1] = color[i][1] + Math.min(d[i - 1][2], d[i - 1][0]);
            d[i][2] = color[i][2] + Math.min(d[i - 1][1], d[i - 1][0]);
        }

        System.out.println(Math.min(d[N][0], Math.min(d[N][1], d[N][2])));
    }
}