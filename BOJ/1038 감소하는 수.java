import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N <= 9) {
            System.out.println(N);
            System.exit(0);
        }
        ArrayList<Long> decrease = new ArrayList<>();
        Queue<Long> Q = new LinkedList<>();

        for(int i = 1; i <= 9; i++) {
            decrease.add((long) i);
            Q.offer((long) i);
        }

        while(!Q.isEmpty()) {
            if(decrease.size() == N) break;
            long x = Q.poll();
            for(int i = 0; i < x % 10; i++) {
                long y = x * 10 + i;
                decrease.add(y);
                Q.offer(y);
            }
        }
        if(N > decrease.size())
            System.out.println(-1);
        else
            System.out.println(decrease.get(N - 1));
    }
}