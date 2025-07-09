import java.io.*;
import java.util.*;

class Main {
    static int N;
    static final int INF = (int) 1e9;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        List<int[]> work = new ArrayList<>();


        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            work.add(new int[]{x, y});
        }   // end of for N

        work.sort((a1, a2) -> {
            return a2[1] - a1[1];
        });

        int early = INF;

        for (int i = 0; i < work.size(); i++) {
            if(early > work.get(i)[1]) early = work.get(i)[1];
            early -= work.get(i)[0];
        }
        if(early < 0) System.out.println(-1);
        else System.out.println(early);
    }
}