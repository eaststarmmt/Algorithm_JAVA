import java.io.*;
import java.util.*;

class Main {
    static int N, K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        List<int[]> jam = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jam.add(new int[]{m, v});
        }   // end of for

        List<Integer> bag = new ArrayList<>();

        for(int i = 0; i < K; i++) {
            bag.add(Integer.parseInt(br.readLine()));
        }   // end of for
        jam.sort((i1, i2) -> {      // 보석 무게로 오름차순 정렬
            return i1[0] - i2[0];
        });
        bag.sort((i1, i2) -> {      // 가방 무게 오름차순으로 정렬
            return i1.compareTo(i2);
        });

        PriorityQueue<Integer> value = new PriorityQueue<>((i1, i2) -> {
            return i2 - i1;
        });

        long sum = 0;
        int idx = 0;    // 우선순위 큐에 넣은 인덱스 알기 위해
        // 가방이 오름차순이므로 이전에 넣었던 보석들은 다시 해보지 않아도 들어감
        // 다음 인덱스부터 해서 이미 넣은 보석이 없는 상태로 우선순위 큐가 구성될 수 있음
        // 작은 가방에 넣을 수 있는 가장 비싼 보석을 하나하나 채워가는 방법

        for(int i = 0; i < K; i++) {
            while(idx < N && jam.get(idx)[0] <= bag.get(i)) {
                value.add(jam.get(idx)[1]);
                idx++;
            }   // end of while

            if(!value.isEmpty()) {
                sum += value.poll();
            }
        }   // end of for

        System.out.println(sum);
    }
}