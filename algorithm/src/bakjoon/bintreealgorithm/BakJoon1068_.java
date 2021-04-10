package bakjoon.bintreealgorithm;

import java.io.*;
import java.util.Arrays;

public class BakJoon1068_ {
    static int[] d = new int[51];

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodeCount = Integer.parseInt(br.readLine()); // 첫 째 줄 입력

        String[] input = br.readLine().split(" "); // 둘 째 줄 입력
        int[] array = new int[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        int delete = Integer.parseInt(br.readLine()); // 셋 째 줄 입력
        if (delete == 0){
            System.out.println(0);
            return;
        } // 루트 노드를 제거할 때

        int[][] childToParent = new int[nodeCount][2];
        for(int i = 0;i<nodeCount;i++){ // 0 -> index번호, 1 -> 부모노드
            childToParent[i][0] = i;
            childToParent[i][1] = array[i];
        }

        // 지워야되는 노드들 지우기
        int index = 0;
        d[index] = delete;
        for(int i=0;i<nodeCount;i++){
            for(int j=0;j<=index;j++){
                if (childToParent[i][0] == d[j]){
                    childToParent[i][0] = -1; // 초기화
                    childToParent[i][1] = -1;
                } else if (childToParent[i][1] == d[j]){
                    index++;
                    d[index] = childToParent[i][0];
                    childToParent[i][0] = -1; // 초기화
                    childToParent[i][1] = -1;
                }
            }
        }

        for(int i=0;i<nodeCount;i++){
            System.out.println(childToParent[i][0] + " " + childToParent[i][1]);
        }

        //리프 노드 찾기
        int count = nodeCount;
        for(int i=0;i<nodeCount;i++){
            for(int j=0;j<nodeCount;j++){
                if(childToParent[i][0] == childToParent[j][1]){
                    count--;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Main {
//
//    public static void delete(int[] tree, int del) {
//        tree[del] = -2; //지울 인덱스의 값을 -2로 변경한다.
//        for(int i=0; i<tree.length; i++) { //트리 배열을 탐색하며
//            if(tree[i] == del) //지울 인덱스를 부모로 가지는 노드가 있다면
//                delete(tree, i); //그 노드의 인덱스를 delete 함수로 넘긴다.
//        }
//    }
//
//    public static void main(String[] args) throws NumberFormatException, IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine()); //노드 개수 입력받음
//        int[] tree = new int[n];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for(int i=0; i<n; i++)
//            tree[i] = Integer.parseInt(st.nextToken()); //트리의 노드들 입력받아 tree배열에 저장
//        int del = Integer.parseInt(br.readLine()); //지울 노드번호 입력받음
//
//        delete(tree, del); //delete함수 호출(dfs - del인덱스의 자식노드들까지 연쇄적으로 삭제)
//
//        int count = 0;
//        for(int i=0; i<tree.length; i++) { //트리배열 탐색
//            boolean isBreak = false;
//            if(tree[i] != -2) { //만약 삭제되지 않은 노드라면
//
//                for(int j=0; j<tree.length; j++) { //트리 전체를 다시 확인하면서
//                    if(tree[j] == i) { //삭제되지 않은 노드를 부모로 둔 노드가 있다면
//                        isBreak = true; //리프 노드가 아니므로 isBreak 체크 후 break
//                        break;
//                    }
//                }
//
//                if(!isBreak) //isBreak가 false라면 삭제되지 않은 노드가 리프노드이므로 count 1증가
//                    count++;
//            }
//        }
//        //System.out.println(Arrays.toString(tree));
//        System.out.println(count);
//    }
//}