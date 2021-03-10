package ch11;

import java.lang.String;

public class Student {
    private  String studentNum;

    public Student(String studentNum){
        this.studentNum = studentNum;
    }

    public String getStudentNum(){
        return studentNum;
    }

    // 작성
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Student){
            Student student = (Student) obj;
            if(studentNum.equals(student.studentNum)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Integer.parseInt(studentNum);
    }
}
