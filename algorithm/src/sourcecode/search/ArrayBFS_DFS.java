package sourcecode.search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ArrayBFS_DFS {
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) { // 간선의 정보로만 포현된 탐색
        arr = new int[5][5];

        arr[1][2] = 1;
        arr[1][3] = 1;
        arr[1][4] = 1;
        arr[2][4] = 1;
        arr[3][4] = 1;

        visited = new boolean[5];
        dfs(1);

        System.out.println();

        visited = new boolean[5];
        bfs(1);
    }

    static void dfsR(int start) {
        visited[start] = true;
        System.out.print(start + " ");

        if (start == arr.length) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[start][i] == 1 && visited[i] == false) {
                dfsR(i);
            }
        }
    }

    static void dfs(int start){
        Stack<Integer> stack = new Stack<>();

        stack.push(start);
        visited[start] = true;

        while(!stack.isEmpty()){
            int check = stack.pop();
            for (int i =1;i<arr.length;i++){
                if (arr[check][i] == 1 && visited[i] == false){
                    visited[i] = true;
                    stack.push(i);
                }
            }
            System.out.print(check + " ");
        }

    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int check = queue.poll();
            for (int i = 1; i < arr.length; i++) {
                if (arr[check][i] == 1 && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
            System.out.print(check + " ");
        }
    }
}
