import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
class Main {
    static List<List<int[]>> graph;     // 도로 정보 받을 리스트
    static int N, M, X, a, b, time;
    static final int INF = (int) 1e9;
    static int[] d, back;

    static void dijkstra(int start, int[] d) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {   // 우선순위 큐 이용하여 거리가 짧은 순으로 계산
            return a[0] - b[0];
        });
        pq.add(new int[]{0, start});
        d[start] = 0;

        while (!pq.isEmpty()) {
            int arr[] = pq.poll();
            int dist = arr[0];
            int now = arr[1];

            if(d[now] != dist) continue;

            for(int i = 0; i < graph.get(now).size(); i++) {
                int cost = dist + graph.get(now).get(i)[1];
                if (cost < d[graph.get(now).get(i)[0]]) {
                    d[graph.get(now).get(i)[0]] = cost;
                    pq.add(new int[]{cost, graph.get(now).get(i)[0]});
                }
            }
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        d = new int[1001];
        back = new int[1001];

        graph = new ArrayList<>();

        for(int i = 0; i < 1001; i++) {
            graph.add(new ArrayList<>());
        }   // end of for

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            time = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b, time});
        }

        int res = -1;

        Arrays.fill(back, INF);
        dijkstra(X, back);  // 파티장소에서 돌아오는 경우 미리 계산

        for(int i = 1; i <= N; i++) {
            Arrays.fill(d, INF);
            dijkstra(i, d);     // 가는 거리 계산
            int sum = d[X];
            sum += back[i];
            res = sum > res ? sum : res;
        }

        System.out.println(res);
    }
}