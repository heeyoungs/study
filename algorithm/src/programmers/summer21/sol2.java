package programmers.summer21;

public class sol2 {
    public static void main(String[] args) {
        long[] numbers = {2, 7};
        System.out.println(solution(numbers));
    }
    static public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long nowNum = numbers[i];
            long nextNum;
            String num1 = "0" + Long.toBinaryString(nowNum);
            int lastIndex = num1.length() - 1;
            int count = 0;
            while(true){
                if (num1.charAt(lastIndex) == '1'){
                    count++;
                    lastIndex--;
                }else{
                    break;
                }
            }
            if (count < 2){
                nextNum = nowNum + 1;
            }else{
                nextNum = (long) (nowNum + Math.pow(2,count-1));
            }
            answer[i] = nextNum;
            System.out.println(answer[i]);
        }
        return answer;
    }
}
