import java.util.ArrayList;
import java.util.Collections;

public class KruskalAlgorithm {
    public static void main(String[] args) {
        int n = 7;
        int m = 11;
        ArrayList<Edge> arrayList = new ArrayList<>();
        arrayList.add(new Edge(1, 7, 12));
        arrayList.add(new Edge(1, 4, 28));
        arrayList.add(new Edge(1, 2, 67));
        arrayList.add(new Edge(1, 5, 17));
        arrayList.add(new Edge(2, 4, 24));
        arrayList.add(new Edge(2, 5, 62));
        arrayList.add(new Edge(3, 5, 20));
        arrayList.add(new Edge(3, 6, 37));
        arrayList.add(new Edge(4, 7, 13));
        arrayList.add(new Edge(5, 6, 45));
        arrayList.add(new Edge(5, 7, 73));

        // 간선의 비용을 기준으로 오름차순 정렬
        Collections.sort(arrayList);

        // 각 정점이 포함된 그래프가 어디인지 저장
        int[] parent = new int[7];
        for (int i = 0; i < 7; i++) {
            parent[i] = i;
        }

        int sum = 0; // 거리의 합
        for (int i = 0; i < arrayList.size(); i++) {
            // 사이클이 발생하지 않는경우 그래프에 포함
            if (!findParent(parent, arrayList.get(i).node[0] - 1, arrayList.get(i).node[1] - 1)) {
                sum = sum + arrayList.get(i).distance;
                unionParent(parent, arrayList.get(i).node[0] - 1, arrayList.get(i).node[1] - 1);
            }
        }

        System.out.println(sum);
    }

    // 부모 노드를 찾는 함수
    static int getParent(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }

    // 두 부모 노드를 합치는 함수
    static int unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
        return 0;
    }

    // 같은 부모를 가지는지 확인
    static boolean findParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if (a == b) return true;
        else return false;
    }

    // 간선 정보 저장 클래스
    static class Edge implements Comparable<Edge> {
        public int node[] = new int[2];
        public int distance;

        public Edge(int a, int b, int distance) {
            this.node[0] = a;
            this.node[1] = b;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            if (distance > o.distance) {
                return 1;
            } else if (distance < o.distance) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
