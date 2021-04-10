package bakjoon.stackalgorithm;

import java.io.*;
import java.util.Stack;

public class BakJoon1406 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputLine = br.readLine();
        StringBuilder sb = new StringBuilder(inputLine);

        Stack<Character> stack = new Stack<>();

        int inputNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < inputNum; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("L")) { // 커서 왼쪽
                if(sb.length() != 0) {
                    stack.push(sb.charAt(sb.length() - 1));
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else if (input[0].equals("D")) { // 커서 오른쪽
                if (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            } else if (input[0].equals("B")) { // 커서 왼쪽 문자 삭제
                if(sb.length() != 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else if (input[0].equals("P")) { // 문자 추가
                char insert = input[1].charAt(0);
                sb.append(insert);
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        bw.write(sb +"");
        bw.flush();
        bw.close();
        br.close();
    }
}
