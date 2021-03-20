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
        LinkedStack stack = new LinkedStack();
        LinkedStackNode ANode = null;
        PrecedenceType tokenType, inStackTokenType;

        for(int i=0;i<tokenCount;i++){
            tokenType = pExprTokens[i].getType();
            switch (tokenType){
                case operand:
                    System.out.print(pExprTokens[i].getValue() + " ");
                    break;
                case rparen:
                    ANode = stack.popLinkedStack();
                    while((ANode != null) && (ANode.getData().getType() != PrecedenceType.lparen)){
                        printToken(ANode.getData());
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
            }
        }
        stack.deleteLinkedStack();
    }
}
