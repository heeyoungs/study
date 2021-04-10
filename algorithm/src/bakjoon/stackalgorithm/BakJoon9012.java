package bakjoon.stackalgorithm;

import java.io.*;
import java.util.Stack;

public class BakJoon9012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int inputNum = Integer.parseInt(br.readLine());

        for(int i=0;i<inputNum;i++){
            String line = br.readLine();
            checkVPS(line);
        }
        bw.flush();bw.close();br.close();
    }
    public static void checkVPS(String line) throws IOException {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<line.length();i++){
            if(line.charAt(i) == '('){
                stack.push('(');
                continue;
            }
            if(line.charAt(i) == ')'){
                if(stack.isEmpty()){
                    bw.write("NO\n" );
                    return;
                }

                char check = stack.pop();
                if(check == '('){
                    continue;
                }
            }
        }

        if(!stack.isEmpty()){
            bw.write("NO\n");
            return;
        }
        bw.write("YES\n");
    }
}
