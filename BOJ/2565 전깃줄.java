import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    private static final int INF = (int) 1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[] line = new int[504];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            line[from] = to;
        }   // end of for

        System.out.println(n - lis(line, n));
    }

    private static int lis(int[] line, int n) {
        int[] lisArr = new int[n + 1];
        int cnt = 0;
        Arrays.fill(lisArr, INF);

        for (int x : line) {
            if(x == 0) continue;

            int idx = lowerBound(lisArr, cnt, x);
            if(lisArr[idx] == INF) {
                cnt++;
            }

            lisArr[idx] = x;
        }   // end of for

        return cnt;
    }

    private static int lowerBound(int[] lisArr, int cnt, int target) {
        int lo = 0;
        int hi = cnt;
        int idx = 0;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(lisArr[mid] >= target) {
                hi = mid - 1;
                idx = mid;
            } else {
                lo = mid + 1;
            }
        }   // end of while
        return idx;
    }
}