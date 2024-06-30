import java.io.*;
import java.util.*;


public class Main {
    static int N, x, res, dif = (int)1e9;
    static List<Integer> v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        v = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            x = Integer.parseInt(st.nextToken());
            v.add(x);
        }

        Collections.sort(v);

        for(int i = 1; i < N; i++) {
            if(v.get(i) - v.get(i - 1) < dif) {
                dif = v.get(i) - v.get(i - 1);
                res = 1;
            } else if(v.get(i) - v.get(i - 1) == dif) res++;
        }

        System.out.println(res);
    }
}