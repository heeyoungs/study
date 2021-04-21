import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String studentName;
        int studentNumber;
        int count = 0;
        Student[] students = new Student[1000];
        while(true){
            System.out.print("이름 입력 : ");
            studentName = sc.next();
            System.out.print("학번 입력 (종료시 0) :");
            studentNumber = sc.nextInt();
            if(studentNumber == 0){
                break;
            } // 종료 조건
            students[count] = new Student();
            students[count].setStudentName(studentName); // 세터 사용
            students[count].setStudentNumber(studentNumber);
            count++;
        }
        for(int i=0;i<count;i++){
            // 게터 사용
            System.out.println(students[i].getStudentName() + " - " + students[i].getStudentNumber());
        }
    }

    static class Student {
        private String studentName;
        private int studentNumber;

        Student() {}

        void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        void setStudentNumber(int studentNumber) {
            this.studentNumber = studentNumber;
        }

        String getStudentName() {
            return studentName;
        }

        int getStudentNumber() {
            return studentNumber;
        }
    }
}
