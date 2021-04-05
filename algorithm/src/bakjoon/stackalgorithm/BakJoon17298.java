package bakjoon.stackalgorithm;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class BakJoon17298 { // 내림차순으로 쑤셔박기!
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<ItemToIndex> stack = new Stack<>();

        int inputNum = sc.nextInt();
        int[] array = new int[inputNum];
        for(int i=0;i<inputNum;i++){
            array[i] = -1;
        }

        for(int i=0;i<inputNum;i++){
            int input = sc.nextInt();
            if(stack.isEmpty()){
                stack.push(new ItemToIndex(input,i));
                continue;
            }

            if(stack.peek().item > input){
                stack.push(new ItemToIndex(input,i));
                continue;
            } else {
                while(!stack.isEmpty() && stack.peek().item < input){
                    ItemToIndex kkk = stack.pop();
                    array[kkk.index] = input;
                }
                stack.push(new ItemToIndex(input,i));
            }
        }
        for(int i=0;i<inputNum;i++){
            bw.write(array[i] + " ");
        }
        bw.flush();bw.close();
    }
    public static class ItemToIndex{
        int item;
        int index;
        ItemToIndex(int item,int index){
            this.item = item;
            this.index = index;
        }
    }
}



//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int inputNum = Integer.parseInt(br.readLine());
//
//        String[] array = br.readLine().split(" ");
//
//        for(int i=0;i<inputNum -1;i++){
//            for(int j=i+1;j<inputNum;j++){
//                if(Integer.parseInt(array[j]) > Integer.parseInt(array[i])){
//                    bw.write(array[j] + " ");
//                    break;
//                }
//                if(j == inputNum-1) {
//                    bw.write(-1 + " ");
//                    break;
//                }
//            }
//        }
//        bw.write(-1 + " ");
//        bw.flush();bw.close();br.close();
//    }
//}
