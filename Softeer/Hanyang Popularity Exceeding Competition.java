import java.util.*;
import java.io.*;
public class Main {
    static int N, X;
    static int[] P, C;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        P = new int[N];
        C = new int[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            P[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
        }   // end of for

        for(int i = 0; i < N; i++) {
            if(Math.abs(P[i] - X) > C[i]) continue;
            X++;
        }   // end of for

        System.out.println(X);
    }
}