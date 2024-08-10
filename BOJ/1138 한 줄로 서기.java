import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static List<Integer> input, result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            input.add(Integer.parseInt(st.nextToken()));
        }   // end of for

        result = new ArrayList<>();
        for(int i = N - 1; i >= 0; i--) {
            int j = input.get(i);   // 왼쪽에 있는 사람 수 만큼 이동하기 위해 들어갈 자리 체크
            result.add(j, i + 1);   // 저장은 인덱스인 i + 1을 해줘야 됨
        }

        for(int x : result) {
            sb.append(x).append(' ');
        }
        System.out.println(sb);
    }
}
