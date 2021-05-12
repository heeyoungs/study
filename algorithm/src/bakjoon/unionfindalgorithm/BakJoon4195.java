package bakjoon.unionfindalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

// 친구 네트워크
public class BakJoon4195 {
    static int[] parent;
    static int[] friend;

    static int getParent(int x) {
        if (parent[x] == x) return x;
        return parent[x] = getParent(parent[x]);
    }

    static int unionParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a != b) {
            if (a > b) {
                parent[a] = b;
                friend[b] += friend[a];
                return friend[b];
            } else {
                parent[b] = a;
                friend[a] += friend[b];
                return friend[a];
            }
        }else{
            return friend[a];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {

            int N = Integer.parseInt(br.readLine());
            parent = new int[200001];
            friend = new int[200001];
            Arrays.fill(friend,1);
            HashMap<String, Integer> map = new HashMap<>();
            int personCount = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String personA = st.nextToken();
                String personB = st.nextToken();
                if (!map.containsKey(personA)) {
                    personCount++;
                    parent[personCount] = personCount;
                    map.put(personA, personCount);
                }
                if (!map.containsKey(personB)) {
                    personCount++;
                    parent[personCount] = personCount;
                    map.put(personB, personCount);
                }
                int count = unionParent(map.get(personA), map.get(personB));

                sb.append(count).append("\n");
            }
        }
        System.out.println(sb);
    }
}
