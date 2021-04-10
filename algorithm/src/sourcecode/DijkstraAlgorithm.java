package sourcecode;

public class DijkstraAlgorithm {
    static int number = 6;
    static int INF = 1000000000;
    static int[][] a = { // 노드간의 거리 정보
            {0, 2, 5, 1, INF, INF},
            {2, 0, 3, 2, INF, INF},
            {5, 3, 0, 3, 1, 5},
            {1, 2, 3, 0, 1, INF},
            {INF, INF, 1, 1, 0, 2},
            {INF, INF, 5, INF, 2, 0}
    };

    static boolean[] v = new boolean[6]; // 방문 여부
    static int[] d = new int[6]; // 최단 거리

    public static void main(String[] args) {
        dijkstra(0);
        for(int i=0;i<number;i++){
            System.out.println(d[i]);
        }
    }

    public static int getSmallIndex(){
        int min = INF;
        int index = 0;
        for(int i=0;i<number;i++){
            if(d[i] < min && !v[i]){
                min = d[i];
                index = i;
            }
        }
        return index;
    }

    public static void dijkstra(int start){
        for(int i=0;i<number;i++){
            d[i] = a[start][i];
        }
        v[start] = true;
        for(int i=0;i<number-2;i++){
            int current = getSmallIndex();
            v[current] = true;
            for(int j=0;j<6;j++){
                if(!v[j]){
                    if(d[current] + a[current][j] < d[j]){
                        d[j] = d[current] + a[current][j];
                    }
                }
            }

        }
    }
    // -> 선형 탐색 O(N^2)
}
