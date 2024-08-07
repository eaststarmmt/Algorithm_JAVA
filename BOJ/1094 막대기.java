import java.io.*;
import java.util.*;
public class Main {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int res = 0;

        while(N > 0) {
            if((N & 1) != 0) res++;
            N >>= 1;
        }

        System.out.println(res);
    }

}
