package ch6.sol4;

public class LinkedStackExample {
    public static void main(String[] args){
        ExprToken[] pExprTokens = new ExprToken[9];
        for(int i=0;i<9;i++){
            pExprTokens[i] = new ExprToken();
        }

        // 2 - ( 3 + 4 ) * 5
        pExprTokens[0].setType(PrecedenceType.operand);
        pExprTokens[0].setValue(2);

        pExprTokens[1].setType(PrecedenceType.minus);
        pExprTokens[1].setValue(0);

        pExprTokens[2].setType(PrecedenceType.lparen);
        pExprTokens[2].setValue(0);

        pExprTokens[3].setType(PrecedenceType.operand);
        pExprTokens[3].setValue(3);

        pExprTokens[4].setType(PrecedenceType.plus);
        pExprTokens[4].setValue(0);

        pExprTokens[5].setType(PrecedenceType.operand);
        pExprTokens[5].setValue(4);

        pExprTokens[6].setType(PrecedenceType.rparen);
        pExprTokens[6].setValue(0);

        pExprTokens[7].setType(PrecedenceType.multiply);
        pExprTokens[7].setValue(0);

        pExprTokens[8].setType(PrecedenceType.operand);
        pExprTokens[8].setValue(5);

        System.out.println("Infix Expression: 2.0 - ( 3.0 + 4.0 ) * 5.0");
        System.out.print("Postfix Expression: ");

        convertInfixToPostfix(pExprTokens, 9);
    }
    static int intStackPrecedence(PrecedenceType oper){
        switch (oper){
            case lparen:
                return 0;
            case rparen:
                return 4;
            case multiply:
            case divide:
                return 2;
            case plus:
            case minus:
                return 1;
        }
        return -1;
    }
    static int outStackPrecedence(PrecedenceType oper){
        switch (oper){
            case lparen:
                return 5;
            case rparen:
                return 4;
            case multiply:
            case divide:
                return 2;
            case plus:
            case minus:
                return 1;
        }
        return -1;
    }
    static void printToken(ExprToken element){
        switch (element.getType()){
            case lparen:
                System.out.print("( ");
                break;
            case rparen:
                System.out.print(") ");
                break;
            case plus:
                System.out.print("+ ");
                break;
            case minus:
                System.out.print("- ");
                break;
            case multiply:
                System.out.print("* ");
                break;
            case divide:
                System.out.print("/ ");
                break;
            case operand:
                System.out.print(element.getValue() + " ");
                break;
        }
    }
    static void convertInfixToPostfix(ExprToken[] pExprTokens ,int tokenCount){
        LinkedStack stack = new LinkedStack(); // 링크드 스택 생성
        LinkedStackNode ANode = null; // 저장 노드
        PrecedenceType tokenType, inStackTokenType; // 열거타입을 저장할 변수

        for(int i=0;i<tokenCount;i++){ // 토큰의 개수만큼 반복
            tokenType = pExprTokens[i].getType(); // 토큰의 타입을 가져옴
            switch (tokenType){ // 토큰의 타입을 가지고 돌리는 switch문
                case operand: // 연산자를 만났을 때
                    System.out.print(pExprTokens[i].getValue() + " "); // 바로 출력
                    break;
                case rparen: // ) 를 만났을 때
                    ANode = stack.popLinkedStack(); // 팝!
                    while((ANode != null) && (ANode.getData().getType() != PrecedenceType.lparen)){ // 비어있지않고 (를 만날때가지
                        printToken(ANode.getData()); // 연산자 출력
                        ANode = stack.popLinkedStack(); // 다시 팝! -> 반복
                    }
                    if(ANode != null){ // 저장 노드 초기화
                        ANode = null;
                    }
                    break; 
                default: // 나머지 경우 -> 꺼내고 푸쉬하냐 vs 그냥 푸쉬하냐
                    while(stack.isLinkedStackEmpty() == -1){ // 스택이 비어있지않으면! 
                        inStackTokenType = stack.peekLinkedStack().getData().getType(); // 스택 맨위의 토큰을 해옴peek
                        if(outStackPrecedence(tokenType) <= intStackPrecedence(inStackTokenType)){ // 둘의 연산자 우선순위를 비교, 내부가 더 클 경우
                            ANode = stack.popLinkedStack(); // 내부 연산자 팝!
                            if(ANode != null){ // 팝 잘됐는지 확인
                                printToken(ANode.getData()); // 출력
                            }
                        }
                        else{ // 외부가 더 클경우 while문을 빠져나옴
                            break;
                        }
                    } // 계속 비교반복
                    stack.pushLinkedStack(pExprTokens[i]); // 토큰 푸쉬
                    break;
            }
        }
        while(stack.isLinkedStackEmpty() == -1){ // 후처리  -> 스택이 비어있지 않으면 내부의 연산자를 순서대로 모두 팝,출력
            ANode = stack.popLinkedStack();
            if(ANode != null){ // 팝 잘됐는지 확인
                printToken(ANode.getData()); // 출력
            }
        } // 계속 비교반복
        stack.deleteLinkedStack(); // 스택 삭제
    }
}
