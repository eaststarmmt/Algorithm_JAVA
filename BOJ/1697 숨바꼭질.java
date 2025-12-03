import java.util.*;
import java.io.*;

public class Main {
    static int N, K;    // 수빈이가 있는 위치, 동생이 있는 위치
    static int[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 방문 여부 체크와 해당 인덱스에 몇초만에 갔는지. visited[2] = 3은 2번까지 (3 - 1)초 걸렸다는 의미
        // 이 문제는 위치 범위가 10만까지임. 그런데 뒤로 돌아오는 경우도 따져야 되기 때문에 10만이 넘을 수도 있다고 판단해서 20만까지 잡음.
        visited = new int[200004];

        System.out.println(bfs());
    }

    private static int bfs() {
        int res = 0;
        Queue<Integer> Q = new LinkedList<>();  // 위치만 알면 되기 때문에 Integer로 담음
        Q.add(N);   // 시작점 입력. 수빈이 위치부터 동생 위치 찾기
        visited[N] = 1;     // 시작점 다시 지나면 안되기 때문에 방문 체크

        while(!Q.isEmpty()) {
            int cur = Q.poll();     // 현재 위치

            // 수빈이 위치 찾은 경우.
            if(cur == K) {
                res = visited[cur] - 1;     // visited는 1부터 시작했으므로 1 빼줘야 걸린 시간이 됨
                break;
            }   // end of for graph

            // 갈 수 있는 방법 하나씩 확인.
            // 한 칸 앞으로 이동
            // 한 칸 갔을때 너무 많이 갔으면 무시. 한 칸이라 10만 넘어가면 사실상 확인하는 의미가 없음.
            // visited로 간적 있는지 중복 확인.
            int next = cur + 1;
            if(next <= 100000 && visited[next] == 0) {
                Q.add(next);
                visited[next] = visited[cur] + 1;
            }
            // 한 칸 뒤로 이동
            // 뒤로 0보다 많이 가면 어차피 못찾기 때문에 범위 안에만 체크
            next = cur - 1;
            if(next >= 0 && visited[next] == 0) {
                Q.add(next);
                visited[next] = visited[cur] + 1;
            }

            // 2배 이동
            // 여기가 애매한게 10만 넘어갔다 다음번에 뒤로 오는 경우가 있을 수 있어서 충분히 많이 20만 잡음
            next = cur * 2;
            if(next <= 200000 && visited[next] == 0) {
                Q.add(next);
                visited[next] = visited[cur] + 1;
            }
        }   // end of while

        return res;
    }
}
