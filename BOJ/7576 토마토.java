import java.io.*;
import java.util.*;

class Main {

    static int N, M, cnt;
    static int[][] a, visited;     // 문제 조건에 맞게 입력받을 지도, 방문 여부 및 얼마나 걸렸는지 체크하는 지도
    static int[] dr = {-1, 1, 0, 0};    // BFS에서 사용하는 이동하기 위한 값. 이동하는 행을 의미. 상 하 좌 우. 맵에서 위로 가려면 행이 -1 아래로 가려면 +1
    static int[] dc = {0, 0, -1, 1};    // BFS에서 사용하는 이동하기 위한 값. 이동하는 열을 의미. 상 하 좌 우. 맵에서 왼쪽으로 가려면 열이 -1 오른쪽은 + 1
    public static int bfs(Queue<int[]> Q) {
        // 최소 며철이 걸리는지 알려주기 위해 사용할 이 메서드의 return 값
        // 최소 며칠이나 묻는건 토마토가 다 익는데 걸리는 시간.
        // 다시 말하면 가장 마지막에 익은 토마토가 걸린 시간. 즉 토마토가 익은 시간 중 최대값
        // 이 문제도 익은 토마토가 가장 멀리 있는 안익은 토마토까지 가는데 걸리는 시간(거리)를 구하는 개념
        int res = 0;

        // 원래 Q에 시작점 넣고 해야 되는데 이미 main 메서드에서 넣었기 때문에 여기서는 바로 while 돌리면서 탐색

        while(!Q.isEmpty()) {   // 큐가 비면 더 이상 다음 이동이 없다는 의미. visited가 있으므로 큐는 절대 중복된 값이 들어오지 않는다!!!
            // 큐의 front 값을 저장. 자바에서 poll을 하면 큐의 front 값을 가져오면서 pop도 됨
            // 이 pos가 토마토의 위치임.
            int[] pos = Q.poll();
            int r = pos[0];
            int c = pos[1];

            // 현재 토마토를 기준으로 사방에 있는 토마토를 확인하는 작업
            for(int i = 0; i < 4; i++ ){    // 전역변수로 선언한 dr, dc 쓰는 부분. 상 하 좌 우 for문으로 확인
                int nr = r + dr[i]; // 위를 기준으로 설명하면 r = 현재 행 위치 dr[0] = -1. 즉 현재 위치에서 행을 -1 하면 위로 올라감(1, 1) -> (0, 1)
                int nc = c + dc[i]; // 위를 기준으로 c = 현재 열 위치 dc[0] = 0. 즉 현재 위치에서 위로 갈때 행은 변하지 않음.

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;    // 지도에서 벗어나는지 체크. 이거 안하면 인덱스 벗어나서 터짐

                // 갔던곳 또 가면 무한 반복. 우리는 몇번만에 가는거 가능한지 구하는데 왔다갔다 하면 숫자만 커짐.
                // 예를들어 1번만에 가놓고 앞으로 한번 뒤로 한번 해서 3번만에 가지고 한번 더 반복하면 5번만에 가짐. 이러면 정확한 거리가 측정이 안됨
                if(visited[nr][nc] != 0) continue;

                if(a[nr][nc] == -1) continue;    // 문제 조건에서 -1은 갈 수 없는 곳. 토마토가 없는데 갈 이유가 없음.

                // 위에까지는 예외상황에 대한 처리. 여기서부터 문제 풀이 로직
                // 갈 수 있는 곳. nr, nc 기준으로 다시 4방 탐색하고 체크해야 되므로 큐에 저장. 이렇게 add 된 순서로 탐색 진행 됨
                Q.add(new int[]{nr, nc});

                // visited를 방문 여부를 체크하는 용도로 쓰지만 이렇게 1씩 늘려주면 거리 체크 가능
                // r, c까지 거리 3이면 nr, nc는 r, c와 인접해 있으므로 거리가 4가 됨. 만약 거리가 2가 되는 곳이면 visited != 0 에서 걸러져서 여기까지 안옴
                visited[nr][nc] = visited[r][c] + 1;

                // 처음에 시작 위치를 1로 시작했기 때문에 걸린 시간은 res - 1이 되어야 함
                // bfs 특성상 가장 멀리 있는 것이 가장 마지막에 카운팅 됨. 즉 마지막에 들어온 visited가 가장 큰 값
                res = visited[nr][nc] -1;
                cnt--;  // 다음 방문한다는 것은 nr,nc에 있는 토마토가 익는다는 의미. 안 익은 토마토의 개수를 의미하는 cnt를 카운팅 해줌
            }
        }   // end of while

        return cnt == 0 ? res : -1;     // 안익은 토마토 없으면 res 계산 결과 출력. 아니면 -1 출력.
    }

    public static void main(String[] args) throws Exception{
        // 입력으로 인한 시간초과를 막기 위해 Buffered Reader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());    // 띄어쓰기 기준으로 나누기 위해 StringTokenizer 사용. br.readLine()으로 한줄이 저장됨

        // 이 문제는 열하고 주는 입력 순서 반대라 주의!!!!
        M = Integer.parseInt(st.nextToken());   // 위에서 저장한 한 줄 중에 띄어쓰기 기준 첫번째 값 빼서 그거 Int로 캐스팅
        N = Integer.parseInt(st.nextToken());   // 위에서 저장한 한 줄 중에 띄어쓰기 기준 두번째 값 빼서 그거 Int로 캐스팅

        a = new int[N + 4][M + 4];      // 괜히 실수로 범위 넘어가서 터지는거 방지하기 위해 안전하게 4정도 여유 두고 선언
        visited = new int[N + 4][M + 4];
        Queue<int[]> Q = new LinkedList<>();    // 시작점(익은 토미토)들을 미리 큐에 넣고 시작하기 위해 선언

        // 여기서부터 문제에 주어진 map을 입력 받음. 이 문제는 각 칸의 값이 띄어쓰기 없이 붙어있음을 주의.
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());    // 한 줄 입력 받음. N번을 입력 받음

            for(int j = 0; j < M; j++) {    // 위에서 입력받은 줄을 이제 한 칸 한 칸 넣어줌
                a[i][j] = Integer.parseInt(st.nextToken()); // st에 입력된 한줄을 띄어쓰기 기준으로 하나씩 입력 받음

                // 익은 토마토를 미리 큐에 넣어 BFS 시작점들을 잡아줌
                if(a[i][j] == 1) {
                    Q.add(new int[]{i, j});
                    visited[i][j] = 1;      // 시작점으로 다시 돌아오는 것을 막기 위해 방문표시(1)
                }

                if(a[i][j] == 0) {
                    cnt++;  // 이 문제에서는 토마토가 모두 익지 않는 경우 -1을 출력해야 되므로 안익은 토마토 카운팅
                }
            }   // end of for j
        }   // end of for i

        System.out.println(bfs(Q));
    }
}