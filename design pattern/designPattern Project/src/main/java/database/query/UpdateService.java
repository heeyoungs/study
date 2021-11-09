package database.query;

import database.access.PostgresqlAccess;
import library.input.Input;
import exception.DateException;
import exception.NumException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateService {

    Input input = Input.getInput();

    public void updateBookBirth() throws NumException, DateException {

        System.out.print("갱신할 책의 번호를 입력하세요: ");
        int bookNum = input.inputNum();
        System.out.print("갱신할 출판년도를 입력해주세요: ");
        Date bookBirth = input.inputDate();
        String query = "UPDATE 도서목록 SET 책출판년도=? WHERE 책번호 = ?";
        try (Connection conn = PostgresqlAccess.setConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)
        ) {
            conn.setAutoCommit(false);
            pstmt.setDate(1, bookBirth);
            pstmt.setInt(2, bookNum);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            System.out.println(bookNum + "번의 책이 존재하지 않습니다.");
            return;
        }
        System.out.println(bookNum + "번 책의 출판년도가 갱신되었습니다.");
    } // 책 출판년도 갱신

    public void borrowBook(String phoneNum) throws NumException {
        SelectService selectService = new SelectService(); // 책의 존재 여부 확인을 위함

        System.out.print("빌리고 싶은 책의 번호를 입력해주세요: ");
        int bookNum = input.inputNum();

        if (!selectService.isBookExist(bookNum)) {
            System.out.println("책이 없습니다!");
            return;
        }

        // 도서목록의 책 대출가능여부를 false로
        try (Connection conn = PostgresqlAccess.setConnection()) {
            conn.setAutoCommit(false);
            String query1 = "UPDATE 도서목록 SET 책대출가능여부=false WHERE 책번호=?";
            PreparedStatement pstmt1 = conn.prepareStatement(query1);
            pstmt1.setInt(1, bookNum);
            pstmt1.executeUpdate();

            String query2 = "INSERT INTO 대여 VALUES (?,?)";
            PreparedStatement pstmt2 = conn.prepareStatement(query2);
            pstmt2.setInt(1, bookNum);
            pstmt2.setString(2, phoneNum);
            pstmt2.executeUpdate();

            conn.commit();
            pstmt1.close();
            pstmt2.close();
        } catch (SQLException e) {
            System.out.println("책을 빌릴 수 없습니다.");
            return;
        }

        System.out.println(bookNum + "번 책을 빌렸습니다.");
    }

    public void returnBook(String phoneNum) throws NumException {
        SelectService selectService = new SelectService();

        System.out.print("반납할 책의 번호를 입력해주세요: ");
        int bookNum = input.inputNum();

        if (!selectService.isBorrowed(bookNum, phoneNum)) {
            System.out.println("반납 대상이 아닙니다.");
            return;
        }

        try (Connection conn = PostgresqlAccess.setConnection()) {
            conn.setAutoCommit(false);
            String query1 = "UPDATE 도서목록 SET 책대출가능여부=true WHERE 책번호=?";
            PreparedStatement pstmt1 = conn.prepareStatement(query1);
            pstmt1.setInt(1, bookNum);
            pstmt1.executeUpdate();

            String query2 = "DELETE FROM 대여 WHERE 책번호=?";
            PreparedStatement pstmt2 = conn.prepareStatement(query2);
            pstmt2.setInt(1, bookNum);
            pstmt2.executeUpdate();
            conn.commit();
            pstmt1.close();
            pstmt2.close();
        } catch (SQLException e) {
            System.out.println("책을 반납할 수 없습니다.");
            return;
        }

        System.out.println(bookNum + "번 책을 반납했습니다.");
    }
}
