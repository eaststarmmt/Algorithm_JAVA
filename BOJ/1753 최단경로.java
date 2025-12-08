import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static private int V, E, K;
    static private List<List<int[]>> graph;
    static int[] dist;
    final static int INF = (int) 1e9;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        dist = new int[V + 1];
        Arrays.fill(dist, INF);

        graph = new ArrayList<>();

        for(int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }   // end of for

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new int[]{v, w});
        }   // end of for

        dijkstra();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V; i++) {
            sb.append(dist[i] == INF ? "INF" : dist[i]).append('\n');
        }   // end of for
        System.out.print(sb);
    }

    private static void dijkstra() {
        // 우선순위 큐 comparator 구현
        PriorityQueue<int[]> pq = new PriorityQueue<>((arr1, arr2) -> {
            return arr1[1] - arr2[1];   // comparator은 음수가 오름차순
        });

        pq.add(new int[]{K, 0});
        dist[K] = 0;

        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            int cur = info[0];
            int curDist = info[1];

            if(dist[cur] != curDist) continue;

            for (int[] nextInfo : graph.get(cur)) {
                int next = nextInfo[0];
                int nextDist = curDist + nextInfo[1];

                if(nextDist >= dist[next]) continue;

                pq.add(new int[]{next, nextDist});
                dist[next] = nextDist;
            }   // end of for graph
        }   // end of while
    }
}