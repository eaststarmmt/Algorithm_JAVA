import java.io.*;
import java.util.*;

class Main {

    static int N, M;
    static int[][] a, visited;     // 문제 조건에 맞게 입력받을 지도, 방문 여부 및 얼마나 걸렸는지 체크하는 지도
    static int[] dr = {-1, 1, 0, 0};    // 이동하는 행을 의미. 상 하 좌 우. 맵에서 위로 가려면 행이 -1 아래로 가려면 +1
    static int[] dc = {0, 0, -1, 1};    // 이동하는 열을 의미. 상 하 좌 우. 맵에서 왼쪽으로 가려면 열이 -1 오른쪽은 + 1
    public static void bfs(Queue<int[]> Q) {
        // 원래 Q에 시작점 넣고 해야 되는데 이미 main 메서드에서 넣었기 때문에 여기서는 바로 while 돌리면서 탐색
        while(!Q.isEmpty()) {   // 큐가 비면 더 이상 다음 이동이 없다는 의미. visited가 있으므로 큐는 절대 중복된 값이 들어오지 않는다!!!
            int[] pos = Q.poll();   // 큐의 front 값을 저장. 자바에서 poll을 하면 front 값 가져오면서 pop도 됨
            int r = pos[0];
            int c = pos[1];

            for(int i = 0; i < 4; i++ ){    // 전역변수로 선언한 dr, dc 쓰는 부분. 상 하 좌 우 for문으로 확인
                int nr = r + dr[i]; // 위를 기준으로 설명하면 r = 현재 행 위치 dr[0] = -1. 즉 현재 위치에서 행을 -1 하면 위로 올라감(1, 1) -> (0, 1)
                int nc = c + dc[i]; // 위를 기준으로 c = 현재 열 위치 dc[0] = 0. 즉 현재 위치에서 위로 갈때 행은 변하지 않음.

                if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;    // 지도에서 벗어나는지 체크. 이거 안하면 인덱스 벗어나서 터짐
                if(visited[nr][nc] != 0) continue;  // 갔던곳 또 가면 무한 반복. 우리는 몇번만에 가는거 가능한지 구하는데 왔다갔다 하면 숫자만 커짐.
                // 예를들어 1번만에 가놓고 앞으로 한번 뒤로 한번 해서 3번만에 가지고 한번 더 반복하면 5번만에 가짐. 이러면 정확한 거리가 측정이 안됨
                if(a[nr][nc] == 0) continue;    // 문제 조건에서 0은 갈 수 없는 곳. 심지어 거리도 0으로 출력하면 되므로 그냥 무시

                // 위에까지는 예외상황에 대한 처리. 여기서부터 문제 풀이 로직
                Q.add(new int[]{nr, nc});   // 갈 수 있는 곳. nr, nc 기준으로 다시 4방 탐색하고 체크해야 되므로 큐에 저장

                // visited를 방문 여부를 체크하는 용도로 쓰지만 이렇게 1씩 늘려주면 거리 체크 가능
                // r, c까지 거리 3이면 nr, nc는 r, c와 인접해 있으므로 거리가 4가 됨. 만약 거리가 2가 되는 곳이면 visited != 0 에서 걸러져서 여기까지 안옴
                visited[nr][nc] = visited[r][c] + 1;
            }
        }   // end of while
    }

    public static void print(){
        StringBuilder sb = new StringBuilder(); // 여기에 출력할 문자열 한번에 담을 예정

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int distance = visited[i][j] - 1;   // 시작위치를 1로 잡았으니 실제로는 -1씩 빼줘야 됨
                if(a[i][j] == 0) distance = 0;  // 문제에서 원래 갈 수 없는 땅은 0을 출력 하라 했으므로.

                sb.append(distance).append(' ');   // append로 하나씩 일일히 나눠서 넣어야 빠름.
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
    public static void main(String[] args) throws Exception{
        // 입력으로 인한 시간초과를 막기 위해 Buffered Reader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());    // 띄어쓰기 기준으로 나누기 위해 StringTokenizer 사용. br.readLine()으로 한줄이 저장됨

        N = Integer.parseInt(st.nextToken());   // 위에서 저장한 한 줄 중에 띄어쓰기 기준 첫번째 값 빼서 그거 Int로 캐스팅
        M = Integer.parseInt(st.nextToken());   // 위에서 저장한 한 줄 중에 띄어쓰기 기준 두번째 값 빼서 그거 Int로 캐스팅

        a = new int[N + 4][M + 4];      // 괜히 실수로 범위 넘어가서 터지는거 방지하기 위해 안전하게 4정도 여유 두고 선언
        visited = new int[N + 4][M + 4];
        Queue<int[]> Q = new LinkedList<>();    // 목표지점(시작점)을 미리 큐에 넣고 시작하기 위해 선언

        // 여기서부터 문제에 주어진 map을 입력 받음
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());    // 한 줄 입력 받음. N번을 입력 받음

            for(int j = 0; j < M; j++) {
                a[i][j] = Integer.parseInt(st.nextToken()); // st에 입력된 한줄을 띄어쓰기 기준으로 하나씩 입력 받음
                if(a[i][j] == 2) {
                    Q.add(new int[]{i, j});     // 시작점 미리 큐에 넣어놓음. [0]이 행. [1]이 열
                    visited[i][j] = 1;  // 시작점이라 0이 맞지만 초기값이 0이라 1로 표시
                }
            }   // end of for j
        }   // end of for i
        bfs(Q);
        print();
    }
}