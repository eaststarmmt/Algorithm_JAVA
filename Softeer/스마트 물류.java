import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static String a;
    static int visited[];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        a = br.readLine();
        visited = new int[N];

        int res = 0;

        for(int i = 0; i < N; i++) {
            if(a.charAt(i) == 'H') continue;
            for(int j = i - K; j <= i + K; j++) {
                if(j < 0 || j >= N) continue;
                if(a.charAt(j) == 'P') continue;
                if(visited[j] != 0) continue;
                res++;
                visited[j] = 1;
                break;
            }   // end of for j
        }   // end of for i

        System.out.println(res);
    }
}
