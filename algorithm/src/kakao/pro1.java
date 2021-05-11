package kakao;

import java.util.LinkedList;
import java.util.Queue;

public class pro1 {
    public static void main(String[] args) {
        String input = "one4seveneight";
        System.out.println(solution(input));
    }

    static int solution(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                queue.add(s.charAt(i));
            } else {
                String sb = "";
                while (true) {
                    sb = sb + s.charAt(i);
                    if (sb.equals("zero")) {
                        queue.add('0');
                        break;
                    } else if (sb.equals("one")) {
                        queue.add('1');
                        break;
                    } else if (sb.equals("two")) {
                        queue.add('2');
                        break;
                    } else if (sb.equals("three")) {
                        queue.add('3');
                        break;
                    } else if (sb.equals("four")) {
                        queue.add('4');
                        break;
                    } else if (sb.equals("five")) {
                        queue.add('5');
                        break;
                    } else if (sb.equals("six")) {
                        queue.add('6');
                        break;
                    } else if (sb.equals("seven")) {
                        queue.add('7');
                        break;
                    } else if (sb.equals("eight")) {
                        queue.add('8');
                        break;
                    } else if (sb.equals("nine")) {
                        queue.add('9');break;
                    }
                    if (i + 1 < s.length() && (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9')) {
                        break;
                    }
                    i++;
                }
            }
        }
        String sb = "";
        while (!queue.isEmpty()) {
            sb = sb + queue.poll();
        }
        int ans = Integer.parseInt(sb);

        return ans;
    }
}
