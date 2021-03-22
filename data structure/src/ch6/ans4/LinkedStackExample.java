package ch6.ans4;

import java.util.Scanner;

public class LinkedStackExample {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("수식을 입력해 주세요 : ");
        String input = scanner.nextLine();
        ExprToken pExprToken[] = new ExprToken[100];
        char[] changeToken = null;
        int tokenCount = 0;
        int index = 0;
        for(int i=0;i<input.length();i++){
            switch (input.charAt(i)){
                case '(':
                    if (changeToken != null) {
                        char[] ttt = new char[index];
                        for (int k = 0; k < index; k++) {
                            ttt[k] = changeToken[k];
                        }
                        String num = String.valueOf(ttt); // char배열 string으로
                        int nums = Integer.parseInt(num); // string을 int로

                        pExprToken[tokenCount] = new ExprToken();
                        pExprToken[tokenCount].setType(PrecedenceType.operand);
                        pExprToken[tokenCount].setValue(nums);

                        index = 0;
                        changeToken = null;
                        tokenCount++;
                    }
                    pExprToken[tokenCount] = new ExprToken();
                    pExprToken[tokenCount].setType(PrecedenceType.lparen);
                    pExprToken[tokenCount].setValue(0);
                    tokenCount++;
                    break;
                case ')':
                    if (changeToken != null) {
                        char[] ttt = new char[index];
                        for (int k = 0; k < index; k++) {
                            ttt[k] = changeToken[k];
                        }
                        String num = String.valueOf(ttt); // char배열 string으로
                        int nums = Integer.parseInt(num); // string을 int로

                        pExprToken[tokenCount] = new ExprToken();
                        pExprToken[tokenCount].setType(PrecedenceType.operand);
                        pExprToken[tokenCount].setValue(nums);

                        index = 0;
                        changeToken = null;
                        tokenCount++;
                    }
                    pExprToken[tokenCount] = new ExprToken();
                    pExprToken[tokenCount].setType(PrecedenceType.rparen);
                    pExprToken[tokenCount].setValue(0);
                    tokenCount++;
                    break;
                case '+':
                    if (changeToken != null) {
                        char[] ttt = new char[index];
                        for (int k = 0; k < index; k++) {
                            ttt[k] = changeToken[k];
                        }
                        String num = String.valueOf(ttt); // char배열 string으로
                        int nums = Integer.parseInt(num); // string을 int로

                        pExprToken[tokenCount] = new ExprToken();
                        pExprToken[tokenCount].setType(PrecedenceType.operand);
                        pExprToken[tokenCount].setValue(nums);

                        index = 0;
                        changeToken = null;
                        tokenCount++;
                    }
                    pExprToken[tokenCount] = new ExprToken();
                    pExprToken[tokenCount].setType(PrecedenceType.plus);
                    pExprToken[tokenCount].setValue(0);
                    tokenCount++;
                    break;
                case '-':
                    if (changeToken != null) {
                        char[] ttt = new char[index];
                        for (int k = 0; k < index; k++) {
                            ttt[k] = changeToken[k];
                        }
                        String num = String.valueOf(ttt); // char배열 string으로
                        int nums = Integer.parseInt(num); // string을 int로

                        pExprToken[tokenCount] = new ExprToken();
                        pExprToken[tokenCount].setType(PrecedenceType.operand);
                        pExprToken[tokenCount].setValue(nums);

                        index = 0;
                        changeToken = null;
                        tokenCount++;
                    }
                    pExprToken[tokenCount] = new ExprToken();
                    pExprToken[tokenCount].setType(PrecedenceType.minus);
                    pExprToken[tokenCount].setValue(0);
                    tokenCount++;
                    break;
                case '*':
                    if (changeToken != null) {
                        char[] ttt = new char[index];
                        for (int k = 0; k < index; k++) {
                            ttt[k] = changeToken[k];
                        }
                        String num = String.valueOf(ttt); // char배열 string으로
                        int nums = Integer.parseInt(num); // string을 int로

                        pExprToken[tokenCount] = new ExprToken();
                        pExprToken[tokenCount].setType(PrecedenceType.operand);
                        pExprToken[tokenCount].setValue(nums);

                        index = 0;
                        changeToken = null;
                        tokenCount++;
                    }
                    pExprToken[tokenCount] = new ExprToken();
                    pExprToken[tokenCount].setType(PrecedenceType.multiply);
                    pExprToken[tokenCount].setValue(0);
                    tokenCount++;
                    break;
                case '/':
                    if (changeToken != null) {
                        char[] ttt = new char[index];
                        for (int k = 0; k < index; k++) {
                            ttt[k] = changeToken[k];
                        }
                        String num = String.valueOf(ttt); // char배열 string으로
                        int nums = Integer.parseInt(num); // string을 int로

                        pExprToken[tokenCount] = new ExprToken();
                        pExprToken[tokenCount].setType(PrecedenceType.operand);
                        pExprToken[tokenCount].setValue(nums);

                        index = 0;
                        changeToken = null;
                        tokenCount++;
                    }
                    pExprToken[tokenCount] = new ExprToken();
                    pExprToken[tokenCount].setType(PrecedenceType.divide);
                    pExprToken[tokenCount].setValue(0);
                    tokenCount++;
                    break;
                case '\t':
                    if (changeToken != null) {
                        char[] ttt = new char[index];
                        for (int k = 0; k < index; k++) {
                            ttt[k] = changeToken[k];
                        }
                        String num = String.valueOf(ttt); // char배열 string으로
                        int nums = Integer.parseInt(num); // string을 int로

                        pExprToken[tokenCount] = new ExprToken();
                        pExprToken[tokenCount].setType(PrecedenceType.operand);
                        pExprToken[tokenCount].setValue(nums);

                        index = 0;
                        changeToken = null;
                        tokenCount++;
                    }
                    break;
                case ' ':
                    if (changeToken != null) {
                        char[] ttt = new char[index];
                        for (int k = 0; k < index; k++) {
                            ttt[k] = changeToken[k];
                        }
                        String num = String.valueOf(ttt); // char배열 string으로
                        int nums = Integer.parseInt(num); // string을 int로

                        pExprToken[tokenCount] = new ExprToken();
                        pExprToken[tokenCount].setType(PrecedenceType.operand);
                        pExprToken[tokenCount].setValue(nums);

                        index = 0;
                        changeToken = null;
                        tokenCount++;
                    }
                    break;
                default:
                    if(changeToken == null) {
                        changeToken = new char[6];
                    }
                    changeToken[index] = input.charAt(i);
                    index++;
                    break;
            }
        }
        if (changeToken != null) {
            char[] ttt = new char[index];
            for (int k = 0; k < index; k++) {
                ttt[k] = changeToken[k];
            }
            String num = String.valueOf(ttt); // char배열 string으로
            int nums = Integer.parseInt(num); // string을 int로

            pExprToken[tokenCount] = new ExprToken();
            pExprToken[tokenCount].setType(PrecedenceType.operand);
            pExprToken[tokenCount].setValue(nums);

            index = 0;
            changeToken = null;
            tokenCount++;
        }

