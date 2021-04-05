package bakjoon.queuealgorithm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BakJoon14943 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long ans = 0;
        int inputNum = sc.nextInt();
        Deque<Burook> queue = new LinkedList<>();

        for (int i = 0; i < inputNum; i++) {
            int inputBurook = sc.nextInt();
            if (queue.isEmpty()) { // 큐가 비어있는 경우 -> 그냥 넣어
                queue.add(new Burook(inputBurook, i));
                continue;
            } else if (queue.peek().Burook > 0 && inputBurook > 0) {
                queue.add(new Burook(inputBurook, i)); // 큐가 양수, 인풋이 양수 -> 그냥 넣어
                continue;
            } else if (queue.peek().Burook < 0 && inputBurook < 0) {
                queue.add(new Burook(inputBurook, i)); // 큐가 음수, 인풋이 음수 -> 그냥 넣어
                continue;
            } else if (queue.peek().Burook > 0 && inputBurook < 0) { // 큐는 양수 큐, 인풋이 음수 -> 꺼내서 비교하고 ans에 추가
                while (!queue.isEmpty() && inputBurook != 0) {
                    Burook check = queue.poll();
                    int checkBurook = check.Burook;
                    int checkindex = check.index;
                    if (checkBurook + inputBurook > 0) {
                        ans = ans + (-inputBurook) * (i - checkindex);
                        queue.addFirst(new Burook(checkBurook + inputBurook, checkindex));
                        inputBurook = 0;
                        break;
                    } else if (checkBurook == -inputBurook) {
                        ans = ans + checkBurook * (i - checkindex);
                        inputBurook = 0;
                        break;
                    } else {
                        ans = ans + (checkBurook) * (i - checkindex);
                        inputBurook = inputBurook + checkBurook;
                    }
                }
                if (inputBurook < 0) {
                    queue.add(new Burook(inputBurook, i));
                }
            } else if (queue.peek().Burook < 0 && inputBurook > 0) { // 큐는 음수 큐, 인풋이 양수 -> 꺼내서 비교하고 ans에 추가
                while (!queue.isEmpty() && inputBurook != 0) {
                    Burook check = queue.poll();
                    int checkBurook = check.Burook;
                    int checkindex = check.index;

                    if (checkBurook + inputBurook < 0) {
                        ans = ans + (inputBurook) * (i - checkindex);
                        queue.addFirst(new Burook(checkBurook + inputBurook, checkindex));
                        inputBurook = 0;
                        break;

                    } else if (checkBurook == -inputBurook) {
                        ans = ans + inputBurook * (i - checkindex);
                        inputBurook = 0;
                        break;

                    } else {
                        ans = ans + (-checkBurook) * (i - checkindex);
                        inputBurook = inputBurook + checkBurook;
                    }
                }
                if (inputBurook > 0) {
                    queue.add(new Burook(inputBurook, i));
                }
            }
        }
        System.out.println(ans);

    }

    static class Burook {
        int Burook;
        int index;

        Burook(int Burook, int index) {
            this.Burook = Burook;
            this.index = index;
        }
    }
}
