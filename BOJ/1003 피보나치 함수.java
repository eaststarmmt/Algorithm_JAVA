import java.io.*;
import java.util.*;

public class Main {
    static int[] z, o;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        z = new int[41];
        o = new int[41];

        z[0] = o[1] = 1;

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            for(int j = 2; j <= n; j++) {
                if(o[j] != 0 || z[j] != 0) continue;
                z[j] = z[j - 1] + z[j - 2];
                o[j] = o[j - 1] + o[j - 2];
            }   // end of for
            sb.append(z[n]).append(' ').append(o[n]).append('\n');
        }   // end of for
        System.out.print(sb);
    }   // end of for main
}   // end of for Main
