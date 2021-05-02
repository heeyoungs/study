package bakjoon.sortalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 듣보잡
public class BakJoon1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        TreeSet<String> treeSet = new TreeSet<>();
        TreeSet<String> ans = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            treeSet.add(input);
        }
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (treeSet.contains(input)){
                ans.add(input);
            }
        }
        System.out.println(ans.size());
        ans.forEach(System.out::println);
        br.close();
    }
}
