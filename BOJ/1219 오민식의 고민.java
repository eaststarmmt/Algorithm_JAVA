import java.io.*;
import java.util.*;
class Main {

    static int N, S, E, M, t1, t2, t3;
    static final long INF = (long) 1e18;
    static int[] visited;
    static List<List<int[]>> graph;
    static long[] d, cost;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        d = new long[104];
        Arrays.fill(d, -INF);

        graph = new ArrayList<>();
        for(int i = 0; i < 104; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            t1 = Integer.parseInt(st.nextToken());
            t2 = Integer.parseInt(st.nextToken());
            t3 = Integer.parseInt(st.nextToken());

            graph.get(t1).add(new int[]{t2, t3});
        }   // end of for

        st = new StringTokenizer(br.readLine());
        cost = new long[104];

        for(int i = 0; i < N; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }   // end of for

        d[S] = cost[S];
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int here = 0; here < N; here++) {
                for (int[] p : graph.get(here)) {
                    int there = p[0];
                    int dist = p[1];

                    if (d[here] != -INF && d[here] - dist + cost[there] > d[there]) {   // 완화. 기존값보다 커지기 때문에 음의 사이클은 아님
                        d[there] = d[here] - dist + cost[there];
                        if(i == N - 1) Q.add(there);
                    }
                }   // end of for graph
            }   // end of for here
        }   // end of for N

        boolean flag = false;   // 방문 가능 여부 체크용 플래그
        visited = new int[104];

        while (!Q.isEmpty()) {
            int x = Q.poll();

            if(x == E) {
                flag = true;    // 여기서  표시 안하면 싸이클이 있는지 없는지 모름
                break;
            }

            for (int[] p : graph.get(x)) {
                int next = p[0];
                if(visited[next] != 0) continue;
                visited[next] = 1;
                Q.add(next);
            }   // end of for
        }   // end of while

        if(d[E] == -INF) sb.append("gg");
        else if(flag) sb.append("Gee");
        else sb.append(d[E]);

        System.out.println(sb);
    }
}