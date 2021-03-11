package ch14;

public class Student_ {
    private String name;
    private String sex;
    private int score;

    public Student_(String name,String sex,int score ){
        this.name = name;
        this.sex = sex;
        this.score = score;
    }

    public String getSex(){return sex;}
    public int getScore(){return score;}
}
