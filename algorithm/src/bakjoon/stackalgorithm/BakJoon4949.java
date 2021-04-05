package bakjoon.stackalgorithm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class BakJoon4949 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String inputLine;
        String yesOrNo;
        while(true){
            inputLine = sc.nextLine();
            if(inputLine.equals(".")){
                break;
            } // 종료조건
            yesOrNo = checkYesOrNo(inputLine);
            bw.write(yesOrNo + "\n");
        }

        bw.flush();
        bw.close();
    }

    static String checkYesOrNo(String inputLine) {
        Stack<Character> check = new Stack<>();
        char checkPoint;
        for (int i = 0; i < inputLine.length(); i++) {
            switch (inputLine.charAt(i)) {
                case '(':
                case '{':
                case '[':
                    check.push(inputLine.charAt(i));
                    break;
                case ')':
                    if (check.isEmpty()) {
                        return "no";
                    } else {
                        checkPoint = check.pop();
                        if (checkPoint == '(') {
                            continue;
                        } else {
                            return "no";
                        }
                    }
                case '}':
                    if (check.isEmpty()) {
                        return "no";
                    } else {
                        checkPoint = check.pop();
                        if (checkPoint == '{') {
                            continue;
                        } else {
                            return "no";
                        }
                    }
                case ']':
                    if (check.isEmpty()) {
                        return "no";
                    } else {
                        checkPoint = check.pop();
                        if (checkPoint == '[') {
                            continue;
                        } else {
                            return "no";
                        }
                    }
            }
        }
        if(!check.isEmpty()){
            return "no";
        } else {
            return "yes";
        }
    }
}
