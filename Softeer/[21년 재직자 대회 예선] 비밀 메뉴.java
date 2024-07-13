import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static String a, secret;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        secret = br.readLine();
        a = br.readLine();

        if(!a.contains(secret)) System.out.println("normal");
        else System.out.println("secret");
    }
}
