import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int psum[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        psum = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++) {
            psum[i] = psum[i - 1] + Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int lo = Integer.parseInt(st.nextToken());
            int hi = Integer.parseInt(st.nextToken());
            double res = ((double) (psum[hi] - psum[lo - 1])) / (hi - lo + 1);
            sb.append(String.format("%.2f", res)).append('\n');
        }
        System.out.print(sb);
    }
}
