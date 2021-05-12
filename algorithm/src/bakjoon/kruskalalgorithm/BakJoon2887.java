package bakjoon.kruskalalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 행성 터널
public class BakJoon2887 {
    static int[] parent;

    static int getParent(int x) {
        if (parent[x] == x) return x;
        return parent[x] = getParent(parent[x]);
    }

    static void unionParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a > b) parent[a] = b;
        else parent[b] = a;
    }

    static boolean findParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a == b) return true;
        else return false;
    }

    static class XYZ {
        int planetNum;
        int x;
        int y;
        int z;

        XYZ(int planetNum, int x, int y, int z) {
            this.planetNum = planetNum;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class ABW implements Comparable<ABW> {
        int a;
        int b;
        int weight;

        ABW(int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }

        @Override
        public int compareTo(ABW o) {
            return weight - o.weight;
        }
    }

    static int getDist(int ax, int ay, int az, int bx, int by, int bz) {
        return Math.min(Math.abs(ax - bx), Math.min(Math.abs(ay - by), Math.abs(az - bz)));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        XYZ[] xyz = new XYZ[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            xyz[i] = new XYZ(i + 1, x, y, z);
        }

        // x정렬
        PriorityQueue<ABW> queue = new PriorityQueue<>();
        Arrays.sort(xyz, new Comparator<XYZ>() {
            @Override
            public int compare(XYZ o1, XYZ o2) {
                return o1.x - o2.x;
            }
        });
        for (int i = 0; i < N - 1; i++) {
            queue.add(new ABW(xyz[i].planetNum, xyz[i + 1].planetNum, Math.abs(xyz[i].x - xyz[i + 1].x)));
        }
        // y정렬
        Arrays.sort(xyz, new Comparator<XYZ>() {
            @Override
            public int compare(XYZ o1, XYZ o2) {
                return o1.y - o2.y;
            }
        });
        for (int i = 0; i < N - 1; i++) {
            queue.add(new ABW(xyz[i].planetNum, xyz[i + 1].planetNum, Math.abs(xyz[i].y - xyz[i + 1].y)));
        }
        // z정렬
        Arrays.sort(xyz, new Comparator<XYZ>() {
            @Override
            public int compare(XYZ o1, XYZ o2) {
                return o1.z - o2.z;
            }
        });
        for (int i = 0; i < N - 1; i++) {
            queue.add(new ABW(xyz[i].planetNum, xyz[i + 1].planetNum, Math.abs(xyz[i].z - xyz[i + 1].z)));
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            ABW check = queue.poll();
            int a = check.a;
            int b = check.b;
            int weight = check.weight;
            if (!findParent(a, b)) {
                unionParent(a, b);
                ans += weight;
            }
        }
        System.out.println(ans);
    }
}
