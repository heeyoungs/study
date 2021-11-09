package io.wisoft.jdbc;

import java.util.Date;

public class Student {
    private String studentNo;
    private String studentName;
    private Date studentBirthday;

    public String getStudentNo() {
        return studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public Date getStudentBirthday() {
        return studentBirthday;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentBirthday(Date studentBirthday) {
        this.studentBirthday = studentBirthday;
    }
}
