import java.io.*;
import java.util.*;

public class Main {
    static int N, r, c, cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        divideCon(0, 0, 1 << N, sb);

        System.out.print(sb);
    }

    static void divideCon(int startR, int startC,int size, StringBuilder sb) {
        if(startR == r && startC == c) {    // 원하는 위치 찾았을 때
            sb.append(cnt).append('\n');
            return;
        }

        if(startR <= r && r < startR + size && startC <= c && c < startC + size) {  // 범위 내에 있는 경우
            divideCon(startR, startC, size / 2, sb);					// 왼쪽부터 순서대로 찾아야 됨. 안그러면 카운팅 꼬임
            divideCon(startR, startC + size / 2, size / 2, sb);
            divideCon(startR + size / 2, startC, size / 2, sb);
            divideCon(startR + size / 2, startC + size / 2, size / 2, sb);
        } else {
            cnt += size * size;		// 범위 내에 없는 경우는 현재 갖고 있는 size의 제곱을 더함. 어차피 순서대로 했기 때문에 더해주면 됨
        }
    }
}