import java.io.*;
import java.util.*;

class Main {

    static int A, B;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> m = new HashMap<>();
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < A; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(m.containsKey(x)) m.put(x, m.get(x) + 1);
            else m.put(x, 1);
        }   // end of for

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < B; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(m.containsKey(x)) m.put(x, m.get(x) + 1);
            else m.put(x, 1);
        }   // end of for

        int res = 0;
        for (Integer key : m.keySet()) {
            if(m.get(key) == 1) res++;
        }
        System.out.println(res);
    }
}