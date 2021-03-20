package ch6.sol1;

public class LinkedStackExample {
    public static void main(String[] args){
        char[] abcd = {'A','B','C','D'};
        char[] answer = reverseString(abcd);
        System.out.print(abcd);
        System.out.print("->");
        System.out.println(reverseString(abcd));
    }

    static char[] reverseString(char[] abcd){
        if(abcd == null){
            System.out.println("비어있음!");
            return null;
        }
        LinkedStack stack = new LinkedStack();
        int Count = abcd.length;
        char answer[] = new char[Count];
        for(int i=0;i<Count;i++){ // 스택에 푸쉬
            stack.pushLinkedStack(abcd[i]);
        }
        for(int i=0;i<Count;i++){ // 스택에서 팝
            answer[i] = stack.popLinkedStack().getData();
        }
        stack.deleteLinkedStack();
        return answer;
    }
}
