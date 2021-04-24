package bakjoon.bfs_dfs_algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// 숨바꼭질
public class BakJoon1697 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int startPoint = sc.nextInt();
        int finalPoint = sc.nextInt();
        int[] arr = new int[100001]; // 공간 할당
        int[] force = {-1, 1}; // 방향 할당 -> 걷기
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startPoint);

        while (!queue.isEmpty()) {
            int check = queue.poll();
            int n2x = check * 2; // 2배 이동
            if (n2x >= 0 && n2x < 100001) {
                if (arr[n2x] == 0) {
                    arr[n2x] = arr[check] + 1;
                    queue.add(n2x);
                }
            }

            for (int i = 0; i < 2; i++) { // 1칸이동
                int nx = check + force[i];
                if (nx >= 0 && nx < 100001) {
                    if (arr[nx] == 0) {
                        arr[nx] = arr[check] + 1;
                        queue.add(nx);
                    }
                }
            }
        }

        if (startPoint == 0) { // 시작이 0일때
            System.out.println(arr[finalPoint] - 1);
        } else if (startPoint == finalPoint) { // 시작점과 끝점이 같을 때
            System.out.println(0);
        } else { // 나머지의 경우
            System.out.println(arr[finalPoint]);
        }
        sc.close();
    }
}
