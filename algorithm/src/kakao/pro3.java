package kakao;

import java.util.Stack;
import java.util.StringTokenizer;

public class pro3 {
    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
        System.out.println(solution(n, k, cmd));
    }

    static StringBuilder solution(int n, int k, String[] cmd) {
        boolean[] isDelete = new boolean[n];
        Stack<Integer> deleteArray = new Stack<>();
        int nowIndex = k;
        int lastPoint = n - 1;

        for (int i = 0; i < cmd.length; i++) {
            //System.out.println(nowIndex);
            StringTokenizer st = new StringTokenizer(cmd[i]);
            String command = st.nextToken();
            // Up
            if (command.equals("U")) {
                int jump = Integer.parseInt(st.nextToken());
                for (int j = 0; j < jump; j++) {
                    while (true) {
                        nowIndex--;
                        if (!isDelete[nowIndex]) break;
                    }
                }
            }
            // Down
            else if (command.equals("D")) {
                int jump = Integer.parseInt(st.nextToken());
                for (int j = 0; j < jump; j++) {
                    while (true) {
                        nowIndex++;
                        if (!isDelete[nowIndex]) break;
                    }
                }
            }
            // Delete
            else if (command.equals("C")) { // 지우기
                if (nowIndex == lastPoint) { // 마지막 인덱스
                    deleteArray.push(nowIndex);
                    isDelete[nowIndex] = true;
                    nowIndex--;
                } else {
                    deleteArray.push(nowIndex);
                    isDelete[nowIndex] = true;
                    nowIndex++;
                }
                lastPoint = n - 1;
                while (true) { // 마지막 위치의 재설정
                    if (!isDelete[lastPoint]) break;
                    lastPoint--;
                }
            }
            // resurrection
            else if (command.equals("Z")) { // 살리기
                int resurrection = deleteArray.pop();
                if (resurrection >= lastPoint) {
                    lastPoint = resurrection;
                }
                isDelete[resurrection] = false;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (isDelete[i]) {
                sb.append("X");
            } else {
                sb.append("O");
            }
        }
        return sb;
    }
}
