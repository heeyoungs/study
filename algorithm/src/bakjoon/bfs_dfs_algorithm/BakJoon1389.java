package bakjoon.bfs_dfs_algorithm;

import java.io.*;
import java.util.*;
// 케빈 베이컨의 6단계 법칙
public class BakJoon1389 {
    static ArrayList<Integer>[] list;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int personNum = Integer.parseInt(st.nextToken());
        int lineNum = Integer.parseInt(st.nextToken());
        list = new ArrayList[personNum + 1];
        for (int i = 1; i <= personNum; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < lineNum; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            list[first].add(second);
            list[second].add(first);
        }
        Point[] array = new Point[personNum+1];
        array[0] = new Point(0,0);
        for (int i = 1; i <= personNum; i++) {
            visit = new boolean[personNum + 1];
            array[i] = new Point(bfs(i),i);
        }
        Arrays.sort(array, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.index > o2.index){
                    return 1;
                }else if (o1.index < o2.index){
                    return -1;
                }else{
                    if (o1.count > o2.count){
                        return 1;
                    }else{
                        return -1;
                    }
                }
            }
        });
        System.out.println(array[1].count);
    }

    static int bfs(int start) {
        int sum = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(start,0));
        visit[start] = true;
        while(!queue.isEmpty()){
            Point check = queue.poll();
            sum = sum + check.count;
            for(int node : list[check.index]){
                if (!visit[node]){
                    visit[node] = true;
                    queue.add(new Point(node,check.count+1));
                }
            }
        }
        return sum;
    }

    static class Point {
        int index;
        int count;

        Point(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
}
