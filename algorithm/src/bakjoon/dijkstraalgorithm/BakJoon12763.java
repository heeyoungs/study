package bakjoon.dijkstraalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 지각하면 안돼
public class BakJoon12763 {
    static int[][] dp = new int[101][10001]; // 건물위치와 사용한 시간을 인덱스로 가지자
    static boolean[][] visit = new boolean[101][10001];
    static int nodeCount, haveTime, haveMoney;
    static ArrayList<Point>[] list;

    static class Point implements Comparable<Point> {
        int point;
        int time;
        int cost;

        Point(int point, int time, int cost) {
            this.point = point;
            this.time = time;
            this.cost = cost;
        }


        @Override
        public int compareTo(Point o) {
            return cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nodeCount = Integer.parseInt(br.readLine());
        list = new ArrayList[nodeCount + 1];
        for(int i=0;i<101;i++){
            for(int j=0;j<10001;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[1][0] = 0;
        for (int i = 1; i <= nodeCount; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        haveTime = Integer.parseInt(st.nextToken());
        haveMoney = Integer.parseInt(st.nextToken());
        int lineCount = Integer.parseInt(br.readLine());
        for (int i = 1; i <= lineCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt((st.nextToken()));
            list[a].add(new Point(b,time,cost));
            list[b].add(new Point(a,time,cost));
        }
        dijkstra();
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=haveTime;i++){
            min = Math.min(dp[nodeCount][i],min);
        }
        if (min == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(min);
        }
    }
    static void dijkstra(){
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(1,0,0));
        while(!queue.isEmpty()){
            Point check = queue.poll();
            if (!visit[check.point][check.time]){
                visit[check.point][check.time] = true;
                for(Point ck : list[check.point]){
                    if (ck.time + check.time > haveTime) continue;
                    if (ck.cost + check.cost > haveMoney) continue;
                    if (dp[ck.point][check.time + ck.time] > dp[check.point][check.time] + ck.cost ){
                        dp[ck.point][check.time + ck.time] = dp[check.point][check.time] + ck.cost;
                        queue.add(new Point(ck.point,check.time + ck.time,dp[ck.point][check.time + ck.time]));
                    }
                }
            }
        }
    }
}
