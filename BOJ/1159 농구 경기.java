import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] counting;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        counting = new int[26];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            counting[s.charAt(0) - 'a']++;
        }   // end of for

        boolean flag = false;
        String res = "";
        for(int i = 0; i < 26; i++) {
            if(counting[i] >= 5) {
                res += (char)(i + 'a');
            }
        }

        if(res.length() == 0) {
            res = "PREDAJA";
        }
        System.out.println(res);
    }
}