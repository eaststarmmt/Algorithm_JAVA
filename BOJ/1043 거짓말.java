import java.io.*;
import java.util.*;
public class Main {
    static List<List<Integer>> party;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        parent = new int[51];
        party = new ArrayList<>();
        for(int i = 0; i < 51; i++) {
            party.add(new ArrayList<>());
        }

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int know = Integer.parseInt(st.nextToken());
        int sum = m;
        List<Integer> knowing = new ArrayList<>();

        for(int i = 0; i < know; i++) {
            int x = Integer.parseInt(st.nextToken());
            knowing.add(x);
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j = 0; j < num; j++) {
                int x = Integer.parseInt(st.nextToken());
                party.get(i).add(x);
            }   // end of for j
        }   // end of for i

        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }   // end of for

        for(int i = 0; i < m; i++) {
            for(int j = 1; j < party.get(i).size(); j++) {
                unionParent(party.get(i).get(0), party.get(i).get(j));
            }   // end of for party
        }   // end of for m


        for(int i = 0; i < m; i++) {
            for(int j = 0; j < knowing.size(); j++) {
                if (findParent(knowing.get(j)) == findParent(party.get(i).get(0))) {
                    sum--;
                    break;
                }
            }
        }
        System.out.println(sum);
    }

    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if(a > b) parent[a] = b;
        else parent[b] = a;
    }

    private static int findParent(int x) {
        if(x == parent[x]) return x;
        return findParent(parent[x]);
    }
}
