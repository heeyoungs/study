package io.wisoft.jdbc.service;

import io.wisoft.jdbc.PostgresqlAccess;
import io.wisoft.jdbc.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

public class UpdateService {

//    // pro 13
//    public void updateEmployeePromotion(String roleCode, double incRate, String empName) {
//        String query = "UPDATE EMPLOYEE SET EMP_RCODE = ?, EMP_SAL = EMP_SAL* ?"
//                + "WHERE EMP_NAME = ?";
//        try (Connection conn = PostgresqlAccess.setConnection();
//             PreparedStatement pstmt = conn.prepareStatement(query)
//        ) {
//            conn.setAutoCommit(false);
//            pstmt.setString(1, roleCode);
//            pstmt.setDouble(2, incRate);
//            pstmt.setString(3, empName);
//            conn.commit();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    // pro 12
//    public void updateEMP_OPDATE(){
//        String query = "UPDATE DRAMA SET DRM_OPDATE='2013-05-01' WHERE DRM_OPDATE IS NULL";
//        try (Connection conn = PostgresqlAccess.setConnection();
//             PreparedStatement pstmt = conn.prepareStatement(query)
//        ) {
//            conn.setAutoCommit(false);
//            conn.commit();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    public void updateStudentBirthday(String no, Date birthday) {
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        try {
//            conn = PostgresqlAccess.setConnection();
//            conn.setAutoCommit(false);
//            String query = "UPDATE STUDENT SET BIRTHDAY = ? WHERE NO = ?";
//            pstmt = conn.prepareStatement(query);
//            pstmt.setDate(1, (Date) birthday);
//            pstmt.setString(2, no);
//            int retValue = pstmt.executeUpdate();
//            conn.commit();
//            System.out.println(retValue + "건의 사항이 처리되었습니다.");
//        } catch (SQLException sqex) {
//            System.out.println("SQLException: " + sqex.getMessage());
//            System.out.println("SQLState: " + sqex.getSQLState());
//        }
//    }
//
//    public void updateStudentBirthday(Student student) {
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        try {
//            conn = PostgresqlAccess.setConnection();
//            conn.setAutoCommit(false);
//            String query = "UPDATE STUDENT SET BIRTHDAY = ? WHERE NO = ?";
//            pstmt = conn.prepareStatement(query);
//            pstmt.setDate(1, (Date) student.getStudentBirthday());
//            pstmt.setString(2, student.getStudentNo());
//            int retValue = pstmt.executeUpdate();
//            conn.commit();
//            System.out.println(retValue + "건의 사항이 처리되었습니다.");
//        } catch (SQLException sqex) {
//            System.out.println("SQLException: " + sqex.getMessage());
//            System.out.println("SQLState: " + sqex.getSQLState());
//        }
//    }
//
//    public void updateStudentBirthdayMultiBatch(Student[] students) {
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        try {
//            conn = PostgresqlAccess.setConnection();
//            conn.setAutoCommit(false);
//            String query = "UPDATE STUDENT SET BIRTHDAY = ? WHERE NO = ?";
//            pstmt = conn.prepareStatement(query);
//            for (int i = 0; i < students.length; i++) {
//                if (students[i].getStudentNo() == null && students[i].getStudentBirthday() == null)
//                    break;
//                pstmt.setDate(1, (Date) students[i].getStudentBirthday());
//                pstmt.setString(2, students[i].getStudentNo());
//                pstmt.addBatch();
//                pstmt.clearParameters();
//            }
//            int[] retValue = pstmt.executeBatch();
//            conn.commit();
//            System.out.println(retValue.length + "건의 사항이 처리되었습니다.");
//        } catch (SQLException sqex) {
//            System.out.println("SQLException: " + sqex.getMessage());
//            System.out.println("SQLState: " + sqex.getSQLState());
//        }
//    }
}
