package ch16;

public class Student_ implements Comparable<Student_>{
    private String name;
    private int score;

    public Student_(String name,int score){
        this.name = name;
        this.score =score;
    }

    public String getName(){return name;}
    public int getScore(){return score;}

    @Override
    public int compareTo(Student_ o){
        return Integer.compare(score,o.score);
    }
}
