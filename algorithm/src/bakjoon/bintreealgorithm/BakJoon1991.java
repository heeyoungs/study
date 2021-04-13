package bakjoon.bintreealgorithm;

import java.io.*;

public class BakJoon1991 {
    static Integer[][] alphaWithChild;
    static int nodeCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        nodeCount = Integer.parseInt(br.readLine());

        alphaWithChild = new Integer[nodeCount][2];

        for (int i = 0; i < nodeCount; i++) {
            String[] input = br.readLine().split(" ");
            int nodeNum = input[0].charAt(0) - 'A';

            if (input[1].charAt(0) != '.') {
                alphaWithChild[nodeNum][0] = input[1].charAt(0) - 'A';
            }
            if (input[2].charAt(0) != '.') {
                alphaWithChild[nodeNum][1] = input[2].charAt(0) - 'A';
            }
        }

        case1();
        System.out.println();
        case2();
        System.out.println();
        case3();
    }

    static void case1() { // 전위 순회
        recursive1(0);
    }

    static void recursive1(Integer index) {
        if (index == null){ return;}
        System.out.print((char) (index + 'A'));
        recursive1(alphaWithChild[index][0]);
        recursive1(alphaWithChild[index][1]);
    }

    static void case2() { // 중위
        recursive2(0);
    }

    static void recursive2(Integer index) {
        if (index == null){ return;}
        recursive2(alphaWithChild[index][0]);
        System.out.print((char) (index + 'A'));
        recursive2(alphaWithChild[index][1]);
    }

    static void case3() { // 후위
        recursive3(0);
    }

    static void recursive3(Integer index) {
        if (index == null){ return; }
        recursive3(alphaWithChild[index][0]);
        recursive3(alphaWithChild[index][1]);
        System.out.print((char) (index + 'A'));
    }
}
