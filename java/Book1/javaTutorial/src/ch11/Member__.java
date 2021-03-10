package ch11;

import java.nio.charset.CoderMalfunctionError;
import java.util.Arrays;

public class Member__ implements Cloneable{
    public String name;
    public int age;
    public int[] scores;
    public Car car;

    public Member__(String name, int age, int[] scores, Car car){
        this.name = name;
        this.age = age;
        this.scores = scores;
        this.car = car;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        // 먼저 얕은 복사를 해서 name, age를 복사한다.
        Member__ cloned = (Member__) super.clone();
        // scores를 깊은 복제한다.
        cloned.scores = Arrays.copyOf(this.scores,this.scores.length);
        // car를 깊은 복제한다.
        cloned.car = new Car(this.car.model);
        // 깊은 복제된 Member객체를 리턴
        return cloned;
    }

    public Member__ getMember(){
        Member__ cloned = null;
        try{
            cloned = (Member__) clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return cloned;
    }
}
