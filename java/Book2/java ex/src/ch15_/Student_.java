package ch15_;

public class Student_ implements Comparable<Student_> {
    public String id;
    public int score;

    public Student_ (String id,int score){
        this.id = id;
        this.score = score;
    }

    @Override
    public int compareTo(Student_ o){
        if(score < o.score) return -1;
        else if(score == o.score) return 0;
        else return 1;
    }
}
