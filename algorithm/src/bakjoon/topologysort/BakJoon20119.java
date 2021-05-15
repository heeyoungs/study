package bakjoon.topologysort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 클레어와 물약
public class BakJoon20119 {
    static class Point {
        int pt;
        int recipeNum;

        Point(int pt, int recipeNum) {
            this.pt = pt;
            this.recipeNum = recipeNum;
        }

        @Override
        public boolean equals(Object obj) {
            Point check = (Point) obj;
            return (check.pt == pt) && (check.recipeNum == recipeNum);
        }

        @Override
        public int hashCode(){
            return pt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Point, Integer> inDegree = new HashMap<>();
        boolean[] ans = new boolean[N + 1];

        ArrayList<Point>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int R = Integer.parseInt(input[input.length - 1]);
            Point in = new Point(R,i);
            for (int j = 1; j < input.length - 1; j++) {
                int x = Integer.parseInt(input[j]);
                list[x].add(in);
                if (!inDegree.containsKey(in)) {
                    inDegree.put(in, 1);
                } else {
                    inDegree.put(in, inDegree.get(in) + 1);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int L = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            int x = Integer.parseInt(st.nextToken());
            queue.add(x);
            ans[x] = true;
        }
        //System.out.println(inDegree.get(new Point(2,0)));
        while (!queue.isEmpty()) {
            int check = queue.poll();

            for (Point next : list[check]) {
                if (ans[next.pt]) continue;
                //System.out.println(next.pt + " " + next.recipeNum);
                inDegree.put(new Point(next.pt,next.recipeNum),inDegree.get(new Point(next.pt,next.recipeNum)) - 1);
                if (inDegree.get(new Point(next.pt,next.recipeNum)) == 0) {
                    queue.add(next.pt);
                    ans[next.pt] = true;
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (ans[i]) count++;
        }
        System.out.println(count);
        for (int i = 1; i <= N; i++) {
            if (ans[i]) System.out.print(i + " ");
        }
    }
}
