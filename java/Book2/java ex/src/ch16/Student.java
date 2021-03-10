package ch16;

public class Student {
    private String name;
    public int score;

    public Student(String name,int score){
        this.name = name;
        this.score = score;
    }
    public String getName(){return name;}
    public int getScore(){return score;}
}
