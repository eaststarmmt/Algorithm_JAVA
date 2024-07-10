import java.io.*;
import java.util.*;

public class Main {
    static int a[];
    static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        a = new int[20];

        a[0] = 2;

        for(int i = 1; i <= 15; i++) {
            a[i] = 2 * a[i - 1] - 1;
        }

        System.out.println(a[N] * a[N]);
    }
}
