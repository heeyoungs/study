package bakjoon.bfs_dfs_algorithm;

import java.util.*;
// 숨바꼭질 4
public class BakJoon13913 {
    static int[] dx = {-1, 2, 1};
    static int[] array = new int[100001];
    static boolean[] visit = new boolean[100001];
    static int[] mem = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int startPoint = sc.nextInt();
        int endPoint = sc.nextInt();

        bfs(startPoint);
        System.out.println(array[endPoint]);
        Stack<Integer> stack = new Stack<>();
        while(endPoint != startPoint){
            stack.push(endPoint);
            endPoint = mem[endPoint];
        }
        System.out.print(startPoint + " ");
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }
    // 뒤로가기 우선!
    static void bfs(int start) {
        visit[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int check = queue.poll();
            for (int i = 0; i < 3; i++) {
                int nx;
                if (i == 1) {
                    nx = check * dx[i];
                } else {
                    nx = check + dx[i];
                }
                if (nx < 0 || nx > 100000) continue;

                if (!visit[nx]){
                    visit[nx] = true;
                    if (i==1){
                        array[nx] = array[check] + 1;
                        mem[nx] = check;
                    }else{
                        array[nx] = array[check] + 1;
                        mem[nx] = check;
                    }
                    queue.add(nx);
                }
            }
        }
    }
}
