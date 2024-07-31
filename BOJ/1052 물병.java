import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int ans = 0;
        int cnt = (int) 1e9;

        while(cnt > K) {
            int ing = N;
            cnt = 0;

            do {
                ing = ing & ing - 1;
                cnt++;
            } while (ing > 0);

            if (cnt <= K) break;

            ans += N & -N;
            N += N & -N;
        }   // end of while
        System.out.println(ans);
    }
}
