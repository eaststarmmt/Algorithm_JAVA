import java.io.*;
import java.util.*;

class Main {
    static List<List<Integer>> graph;
    static boolean[] dfsVisited, bfsVisited;
    static int n, m ,v;
    static StringBuilder sb;
    static void dfs(int x) {
        dfsVisited[x] = true;
        sb.append(x);

        for (int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if (!dfsVisited[y]) {
                sb.append(' ');
                dfs(y);
            }
        }   // end of for
    }

    static void bfs(int start) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);
        bfsVisited[start] = true;

        while (!Q.isEmpty()) {
            int x = Q.poll();
            sb.append(x).append(' ');
            for (int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if (!bfsVisited[y]) {
                    bfsVisited[y] = true;
                    Q.add(y);
                }
            }   // end of for
        }   // end of while
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        dfsVisited = new boolean[1001];
        bfsVisited = new boolean[1001];
        graph = new ArrayList<>();

        for(int i = 0; i < 1001; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }   // end of for

        for(int i = 1; i <= n; i++) {
            graph.get(i).sort((a1, a2) -> {
                return a1 - a2;
            });
        }   // end of for

        dfs(v);
        sb.append('\n');
        bfs(v);
        System.out.println(sb);
    }
}