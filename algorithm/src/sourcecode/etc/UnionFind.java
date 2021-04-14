package sourcecode.etc;

public class UnionFind {
    public static void main(String[] args) {
        int[] parent = new int[11];
        for(int i=0;i<=10;i++){
            parent[i] = i;
        }
        unionParent(parent,1,2);
        unionParent(parent,2,3);
        unionParent(parent,3,4);
        unionParent(parent,5,6);
        unionParent(parent,6,7);
        unionParent(parent,7,8);

        System.out.println("1-5?: " + findParent(parent,1,5));

        unionParent(parent,1 ,6);

        System.out.println("1-5?: " + findParent(parent,1,5));

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
}
