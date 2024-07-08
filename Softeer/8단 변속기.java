import java.io.*;
import java.util.*;

public class Main {
    static int a[];
    static boolean asc, des;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = new int[8];

        for(int i = 0; i < 8; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < 8; i++) {
            if(a[i] > a[i - 1]) asc = true;
            else des = true;
        }

        if(asc && des) System.out.println("mixed");
        else if(asc) System.out.println("ascending");
        else System.out.println("descending");
    }
}
