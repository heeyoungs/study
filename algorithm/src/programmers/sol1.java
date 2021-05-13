package programmers;

public class sol1 {
    public static void main(String[] args) {
        System.out.println(solution(13, 17));
    }

    static public int solution(int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            int num = i;
            int count = 0;
            for (int j = 1; j <= num; j++) {
                if (num % j == 0) {
                    count++;
                }
            }
            if (count % 2 == 0) {
                ans += num;
            } else {
                ans -= num;
            }
        }
        return ans;
    }
}

