package io.wisoft.jdbc.service;

import io.wisoft.jdbc.PostgresqlAccess;
import io.wisoft.jdbc.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteService {

//    // pro 15
//    public void DeleteEMP(){
//        String query = "DELETE FROM EMPLOYEE WHERE EMP_NAME = '손진현'";
//        try (Connection conn = PostgresqlAccess.setConnection();
//             PreparedStatement pstmt = conn.prepareStatement(query);
//        ){
//            conn.setAutoCommit(false);
//            conn.commit();
//            System.out.println("손진현님이 퇴직했습니다.");
//        } catch (SQLException sqex) {
//            System.out.println("SQLException: " + sqex.getMessage());
//            System.out.println("SQLState: " + sqex.getSQLState());
//        }
//    }

    public void deleteStudentNo(String studentNo) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = PostgresqlAccess.setConnection();
            conn.setAutoCommit(false);
            String query = "DELETE FROM STUDENT WHERE NO = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, studentNo);
            int retValue = pstmt.executeUpdate();
            conn.commit();
            System.out.println(retValue + "건의 사항이 처리되었습니다.");
        } catch (SQLException sqex) {
            System.out.println("SQLException: " + sqex.getMessage());
            System.out.println("SQLState: " + sqex.getSQLState());
        }
    }
//
//    public void deleteStudentNoMultiBatch(Student[] students) {
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        try {
//            conn = PostgresqlAccess.setConnection();
//            conn.setAutoCommit(false);
//            String query = "DELETE FROM STUDENT WHERE NO = ?";
//            pstmt = conn.prepareStatement(query);
//            for (int i = 0; i < students.length; i++) {
//                if (students[i].getStudentNo() == null)
//                    break;
//                pstmt.setString(1, students[i].getStudentNo());
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
