import java.io.*;
import java.util.*;

public class Main {
    static int N, M, res;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer> v1 = input(br, N);
        List<Integer> v2 = input(br, M);

        for(int i = 0; i < 100; i++) {
            res = Math.max(res, v2.get(i) - v1.get(i));
        }   // end of for

        System.out.println(res);
    }

    static List<Integer> input(BufferedReader br, int N) throws Exception {
        List<Integer> v = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for(int j = 0; j < a; j++) {
                v.add(b);
            }   // end of for a
        }   // end of for N
        return v;
    }
}
