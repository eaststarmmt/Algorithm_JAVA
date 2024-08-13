import java.io.*;
import java.util.*;

public class Main {

    static int v, radius, far_idx;
    static List<List<int[]>> dis;   // <노드번호, 거리> 형태로 저장
    static boolean[] visited;

    static void dfs(int x, int sum) {
        visited[x] = true;
        if(radius < sum) {      // ㄱㅏ장 멀리 있는 곳의 인덱스 저장
            radius = sum;
            far_idx = x;
        }

        for(int i = 0; i < dis.get(x).size(); i++) {
            int y = dis.get(x).get(i)[0];
            if(!visited[y]) {
                dfs(y, sum + dis.get(x).get(i)[1]);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        v = Integer.parseInt(br.readLine());

        visited = new boolean[100001];
        dis = new ArrayList<>();
        for(int i = 0; i < 100001; i++) {
            dis.add(new ArrayList<int[]>());
        }   // end of for

        for(int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            while(true) {
                int b = Integer.parseInt(st.nextToken());
                if(b == -1) break;
                int c = Integer.parseInt(st.nextToken());
                dis.get(a).add(new int[]{b, c});
            }   // end of while
        }   // end of for

        dfs(1, 0);
        visited = new boolean[100001];
        dfs(far_idx, 0);

        System.out.println(radius);
    }
}