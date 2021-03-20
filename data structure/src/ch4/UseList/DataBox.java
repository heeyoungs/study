package ch4.uselist;

public class DataBox {
    private int degree;
    private double coef;
    int getDegree(){
        return degree;
    }
    double getCoef(){
        return coef;
    }
    DataBox(int degree,double coef){
        this.degree = degree;
        this.coef = coef;
    }
}
