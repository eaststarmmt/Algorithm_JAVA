import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> meetingList = new ArrayList<>();

        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetingList.add(new int[]{start, end});
        }   // end of for

        meetingList.sort((arr1, arr2) -> {
            if(arr1[1] == arr2[1]) return arr1[0] - arr2[0];
            return arr1[1] - arr2[1];
        });

        int preEnd = meetingList.get(0)[1];
        int res = 1;

        for(int i = 1; i < N; i++) {
            int curStart = meetingList.get(i)[0];
            int curEnd = meetingList.get(i)[1];

            if(curStart >= preEnd) {
                res++;
                preEnd = curEnd;
            }
        }   // end of for

        System.out.println(res);
    }
}