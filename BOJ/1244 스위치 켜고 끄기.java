import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> swit = new ArrayList<>();
        swit.add(0);			// 1번째 인덱스부터 확인하기 위해 의미없는 0을 넣어줌

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            swit.add(x);
        }

        int student = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < student; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            switch (gender) {
                case 1:
                    for(int j = num; j <= n; j++) {     // 남자인 경우 num 이하 인덱스는 볼 필요 없음
                        if(j % num == 0) {              // num의 배수일 경우 숫자 바꿈
                            swit.set(j, (swit.get(j) + 1) % 2);
                        }
                    }
                    break;
                case 2:
                    swit.set(num, (swit.get(num) + 1) % 2);
                    for (int j = 1; j <= n; j++) {          // 여자의 경우 num번째 인덱스는 무조건 누름
                        int left = num - j;                 // 좌우 인덱스 대칭 이동
                        int right = num + j;
                        if((left < 1) || (right > n)) break;    // 인덱스 범위를 넘어가면 break;

                        if (swit.get(left) == swit.get(right)) {    // 좌우 같으면 값 바꿔줌
                            swit.set(left, (swit.get(left) + 1) % 2);
                            swit.set(right, swit.get(left));
                        } else break;                           // 대칭이 아니면 종료
                    }
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(swit.get(i)).append(' ');
            if(i % 20 == 0) sb.append('\n');
        }
        System.out.println(sb);
    }
}