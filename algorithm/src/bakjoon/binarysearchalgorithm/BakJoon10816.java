package bakjoon.binarysearchalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 숫자 카드 2
public class BakJoon10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 1 - line
        int N = Integer.parseInt(br.readLine());
        // 2 - line
        int[] card = new int[N];
        array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(card, 0, N - 1);
        // 3 - line
        int M = Integer.parseInt(br.readLine());
        // 4 - line
        int[] findNum = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int find = Integer.parseInt(st.nextToken());
            // code
            int count = 0;
            int lowPoint = 0;
            int highPoint = N - 1;
            while (lowPoint <= highPoint) {
                int midPoint = (lowPoint + highPoint) / 2;

                //System.out.println(midPoint);
                if (card[midPoint] == find) {
                    count++;
                    int up = midPoint + 1;
                    int down = midPoint - 1;
                    while (true) {
                        if (up >= N || card[up] != find) {
                            break;
                        }
                        up++;
                        count++;
                    }
                    while (true) {
                        if (down < 0 || card[down] != find) {
                            break;
                        }
                        down--;
                        count++;
                    }
                    break;
                } else if (card[midPoint] > find) {
                    highPoint = midPoint - 1;
                } else if (card[midPoint] < find) {
                    lowPoint = midPoint + 1;
                }
            }
            sb.append(count + " ");
        }
        System.out.println(sb);
    }

    static int[] array;

    static void merge(int[] data, int m, int middle, int n) {
        int i = m;
        int j = middle + 1;
        int k = m;
        // 작은 순서대로 배열에 삽입
        while (i <= middle && j <= n) {
            if (data[i] <= data[j]) {
                array[k] = data[i];
                i++;
            } else {
                array[k] = data[j];
                j++;
            }
            k++;
        }
        // 남은 데이터
        if (i > middle) {
            for (int t = j; t <= n; t++) {
                array[k] = data[t];
                k++;
            }
        } else {
            for (int t = i; t <= middle; t++) {
                array[k] = data[t];
                k++;
            }
        }
        // 전역 배열에 잇는 것을 합치기 -> 전역 배열의 m~n은 정렬된 상태
        for (int t = m; t <= n; t++) {
            data[t] = array[t];
        }
    }

    static void mergeSort(int[] data, int m, int n) {
        if (m < n) {
            int middle = (m + n) / 2;
            mergeSort(data, m, middle);
            mergeSort(data, middle + 1, n);
            merge(data, m, middle, n);
        }
    }
}

//해쉬 맵을 사용한 풀이
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.StringTokenizer;
//
//public class BakJoon {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        HashMap<Integer,Integer> map = new HashMap<>();
//        // 1 - line
//        int N = Integer.parseInt(br.readLine());
//        // 2 - line
//        int[] card = new int[N];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < N; i++) {
//            card[i] = Integer.parseInt(st.nextToken());
//            if (!map.containsKey(card[i])){
//                map.put(card[i],1);
//            }else{
//                map.put(card[i],map.get(card[i]) + 1);
//            }
//        }
//        // 3 - line
//        int M = Integer.parseInt(br.readLine());
//        // 4 - line
//        int[] findNum = new int[M];
//        st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < M; i++) {
//            int find = Integer.parseInt(st.nextToken());
//            if (map.containsKey(find)){
//                sb.append(map.get(find)).append(" ");
//            }else{
//                sb.append("0 ");
//            }
//        }
//        System.out.println(sb);
//    }
//}