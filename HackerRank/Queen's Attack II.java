import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
    static Map<Integer, Integer> obstacleMap;
    static int[] limit;
    
    
    static boolean mapCheck(int r, int c, int n) {
        return r >= 1 && r <= n && c >= 1 && c <= n;   
    }
    
    static void setLimit(int r_q, int c_q, List<List<Integer>> obstacles, int n) {
        limit[0] = r_q - 1;
        limit[1] = n - r_q;
        limit[2] = c_q - 1;
        limit[3] = n - c_q;
        limit[4] = Math.min(limit[0], limit[2]);
        limit[5] = Math.min(limit[0], limit[3]);
        limit[6] = Math.min(limit[1], limit[2]);
        limit[7] = Math.min(limit[1], limit[3]);
        
        for(List<Integer> obstacle : obstacles) {
            int r = obstacle.get(0);
            int c = obstacle.get(1);
            
            if(r == r_q) {
                if(c > c_q) {
                    limit[3] = Math.min(limit[3], c - c_q - 1);
                } else {
                    limit[2] = Math.min(limit[2], c_q - c - 1);
                }
            } else if(c == c_q) {
                if(r > r_q) {
                    limit[1] = Math.min(limit[1], r - r_q - 1);
                } else {
                    limit[0] = Math.min(limit[0], r_q - r - 1);
                }
            } else if(Math.abs(r - r_q) == Math.abs(c - c_q)) {
                if(r > r_q && c > c_q) {
                    limit[7] = Math.min(limit[7], r - r_q - 1);
                } else if(r > r_q && c < c_q) {
                    limit[6] = Math.min(limit[6], r - r_q - 1);
                } else if(r < r_q && c > c_q) {
                    limit[5] = Math.min(limit[5], r_q - r - 1);
                } else if(r < r_q && c < c_q) {
                    limit[4] = Math.min(limit[4], r_q - r - 1);
                }
            }
        }   // end of for
        
        int res = 0;
    }

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        limit = new int[8];
        setLimit(r_q, c_q, obstacles, n);
        
        int res = 0;
        for(int i = 0; i < 8; i++) {
            res += limit[i];
        }
        
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                obstacles.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
