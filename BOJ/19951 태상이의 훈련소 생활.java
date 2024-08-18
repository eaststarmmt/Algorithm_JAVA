import java.io.*;
import java.util.*;

class Main {
    static int[] a, psum;
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new int[N + 4];
        psum = new int[N + 4];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }   // end of for

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            psum[a] += c;
            psum[b + 1] -= c;
        }   // end of for i

        for(int i = 1; i <= N; i++) {
            psum[i] += psum[i - 1];
        }

        for(int i = 1; i <= N; i++) {
            a[i] += psum[i];
        }

        for(int i = 1; i <= N; i++) {
            sb.append(a[i]).append(' ');
        }

        System.out.println(sb);
    }
}