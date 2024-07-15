import java.io.*;
import java.util.*;

public class Main {
    static int N, M, s, t;
    static String r;
    static int[][] reservation;         // 회의실 인덱스, 시간
    static String[] room;
    static Map<String, Integer> m;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        room = new String[N];

        for(int i = 0; i < N; i++) {
            room[i] = br.readLine();
        }   // end of for

        Arrays.sort(room);
        m = new HashMap<>();

        for(int i = 0; i < N; i++) {
            m.put(room[i], i);
        }   // end of for N

        reservation = new int[N][19];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            r = st.nextToken();
            s = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            mark();
        }   // end of for M

        for(int i = 0; i < N; i++) {
            print(i, sb);
        }

        System.out.print(sb);
    }

    private static void print(int idx, StringBuilder sb) {
        if(idx != 0) sb.append("-----\n");
        sb.append("Room ").append(room[idx]).append(":\n");
        List<String> v = new ArrayList<>();
        int start = 0;
        for(int i = 9; i <= 18; i++) {
            if(reservation[idx][i] != 0 && start != 0) {    // 예약 되어 있고 비어있는 시간 측정하고 있던 경우 저장
                String start_time = "0" + start;
                v.add((start_time.substring(start_time.length() - 2)) + '-' + i);
                start = 0;
            } else if(reservation[idx][i] != 0) continue;   // 예약중인 경우 무시. 더 이상 예약 조건을 고려하지 않기 위한 추가 조건. 밑에 조건부터는 다 false
            else if(start == 0) start = i;  // 시작점이 없는 경우 시작점 갱신
        }   // end of for

        if(start != 0) {    // for문이 끝나는 바람에 18시까지 가능한 경우 벡터에 저장이 안된 경우
            String start_time = "0" + start;
            v.add((start_time.substring(start_time.length() - 2)) + '-' + 18);
        }

        if(v.isEmpty()) {
            sb.append("Not available\n");
            return;
        }

        sb.append(v.size()).append(" available:\n");

        for(String time : v) {
            sb.append(time).append('\n');
        }   // end of for
    }

    static void mark() {
        int idx = m.get(r);
        for(int i = s; i < t; i++) {
            reservation[idx][i]++;
        }   // end of for

        if(t == 18) reservation[idx][t]++;
    }
}
