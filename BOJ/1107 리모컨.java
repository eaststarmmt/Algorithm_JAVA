import java.io.*;
import java.util.*;
public class Main {
    static boolean[] button = {true, true, true, true, true, true, true, true, true, true};
    static int N, M, res, len;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        if(M != 0) {    // 고장난 버튼이 있을때만 입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                int b = Integer.parseInt(st.nextToken());
                button[b] = false;
            }   // end of for

        }

        res = Math.abs(100 - N);    // 차이만큼 무조건 누르는 방법
        for(int i = 0; i <= 1000000; i++) {
            if(checked(i)) {
                int x = Math.abs(N - i) + len;
                res = x < res ? x : res;
            }
        }   // end of for
        System.out.println(res);
    }

    private static boolean checked(int x) {
        String check = Integer.toString(x);
        len = check.length();
        for(char c : check.toCharArray()) {
            if(!button[c - '0']) return false;   // 하나라도 안눌리면 의미 없음
        }
        return true;
    }

}
