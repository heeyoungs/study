package ch6.ans4;

enum PrecedenceType{ lparen, rparen, multiply, divide, plus, minus, operand }

public class ExprToken {
    private double value;
    private PrecedenceType type;
    void setValue(double value){
        this.value = value;
    }
    double getValue(){
        return value;
    }
    void setType(PrecedenceType type){
        this.type = type;
    }
    PrecedenceType getType(){
        return type;
    }
}