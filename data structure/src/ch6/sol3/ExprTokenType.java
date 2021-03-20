package ch6.sol3;

enum PrecedenceType{ multiply, divide, plus, minus, operand }

public class ExprTokenType {
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
