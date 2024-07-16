import java.io.*;
import java.util.*;

public class Main {
    static int[] visited;
    static String message, key, res = "";
    static char[][] a;

    static String get_key(String s) {
        String dis_key = "";

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(visited[c - 'A'] != 0) continue;
            visited[c - 'A'] = 1;
            dis_key += c;
        }

        return dis_key;
    }

    static String get_message(String s) {
        String message = "";

        for(int i = 0; i < s.length();) {
            if(i != s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                message += s.charAt(i);
                if(s.charAt(i) == 'X') message += 'Q';
                else message += 'X';
                i++;
            } else if(i == s.length() - 1) {
                message += s.charAt(i++);
            } else {
                message += s.charAt(i);
                message += s.charAt(i + 1);
                i += 2;
            }
        }   // end of for s
        return message;
    }

    static int[] get_pos(char c) {
        int[] p = new int[2];

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(a[i][j] == c) {
                    p = new int[]{i, j};
                    break;
                }
            }
        }
        return p;
    }

    static String get_res(int[] apos, int[] bpos) {
        String s = "";

        if(apos[0] == bpos[0]) {
            s += a[apos[0]][(apos[1] + 1) % 5];
            s += a[apos[0]][(bpos[1] + 1) % 5];
        } else if(apos[1] == bpos[1]) {
            s += a[(apos[0] + 1) % 5][apos[1]];
            s += a[(bpos[0] + 1) % 5][bpos[1]];
        } else {
            s += a[apos[0]][bpos[1]];
            s += a[bpos[0]][apos[1]];
        }

        return s;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        message = br.readLine();
        key = br.readLine();

        visited = new int[30];
        a = new char[7][7];

        String dis_key = get_key(key);

        for(int i = 0, idx = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(idx == dis_key.length()) break;
                a[i][j] = dis_key.charAt(idx++);
            }   // end of for j
            if(idx == dis_key.length()) break;
        }   // end of for i

        char c = 'A';
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(a[i][j] != 0) continue;
                for(; c <= 'Z'; c++) {
                    if(visited[c - 'A'] != 0) continue;
                    if(c == 'J') continue;
                    a[i][j] = c;
                    visited[c - 'A'] = 1;
                    break;
                }   // end of for c
            }   // end of for j
        }   // end of for i

        String dis_message = get_message(message);

        if(dis_message.length() % 2 != 0) dis_message += 'X';

        for(int i = 0; i < dis_message.length(); i+=2) {
            char a = dis_message.charAt(i);
            char b = dis_message.charAt(i + 1);

            int[] apos = get_pos(a);
            int[] bpos = get_pos(b);

            res += get_res(apos, bpos);
        }   // end of for dis_message

        System.out.println(res);
    }
}