        System.out.println("Infix Expression: " + input);
        System.out.print("Postfix Expression: ");

        ExprToken[] calc = convertInfixToPostfix(pExprToken,tokenCount);
        System.out.println();

        calcExpr(calc,tokenCalcCount);
    }
    static int tokenCalcCount = 0;
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
    static ExprToken[] convertInfixToPostfix(ExprToken[] pExprTokens , int tokenCount){
        LinkedStack stack = new LinkedStack();
        LinkedStackNode ANode = null;
        PrecedenceType tokenType, inStackTokenType;

        ExprToken[] pReturn = new ExprToken[tokenCount];
        int returnTokenCount = 0;

        for(int i=0;i<tokenCount;i++){
            tokenType = pExprTokens[i].getType();
            switch (tokenType){
                case operand:
                    System.out.print(pExprTokens[i].getValue() + " ");
                    pReturn[returnTokenCount] = new ExprToken();
                    pReturn[returnTokenCount].setType(tokenType);
                    pReturn[returnTokenCount].setValue(pExprTokens[i].getValue());
                    returnTokenCount++;
                    break;
                case rparen:
                    ANode = stack.popLinkedStack();
                    while((ANode != null) && (ANode.getData().getType() != PrecedenceType.lparen)){
                        printToken(ANode.getData());
                        pReturn[returnTokenCount] = new ExprToken();
                        pReturn[returnTokenCount].setType(ANode.getData().getType());
                        pReturn[returnTokenCount].setValue(ANode.getData().getValue());
                        returnTokenCount++;
                        ANode = stack.popLinkedStack();
                    }
                    if(ANode != null){
                        ANode = null;
                    }
                    break;
                default:
                    while(stack.isLinkedStackEmpty() == -1){
                        inStackTokenType = stack.peekLinkedStack().getData().getType();
                        if(outStackPrecedence(tokenType) <= intStackPrecedence(inStackTokenType)){
                            ANode = stack.popLinkedStack();
                            if(ANode != null){
                                printToken(ANode.getData());
                                pReturn[returnTokenCount] = new ExprToken();
                                pReturn[returnTokenCount].setType(ANode.getData().getType());
                                pReturn[returnTokenCount].setValue(ANode.getData().getValue());
                                returnTokenCount++;
                            }
                        }
                        else{
                            break;
                        }
                    }
                    stack.pushLinkedStack(pExprTokens[i]);
                    break;
            }
        }
        while(stack.isLinkedStackEmpty() == -1){
            ANode = stack.popLinkedStack();
            if(ANode != null){
                printToken(ANode.getData());
                pReturn[returnTokenCount] = new ExprToken();
                pReturn[returnTokenCount].setType(ANode.getData().getType());
                pReturn[returnTokenCount].setValue(ANode.getData().getValue());
                returnTokenCount++;
            }
        }
        stack.deleteLinkedStack();

        tokenCalcCount = returnTokenCount;
        return pReturn;
    }
    static void calcExpr(ExprToken[] pExprTokens, int tokenCount){
        if(pExprTokens == null){
            return;
        }
        LinkedStackNode ANode = null,BNode = null;
        PrecedenceType tokenType;
        LinkedStack stack = new LinkedStack();
        for(int i=0;i<tokenCount;i++){
            tokenType = pExprTokens[i].getType();

            if(tokenType == PrecedenceType.operand){
                stack.pushLinkedStack(pExprTokens[i]);
            }
            else{
                BNode = stack.popLinkedStack();
                if(BNode != null){
                    ANode = stack.popLinkedStack();
                    if(ANode != null){
                        double op1 = ANode.getData().getValue();
                        double op2 = BNode.getData().getValue();

                        ExprToken newToken = new ExprToken();
                        newToken.setType(PrecedenceType.operand);
                        switch (tokenType){
                            case plus:
                                newToken.setValue(op1 + op2);
                                break;
                            case minus:
                                newToken.setValue(op1 - op2);
                                break;
                            case multiply:
                                newToken.setValue(op1 * op2);
                                break;
                            case divide:
                                newToken.setValue(op1 / op2);
                                break;
                        }
                        stack.pushLinkedStack(newToken);
                    }
                }
            }
        }

        ANode = stack.popLinkedStack();
        if(ANode != null){
            System.out.println("수식 계산 결과는 " + ANode.getData().getValue() + "입니다.");
        }
        else{
            System.out.println("오류, 수식에 오류가 있습니다.");
        }
        stack.deleteLinkedStack();
    }
}
