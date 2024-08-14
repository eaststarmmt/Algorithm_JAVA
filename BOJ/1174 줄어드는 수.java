import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Long> decrease = new ArrayList<>();
        Queue<Long> Q = new LinkedList<>();

        for(long i = 0; i <= 9; i++) {  // 0 ~ 9 까지 한자리 수는 다 넣어둠
            decrease.add(i);
            Q.add(i);
        }   // end of for

        while(!Q.isEmpty()) {
            if(decrease.size() == N) break; // 원하는 순서의 값이 구해지면 중단
            long x = Q.poll();              // Q는 현재 오름차순으로 들어가 있음
            for(int i = 0; i < x % 10; i++) {   // x의 1의자리수보다 크지 않은 숫자를 뒤에 붙여줌
                long y = x * 10 + i;        // x의 값에 10을 곱해서 자리수를 올려주고 기존의 수보다 작은 수를 뒤에 붙여줌
                decrease.add(y);
                Q.add(y);       // 이 값을 넣는 이유는 줄어드는 숫자가 완성 된 값에 1의 자리에 더 작은 숫자를 붙여주는 작업을 반복하기 위함
            }
        }   // end of while

        long res = -1;

        if(N <= decrease.size()) res = decrease.get(N - 1);

        System.out.println(res);
    }
}