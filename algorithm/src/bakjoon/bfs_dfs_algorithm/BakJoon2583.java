package bakjoon.bfs_dfs_algorithm;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;
// 영역 구하기
public class BakJoon2583 {
    static int width;
    static int height;
    static int[][] area;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        area = new int[width][height];

        int rectangleNum = Integer.parseInt(st.nextToken());
        for (int i = 0; i < rectangleNum; i++) {
            st = new StringTokenizer(br.readLine());
            int upX = Integer.parseInt(st.nextToken());
            int upY = Integer.parseInt(st.nextToken());
            int downX = Integer.parseInt(st.nextToken());
            int downY = Integer.parseInt(st.nextToken());


            for (int h = upY; h < downY; h++) {
                for (int w = upX; w < downX; w++) {
                    area[w][h] = 1;
                }
            }
        }

        int[] count = new int[100000];
        int index = 0;
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                if (area[w][h] == 0) {
                    count[index] = dfs(w, h);
                    index++;
                }
            }
        }
        ans = new int[index];
        int[] array = new int[index];
        for (int i = 0; i < index; i++) {
            array[i] = count[i];
        }

        mergeSort(array, 0, index - 1);

        bw.write(index + "\n");
        for (int i = 0; i < index; i++) {
            bw.write(array[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int dfs(int x, int y) {
        Stack<PointXY> stack = new Stack<>();
        int count = 1;
        stack.push(new PointXY(x, y));
        area[x][y] = 1;

        while (!stack.isEmpty()) {
            PointXY check = stack.pop();
            for (int i = 0; i < 4; i++) {
                int nx = check.x + dx[i];
                int ny = check.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= width || ny >= height) continue;

                if (area[nx][ny] == 0) {
                    stack.push(new PointXY(nx, ny));
                    area[nx][ny] = 1;
                    count++;
                }
            }
        }
        return count;
    }

    static class PointXY {
        int x;
        int y;

        PointXY(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void mergeSort(int arr[], int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(arr, start, middle);
            mergeSort(arr, middle + 1, end);
            merge(arr, start, middle, end);
        }
    }

    static void merge(int arr[], int start, int middle, int end) {
        int i = start;
        int j = middle + 1;
        int k = start;

        while (i <= middle && j <= end) {
            if (arr[i] <= arr[j]) {
                ans[k] = arr[i];
                i++;
            } else {
                ans[k] = arr[j];
                j++;
            }
            k++;
        }
        if (i > middle) {
            while (k <= end) {
                ans[k] = arr[j];
                j++;
                k++;
            }
        } else {
            while (k <= end) {
                ans[k] = arr[i];
                i++;
                k++;
            }
        }
        for (int t = start; t <= end; t++) {
            arr[t] = ans[t];
        }
    }
}
