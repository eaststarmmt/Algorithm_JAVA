import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static private int N, M;
    static int[] parent;
    static private List<int[]> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        graph = new ArrayList<>();
        StringTokenizer st;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.add(new int[]{a, b, c});
        }   // end of for

        Collections.sort(graph, (arr1, arr2) -> {
            return arr1[2] - arr2[2];
        });

        int res = 0;

        for(int[] info : graph) {
            int a = info[0];
            int b = info[1];
            int c = info[2];

            if(findParent(a) == findParent(b)) continue;
            unionParent(a, b);
            res += c;
        }   // end of for graph

        System.out.println(res);
    }

    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);

        if(a > b) parent[b] = a;
        else parent[a] = b;
    }

    private static int findParent(int x) {
        if(x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }
}