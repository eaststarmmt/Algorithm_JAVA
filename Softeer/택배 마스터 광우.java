import java.io.*;
import java.util.*;

public class Main {
    static final int INF = (int)1e9;
    static int N, M, K, res = INF;
    static int visited[];
    static List<Integer> a;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        a = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            a.add(Integer.parseInt(st.nextToken()));
        }

        a.sort((s1, s2) -> {
            return s1 - s2;
        });

        visited = new int[N];
        go(new ArrayList<>());

        System.out.println(res);
    }

    static void go(List<Integer> v) {
        if(v.size() == N) {
            calc(v);
            return;
        }

        for(int i = 0; i < N; i++) {
            if(visited[i] != 0) continue;
            visited[i] = 1;
            v.add(a.get(i));
            go(v);
            v.remove(v.size() - 1);
            visited[i] = 0;
        }
    }

    private static void calc(List<Integer> v) {
        int psum = 0;

        for(int i = 0, idx = 0; i < K; i++) {
            int sum = 0;
            while(sum + v.get(idx) <= M) {
                sum += v.get(idx);
                idx = (idx + 1) % v.size();
            }   // end of while
            psum += sum;
        }   // end of for
        res = Math.min(res, psum);
    }
}
