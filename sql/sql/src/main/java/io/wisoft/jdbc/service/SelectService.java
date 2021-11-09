package io.wisoft.jdbc.service;

import io.wisoft.jdbc.PostgresqlAccess;

import java.sql.*;

public class SelectService {

        public void getStudentAll() {
        final String query = "SELECT * FROM STUDENT";
        try (Connection connection = PostgresqlAccess.setConnection();
             PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery();) {
            while (rs.next()) {
                System.out.print("[학번] " + rs.getString(1) + "||");
                System.out.print("[이름] " + rs.getString(2) + "||");
                System.out.println("[생일] " + rs.getString(3));
            }
        } catch (SQLException sqex) {
            System.out.println("SQLException: " + sqex.getMessage());
            System.out.println("SQLState: " + sqex.getSQLState());
        }
    }
//
//    public void getStudentNo(String studentNo) {
//        final String query = "SELECT * FROM STUDENT WHERE NO = ?";
//
//        try (Connection connection = PostgresqlAccess.setConnection();
//             PreparedStatement pstmt = connection.prepareStatement(query);) {
//            pstmt.setString(1, studentNo);
//            try (ResultSet rs = pstmt.executeQuery()) {
//                while (rs.next()) {
//                    System.out.print("[학번] " + rs.getString(1) + "||");
//                    System.out.print("[이름] " + rs.getString(2) + "||");
//                    System.out.println("[생일] " + rs.getString(3));
//                }
//            }
//        } catch (SQLException sqex) {
//            System.out.println("SQLException: " + sqex.getMessage());
//            System.out.println("SQLState: " + sqex.getSQLState());
//        }
//    }
//
//    public void getStudentName(String studentName) {
//        final String query = "SELECT * FROM STUDENT WHERE NAME = ?";
//
//        try (Connection connection = PostgresqlAccess.setConnection();
//             PreparedStatement pstmt = connection.prepareStatement(query);) {
//            pstmt.setString(1, studentName);
//            try (ResultSet rs = pstmt.executeQuery()) {
//                while (rs.next()) {
//                    System.out.print("[학번] " + rs.getString(1) + "||");
//                    System.out.print("[이름] " + rs.getString(2) + "||");
//                    System.out.println("[생일] " + rs.getString(3));
//                }
//            }
//        } catch (SQLException sqex) {
//            System.out.println("SQLException: " + sqex.getMessage());
//            System.out.println("SQLState: " + sqex.getSQLState());
//        }
//    }
//
//    public void getStudentBirthday(String studentBirthday) {
//        final String query = "SELECT * FROM STUDENT WHERE BIRTHDAY = ?";
//
//        try (Connection connection = PostgresqlAccess.setConnection();
//             PreparedStatement pstmt = connection.prepareStatement(query);) {
//            pstmt.setDate(1, Date.valueOf(studentBirthday));
//            try (ResultSet rs = pstmt.executeQuery()) {
//                while (rs.next()) {
//                    System.out.print("[학번] " + rs.getString(1) + "||");
//                    System.out.print("[이름] " + rs.getString(2) + "||");
//                    System.out.println("[생일] " + rs.getString(3));
//                }
//            }
//        } catch (SQLException sqex) {
//            System.out.println("SQLException: " + sqex.getMessage());
//            System.out.println("SQLState: " + sqex.getSQLState());
//        }
//    }
//
//    // pro 11
//    public void Pro11(){
//        String query = "SELECT EMP_NAME,EMP_SAL FROM EMPLOYEE WHERE EMP_SAL >= (SELECT AVG(EMP_SAL) FROM EMPLOYEE) ";
//        try (Connection conn = PostgresqlAccess.setConnection();
//             PreparedStatement pstmt = conn.prepareStatement(query);
//             ResultSet rs = pstmt.executeQuery();) {
//            conn.setAutoCommit(false);
//            while (rs.next()) {
//                System.out.print("[연예관계자 이름] " + rs.getString(1));
//                System.out.println("[연예관계자 직속상사] " + rs.getString(2));
//            }
//        } catch (SQLException sqex) {
//            System.out.println("SQLException: " + sqex.getMessage());
//            System.out.println("SQLState: " + sqex.getSQLState());
//        }
//    }
//    // pro 10
//    public void Pro10() {
//        String query = "SELECT R.EMP_RNAME, AVG(E.EMP_SAL), MIN(E.EMP_SAL), MAX(E.EMP_SAL)"
//                + " FROM EMPLOYEE E, EMP_ROLE R"
//                + " WHERE E.EMP_RCODE = R.EMP_RCODE GROUP BY R.EMP_RNAME"
//                + " HAVING AVG(E.EMP_SAL) >= 5000 ORDER BY R.EMP_RNAME";
//        try (Connection conn = PostgresqlAccess.setConnection();
//             PreparedStatement pstmt = conn.prepareStatement(query);
//             ResultSet rs = pstmt.executeQuery();
//        ) {
//            conn.setAutoCommit(false);
//            while (rs.next()) {
//                System.out.print("[직급] " + rs.getString(1) + "\t");
//                System.out.print("[평균] " + rs.getString(2) + "\t");
//                System.out.print("[최소] " + rs.getString(3) + "\t");
//                System.out.print("[최대] " + rs.getString(4));
//                System.out.println();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    // pro 9
//    public void Pay(){
//        String query = "SELECT EMP_NAME,EMP_SAL FROM EMPLOYEE ORDER BY EMP_SAL DESC, EMP_NAME ";
//        try (Connection conn = PostgresqlAccess.setConnection();
//             PreparedStatement pstmt = conn.prepareStatement(query);
//             ResultSet rs = pstmt.executeQuery();) {
//            conn.setAutoCommit(false);
//            while (rs.next()) {
//                System.out.print("[연예관계자 이름] " + rs.getString(1));
//                System.out.println("[연예관계자 직속상사] " + rs.getString(2));
//            }
//        } catch (SQLException sqex) {
//            System.out.println("SQLException: " + sqex.getMessage());
//            System.out.println("SQLState: " + sqex.getSQLState());
//        }
//    }
//    // pro 8
//    public void EmployeeWithMaster(){
//        String query = "select e1.emp_name, e2.emp_name\n" +
//                "from employee e1, employee e2\n" +
//                "where e1.emp_mgt = e2.emp_code;";
//        try (Connection conn = PostgresqlAccess.setConnection();
//             PreparedStatement pstmt = conn.prepareStatement(query);
//             ResultSet rs = pstmt.executeQuery();) {
//            conn.setAutoCommit(false);
//            while (rs.next()) {
//                System.out.print("[연예관계자 이름] " + rs.getString(1));
//                System.out.println("[연예관계자 직속상사] " + rs.getString(2));
//            }
//        } catch (SQLException sqex) {
//            System.out.println("SQLException: " + sqex.getMessage());
//            System.out.println("SQLState: " + sqex.getSQLState());
//        }
//    }
//    // pro 7
//    public void DramaEMP_opdateNll(){
//        String query = "SELECT DRM_NAME FROM DRAMA WHERE DRM_OPDATE is NULL";
//        try (Connection conn = PostgresqlAccess.setConnection();
//             PreparedStatement pstmt = conn.prepareStatement(query);
//             ResultSet rs = pstmt.executeQuery();) {
//            conn.setAutoCommit(false);
//            while (rs.next()) {
//                System.out.println("[드라마 이름] " + rs.getString(1));
//            }
//        } catch (SQLException sqex) {
//            System.out.println("SQLException: " + sqex.getMessage());
//            System.out.println("SQLState: " + sqex.getSQLState());
//        }
//    }
//    // pro 6
//    public void EmployeePay(){
//        String query = "SELECT SUM(EMP_SAL),AVG(EMP_SAL) FROM EMPLOYEE";
//        try (Connection conn = PostgresqlAccess.setConnection();
//             PreparedStatement pstmt = conn.prepareStatement(query);
//             ResultSet rs = pstmt.executeQuery();) {
//            conn.setAutoCommit(false);
//            while (rs.next()) {
//                System.out.println("[연예관계자 급여의 총합] " + rs.getString(1));
//                System.out.println("[연예관계자 평균 급여액] " + rs.getString(2));
//            }
//        } catch (SQLException sqex) {
//            System.out.println("SQLException: " + sqex.getMessage());
//            System.out.println("SQLState: " + sqex.getSQLState());
//        }
//    }
//    // pro 5
//    public void selectDramaDistinct() {
//        String query = "SELECT DISTINCT DRM_PRD FROM DRAMA";
//        try (Connection conn = PostgresqlAccess.setConnection();
//             PreparedStatement pstmt = conn.prepareStatement(query);
//             ResultSet rs = pstmt.executeQuery();) {
//            conn.setAutoCommit(false);
//            while (rs.next()) {
//                System.out.println("[드라마제작사] " + rs.getString(1));
//            }
//        } catch (SQLException sqex) {
//            System.out.println("SQLException: " + sqex.getMessage());
//            System.out.println("SQLState: " + sqex.getSQLState());
//        }
//    }
//    // pro 4
//    public void selectDrama(){
//        String query = "SELECT DRM_NAME FROM DRAMA WHERE DRM_BRD='KBC' or DRM_BRD='SBC'";
//        try(Connection conn = PostgresqlAccess.setConnection();
//            PreparedStatement pstmt = conn.prepareStatement(query);
//            ResultSet rs = pstmt.executeQuery();){
//            conn.setAutoCommit(false);
//            while(rs.next()){
//                System.out.println("[드라마이름] " + rs.getString(1));
//            }
//        }catch (SQLException sqex){
//            System.out.println("SQLException: " + sqex.getMessage());
//            System.out.println("SQLState: " + sqex.getSQLState());
//        }
//    }
//    // pro 3
//    public void selectDramaCodeName(){
//        String query = "SELECT DRM_CODE,DRM_NAME FROM DRAMA";
//        try(Connection conn = PostgresqlAccess.setConnection();
//            PreparedStatement pstmt = conn.prepareStatement(query);
//            ResultSet rs = pstmt.executeQuery();
//        ){
//            conn.setAutoCommit(false);
//            while(rs.next()){
//                System.out.print("[드라마코드] " + rs.getString(1)  + "\t");
//                System.out.println("[드라마이름] " + rs.getString(2));
//            }
//        }catch (SQLException sqex){
//            System.out.println("SQLException: " + sqex.getMessage());
//            System.out.println("SQLState: " + sqex.getSQLState());
//        }
//    }
//    // pro 2
//    public void selectEmployeeAll(){
//        String query = "SELECT * FROM EMPLOYEE";
//        try(Connection conn = PostgresqlAccess.setConnection();
//            PreparedStatement pstmt = conn.prepareStatement(query);
//            ResultSet rs = pstmt.executeQuery();
//        ){
//            conn.setAutoCommit(false);
//            while(rs.next()){
//                System.out.print("[연예관계자코드] " + rs.getString(1)  + "\t");
//                System.out.print("[연예관계자이름] " + rs.getString(2)  + "\t");
//                System.out.print("[연예관계자관리자] " + rs.getString(3)  + "\t");
//                System.out.println("[연예관계자급여] " + rs.getString(4));
//            }
//        }catch (SQLException sqex){
//            System.out.println("SQLException: " + sqex.getMessage());
//            System.out.println("SQLState: " + sqex.getSQLState());
//        }
//    }
//    // pro 1
//    public void selectDepartmentAll() {
//        String query = "SELECT * FROM DEPARTMENT";
//        try (Connection conn = PostgresqlAccess.setConnection();
//             PreparedStatement pstmt = conn.prepareStatement(query);
//             ResultSet rs = pstmt.executeQuery();){
//            conn.setAutoCommit(false);
//            while (rs.next()) {
//                System.out.print("[부서코드] " + rs.getString(1) + "\t");
//                System.out.print("[부서이름] " + rs.getString(2) + "\t");
//                System.out.println("[부서위치] " + rs.getString(3));
//            }
//        } catch (SQLException sqex) {
//            System.out.println("SQLException: " + sqex.getMessage());
//            System.out.println("SQLState: " + sqex.getSQLState());
//        }
//    }

}
