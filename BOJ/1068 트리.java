import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> tree;
    static int N, root, rem, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tree = new ArrayList<>();

        for(int i = 0; i < 54; i++) {
            tree.add(new ArrayList<>());
        }

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(x == -1) {
                root = i;
                continue;
            }
            tree.get(x).add(i);
        }   // end of for N

        rem = Integer.parseInt(br.readLine());

        if(rem == root) {
            System.out.println(0);
        } else {
            System.out.println(dfs(root));
        }
    }

    private static int dfs(int x) {
        int ret = 0;
        int child = 0;

        for(int i = 0; i< tree.get(x).size(); i++) {
            if(tree.get(x).get(i) == rem) continue;
            ret += dfs(tree.get(x).get(i));
            child++;
        }
        if(child == 0) return 1;
        return ret;
    }
}