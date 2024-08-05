import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] dif = new boolean[50][50];
    static int[][] a = new int[50][50];
    static int[][] b = new int[50][50];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> crane = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        List<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        crane.sort((a1, a2) -> {
                    return a2 - a1;
                }
        );
        box.sort((a1, a2) -> {
                    return a2 - a1;
                }
        );

        if (crane.get(0) < box.get(0)) {	// 박스가 크레인 허용 무게보다 크면 종료
            System.out.println(-1);
            return;
        }

        int time = 0;
        while (m > 0) {
            for (int i = 0; i < crane.size(); i++) {
                for (int j = 0; j < box.size(); j++) {
                    if (crane.get(i) >= box.get(j)) {	// 박스 옮길 수 있으면 다음 크레인으로
                        box.remove(j);
                        m--;	// 남은 박스 수 카운팅
                        break;
                    }
                }	// end of for box
            }	// end of for crane
            time++;
        }	// end of while
        System.out.println(time);
    }
}