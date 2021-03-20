package ch13_.ans4;

public class Util{
    static Integer getValue(Pair p, String s){
        if(p.getKey().equals(s)){
            return (Integer) p.getValue();
        }
        else{
            return null;
        }
    }
}
