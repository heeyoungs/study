package bakjoon.simulationalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

// 게리맨더링
public class BakJoon17471 {
    static int N;
    static int[] personCount;
    static ArrayList<Integer>[] list;
    static boolean[] check;
    static boolean[] visit;
    static int Ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        personCount = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            personCount[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 1; j < input.length; j++) {
                int end = Integer.parseInt(input[j]);
                list[i].add(end);
            }
        }
        // 여기까지 입력
        check = new boolean[N + 1];
        combine(1, 0);
        if (Ans == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(Ans);
        }
    }

    static void combine(int at, int depth) {
        if (depth == N / 2 + 1) {
            return;
        }

//        for(int i=1;i<=N;i++){
//            if (check[i]){
//                System.out.print(i + " ");
//            }
//        }

        int areaCount = 0;
        // 지역 분리 개수 확인
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (check[i] && !visit[i]) {
                dfs1(i);
                areaCount++;
            }
            if (!check[i] && !visit[i]){
                dfs2(i);
                areaCount++;
            }
        }
//        System.out.println("area!" + areaCount);
        if (areaCount == 2){
            int areaA = 0;
            int areaB = 0;
            for(int i=1;i<=N;i++){
                if (check[i]){
                    areaA += personCount[i];
                }else {
                    areaB += personCount[i];
                }
            }
            Ans = Math.min(Ans,Math.abs(areaA-areaB));
        }


        // 분리 부분
        for (int i = at; i <= N; i++) {
            check[i] = true;
            combine(i + 1, depth + 1);
            check[i] = false;
        }
    }

    static void dfs1(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visit[start] = true;
        while(!stack.isEmpty()){
            int ck = stack.pop();
            for(int next : list[ck]){
                if (check[next] && !visit[next]){
                    visit[next] = true;
                    stack.push(next);
                }
            }
        }
    }

    static void dfs2(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visit[start] = true;
        while(!stack.isEmpty()){
            int ck = stack.pop();
            for(int next : list[ck]){
                if (!check[next] && !visit[next]){
                    visit[next] = true;
                    stack.push(next);
                }
            }
        }
    }
}
