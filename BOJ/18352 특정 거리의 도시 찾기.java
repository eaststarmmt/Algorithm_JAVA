import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K, X;  // 도시 개수(노드), 도로 개수(간선), 거리정보, 출발 도시의 번호
    static int[] visited;
    // graph[1]은 1번 노드에서 갈 수 있는 곳을 또 list로 받는 구조. 그래서 list안에 list
    // 예를들어 1번에서 2 3 4 를 갈 수 있으면 graph[1].add(2), add(3), add(4) 이런식으로 들어 있음
    static List<List<Integer>> graph;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        visited = new int[N + 4];   // 방문 여부 체크와 거리 기록용. 각 인덱스는 X로부터의 거리가 기록됨

        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {   // 인덱스가 각 노드번호를 의미. 즉 노드 개수만큼 필요한데 인덱스 1부터 써서 N + 1개 필요
            graph.add(new ArrayList<>());
        }

        // 입력값으로 인접리스트(그래프)를 만드는 부분. 그래프는 간선 만큼 입력을 받음
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());    // 한줄 입력받음.
            int A = Integer.parseInt(st.nextToken());   // 출발점
            int B = Integer.parseInt(st.nextToken());   // 도착점
            // 그래프A 인덱스의 그래프에 B를 넣음. A -> B 가능.
            // B -> A 도 가능하게 하려면 graph.get(B).add(A) 넣어줘야 하는데 이 문제에서는 단방향이라고 언급해서 안넣는게 맞음
            graph.get(A).add(B);
        }   // end of for

        List<Integer> res = bfs();  // 정답을 array list로 받음. 이유는 그냥 sort가 편해서

        StringBuilder sb = new StringBuilder();

        for(int x : res) {
            sb.append(x).append('\n');  // 이렇게 단어 하나 하나 append 하는게 제일 빠르다고 함. 하나 넣고 개행문자.
        }
        // 존재하지 않으면 -1. 있으면 오름차순 출력
        if(res.isEmpty()) System.out.println(-1);
        else System.out.print(sb);
    }

    private static List<Integer> bfs() {
        List<Integer> res = new ArrayList<>();  // 정답 담을 list 변수
        Queue<Integer> Q = new LinkedList<>();  // 그래프 인덱스만 알면 되기 때문에 Integer로 담음
        Q.add(X);   // 시작점 입력. X부터 시작하므로 X부터 거리를 구하게 됨
        visited[X] = 1;     // 시작점 다시 지나면 안되기 때문에 방문 체크

        while(!Q.isEmpty()) {
            int cur = Q.poll();     // 현재 위치 인덱스.

            //  cur에서 갈 수 있는 곳 체크. 예를 들어 2번에서 4 5번을 갈 수 있으면 next는 4, 5가 됨
            for(int next : graph.get(cur)) {
                if(visited[next] != 0) continue;    // 간 적 있으면 무시

                // 이 문제는 별다른 조건이 없어서 간 적 있으면 이제 다 넣으면 됨
                Q.add(next);
                visited[next] = visited[cur] + 1;

                // 이 문제의 정답 조건. 이동 거리가 K이면 출력해야 됨. 처음에 1부터 시작했으므로 1 빼주면 X부터의 거리
                if(visited[next] - 1 == K) {
                    res.add(next);
                }
            }   // end of for graph

        }   // end of while

        Collections.sort(res);  // 이 문제의 조건. 오름차순으로 출력하라.
        return res;
    }
}
