package ch6.sol2;

public class LinkedStackExample {
    public static void main(String[] args){
        int checkResult;
        int count;
        char checkPoint[][] = {
                {'(', 'A', '+', 'B', ')', '*', 'C'},
                {'{', '(', 'A', '+', 'B', ')', '*', 'C', '}', '*', 'D'},
                {'(', 'A', '+', 'B', ')', '*', 'C', ')'},
                {'(', '(', 'A', '+', 'B', ')', '*', 'C'},
                {'{','(','A', '+', 'B', '}', ')', '*', 'C', '*', 'D'}
        };
        count = checkPoint.length;
        for(int i=0;i<count;i++){
            checkResult = checkBracketMatching(checkPoint[i]);
            if(checkResult == 0){
                System.out.print("SUCCESS, ");
                System.out.println(checkPoint[i]);
            }
            else{
                System.out.print("FAIL-" + checkResult + ", ");
                System.out.println(checkPoint[i]);
            }
        }
    }
    static int checkBracketMatching(char[] check){
        if(check == null){ // 비어있을경우
            return -1;
        }

        LinkedStack stack = new LinkedStack();
        int Count = 0;
        int length = check.length;
        for(int i=0;i<length;i++){
            if(check[i] == '(' || check[i] == '{' || check[i] == '['){
                stack.pushLinkedStack(check[i]);
                Count++;
            }

            if(check[i] == ')' || check[i] == '}' || check[i] == ']'){
                Count--;
                // 여는 괄호 부족
                if(Count < 0){
                    return 1;
                }
                char checkAnswer = stack.popLinkedStack().getData();
                // 괄호쌍 검사
                if(check[i] == ')'){
                    if(checkAnswer != '(') {
                        return 2;
                    }
                }
                else if(check[i] == '}'){
                    if(checkAnswer != '{') {
                        return 2;
                    }
                }
                else if(check[i] == ']'){
                    if(checkAnswer != '['){
                        return 2;
                    }
                }
                // 여기 까지~
            }
        }
        // 닫는 괄호 부족
        if(Count > 0){
            return 3;
        }

        // success
        return 0;

    }
}

