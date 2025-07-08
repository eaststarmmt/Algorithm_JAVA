import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] num;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }   // end of for

        Arrays.sort(num);
        int cnt = 0;

        for(int i = 0; i < N; i++) {    // 이분탐색 개념 비슷하게 이용. i번째 값 되는지 찾기
            int start = 0;
            int end = N - 1;

            while(start < end) {        // 같은거 두번 못 더해서 end가 클 때만 사용 가능
                long sum = num[start] + num[end];
                if (sum == num[i]) {
                    if (start != i && end != i) {
                        cnt++;
                        break;
                    } else if (start == i) {    // start가 같으므로 오른쪽으로 이동
                        start++;
                    } else if (end == i) {      // start가 같으므로 왼쪽으로 이동
                        end--;
                    }
                } else if (sum < num[i]) {      // 정렬 되어 있으므로 작을 경우 왼쪽 포인터를 오른쪽으로 이동
                    start++;
                } else {                        // 클 경우 오른쪽 포인터를 왼쪽으로 땡겨서 값 조절
                    end--;
                }
            }
        }   // end of for
        System.out.println(cnt);
    }
}