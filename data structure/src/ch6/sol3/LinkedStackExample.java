package ch6.sol3;

public class LinkedStackExample {
    public static void main(String[] args){
        ExprTokenType[] pExpTokens = new ExprTokenType[7];
        for(int i=0;i<7;i++){
            pExpTokens[i] = new ExprTokenType();
        }

        pExpTokens[0].setType(PrecedenceType.operand);
        pExpTokens[0].setValue(2);

        pExpTokens[1].setType(PrecedenceType.operand);
        pExpTokens[1].setValue(3);

        pExpTokens[2].setType(PrecedenceType.operand);
        pExpTokens[2].setValue(4);

        pExpTokens[3].setType(PrecedenceType.plus);
        pExpTokens[3].setValue(0);

        pExpTokens[4].setType(PrecedenceType.operand);
        pExpTokens[4].setValue(5);

        pExpTokens[5].setType(PrecedenceType.multiply);
        pExpTokens[5].setValue(0);

        pExpTokens[6].setType(PrecedenceType.minus);
        pExpTokens[6].setValue(0);

        System.out.println("Expression: 2 3 4 + 5 * -");
        calcExpr(pExpTokens, 7);
    }

    static void calcExpr(ExprTokenType[] pExprTokens, int tokenCount){
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

                        ExprTokenType newToken = new ExprTokenType();
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
