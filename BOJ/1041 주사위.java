import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dice = new int[7];
        int dMax = 0;
        long res = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
            res += dice[i];
            dMax = Math.max(dice[i], dMax);
        }   // end of for

        if(N == 1) {
            System.out.println(res - dMax);
            return;
        }

        int[] select = new int[3];
        select[0] = Math.min(dice[1], dice[6]);
        select[1] = Math.min(dice[2], dice[5]);
        select[2] = Math.min(dice[3], dice[4]);

        Arrays.sort(select);
        long side1 = select[0];
        long side2 = side1 + select[1];
        long side3 = side2 + select[2];

        res = side3 * 4;
        res += side2 * (8 * N - 12);
        res += side1 * (1L * N * N * 5 - 16 * N + 12);

        System.out.println(res);
    }
}