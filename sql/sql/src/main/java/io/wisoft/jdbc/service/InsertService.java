package io.wisoft.jdbc.service;

import io.wisoft.jdbc.PostgresqlAccess;
import io.wisoft.jdbc.Student;

import java.sql.*;

public class InsertService {
    // pro 14
    public void insertEMP(){
        String query = "INSERT INTO EMPLOYEE VALUES ('E903','손진현','E901','4000','R002')";
        try(Connection conn = PostgresqlAccess.setConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            ){
            conn.setAutoCommit(false);
            System.out.println("손진현씨가 등록되었습니다.");
            pstmt.executeUpdate();
            conn.commit();
        }catch (SQLException sqex){
            sqex.printStackTrace();
        }
    }
//    public void InsertStudent(final Student student) {
//        final String query = "INSERT INTO STUDENT VALUES (?,?,?)";
//        try (Connection connection = PostgresqlAccess.setConnection();
//             PreparedStatement pstmt = connection.prepareStatement(query)) {
//            connection.setAutoCommit(false);
//
//            pstmt.setString(1, student.getStudentNo());
//            pstmt.setString(2, student.getStudentName());
//            if (student.getStudentBirthday() == null) {
//                pstmt.setNull(3, Types.DATE);
//                pstmt.setNull(3, Types.DATE);
//            } else {
//                pstmt.setDate(3, (Date) student.getStudentBirthday());
//            }
//
//            int retValue = pstmt.executeUpdate();
//            connection.commit();
//            System.out.println(retValue + "건의사항이 처리되었습니다.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void insertStudentMulti(final Student[] students) {
//        final String query = "INSERT INTO STUDENT VALUES (?,?,?)";
//        try (Connection connection = PostgresqlAccess.setConnection();
//             PreparedStatement pstmt = connection.prepareStatement(query)) {
//            connection.setAutoCommit(false);
//
//            for (int i = 0; i < students.length; i++) {
//                if (students[i].getStudentNo() == null && students[i].getStudentName() == null) break;
//                pstmt.setString(1, students[i].getStudentNo());
//                pstmt.setString(2, students[i].getStudentName());
//                if (students[i].getStudentBirthday() == null) {
//                    pstmt.setNull(3, Types.DATE);
//                    pstmt.setNull(3, Types.DATE);
//                } else {
//                    pstmt.setDate(3, (Date) students[i].getStudentBirthday());
//                }
//
//                pstmt.addBatch();
//                pstmt.clearParameters();
//            }
//            int[] retValue = pstmt.executeBatch();
//            connection.commit();
//            System.out.println(retValue.length + "건의사항이 처리되었습니다.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void insertStudentMultiBatch(final Student[] students) {
//        final String query = "INSERT INTO STUDENT VALUES (?,?,?)";
//        try (Connection connection = PostgresqlAccess.setConnection();
//             PreparedStatement pstmt = connection.prepareStatement(query)) {
//            connection.setAutoCommit(false);
//
//            int retValue = 0;
//            for (int i = 0; i < students.length; i++) {
//                if (students[i].getStudentNo() == null && students[i].getStudentName() == null) break;
//                pstmt.setString(1, students[i].getStudentNo());
//                pstmt.setString(2, students[i].getStudentName());
//                if (students[i].getStudentBirthday() == null) {
//                    pstmt.setNull(3, Types.DATE);
//                    pstmt.setNull(3, Types.DATE);
//                } else {
//                    pstmt.setDate(3, (Date) students[i].getStudentBirthday());
//                }
//                retValue += pstmt.executeUpdate();
//                pstmt.clearParameters();
//            }
//
//            connection.commit();
//            System.out.println(retValue + "건의사항이 처리되었습니다.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
