package ch15_;

import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args){
        TreeSet<Student_> treeSet = new TreeSet<Student_>();

        treeSet.add(new Student_("blue",96));
        treeSet.add(new Student_("hong",86));
        treeSet.add(new Student_("white",92));

        Student_ student = treeSet.last();
        System.out.println("최고점수: " + student.score);
        System.out.println("최고점수를 받은 아이디: " + student.id);
    }
}
