import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static int[][] dist;
    static List<int[]> graph;
    static final int INF = (int) 1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
        }

        for(int i = 1; i <= N; i++) {
            dist[i][i] = 0;
        }

        StringTokenizer st = null;

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(c, dist[a][b]);
        }   // end of for

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
                }   // end of for j
            }   // end of for i
        }   // end of for k

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(dist[i][j] == INF) sb.append(0);
                else sb.append(dist[i][j]);
                sb.append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}