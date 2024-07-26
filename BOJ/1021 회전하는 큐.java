import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Integer> deque = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 1; i < n + 1; i++) {
            deque.add(i);
        }   // end of for

        int count = 0;
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++) {
            int index = -1;
            int x = Integer.parseInt(st.nextToken());

            for(int j = 0; j < deque.size(); j++) {
                if(deque.get(j) == x) {
                    index = j;
                    break;
                }
            }   // end of for deque

            while(true) {
                if(deque.getFirst() == x) {
                    deque.pollFirst();
                    break;
                }
                count++;
                if(index > deque.size() - index) {
                    deque.addFirst(deque.pollLast());
                } else {
                    deque.addLast(deque.pollFirst());
                }
            }
        }   // end of for m
        System.out.println(count);
    }
}   // end of for Main
