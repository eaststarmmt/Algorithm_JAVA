import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            list.add(br.readLine());
        }   // end of for

        list.sort((a, b) -> {
            if(a.length() == b.length()) return a.compareTo(b); // 길이 같으면 사전순
            return a.length() - b.length(); // 길이 오름차순
        });

        for(int i = 0; i < N; i++) {
            if((i > 0) && (list.get(i).equals(list.get(i - 1)))) continue;
            sb.append(list.get(i)).append('\n');
        }   // end of for

        System.out.print(sb);
    }
}