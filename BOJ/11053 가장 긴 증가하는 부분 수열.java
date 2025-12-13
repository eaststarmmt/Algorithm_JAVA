import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = new int[N];
        for(int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }   // end of for

        System.out.println(lis());
    }

    private static int lis() {
        int[] lisArr = new int[N];
        int cnt = 0;

        for (int target : a) {
            int idx = lowerBound(lisArr, cnt, target);
            if (idx == -1) {
                lisArr[cnt] = target;
                cnt++;
            }
            else {
                lisArr[idx] = target;
            }
        }

        return cnt;
    }

    private static int lowerBound(int[] lisArr, int cnt, int target) {
        int lo = 0;
        int hi = cnt;
        int idx = -1;

        while(lo <= hi) {
            int mid = (lo + hi) / 2;

            if(lisArr[mid] >= target) {
                idx = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }   // end of while
        return idx;
    }
}