import java.io.*;
import java.util.*;

public class Main {

    static int N, res;
    static List<Integer> v;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            v.add(Integer.parseInt(st.nextToken()));
        }   // end of for

        v.sort((s1, s2) -> {
            return s1 - s2;
        });

        res = Math.max(v.get(0) * v.get(1), v.get(v.size() - 1) * v.get(v.size() - 2));

        System.out.println(res);

    }
}
