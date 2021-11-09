package database.query;

import database.access.PostgresqlAccess;
import library.input.Input;
import exception.NumException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteService {

    Input input = Input.getInput();

    public void removeBook() throws NumException {
        SelectService selectService = new SelectService();

        System.out.print("지울 책의 번호를 입력해주세요: ");
        int bookNum = input.inputNum();

        if (!selectService.isBookExist(bookNum)){
            System.out.println(bookNum + "번의 책이 존재하지 않습니다.");
            return;
        }

        String query = "DELETE FROM 도서목록 WHERE 책번호=?";
        try (Connection conn = PostgresqlAccess.setConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
        ) {
            conn.setAutoCommit(false);
            pstmt.setInt(1, bookNum);
            pstmt.executeUpdate();
            conn.commit();
            System.out.println(bookNum + "번 책이 제거되었습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } // 책 제거하기

    public void resignUser(String phoneNum){

        try(Connection conn = PostgresqlAccess.setConnection()){
            conn.setAutoCommit(false);
            String query1 = "SELECT COUNT(*) FROM 대여 WHERE 전화번호=?";
            PreparedStatement pstmt1 = conn.prepareStatement(query1);
            pstmt1.setString(1,phoneNum);
            ResultSet rs = pstmt1.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0){
                System.out.println("대여한 책이 있어 탈퇴가 불가능합니다.");
                return;
            }

            String query2 = "DELETE FROM 손님 WHERE 전화번호=?";
            PreparedStatement pstmt2 = conn.prepareStatement(query2);
            pstmt2.setString(1,phoneNum);
            pstmt2.executeUpdate();
            conn.commit();
            pstmt1.close();
            pstmt2.close();
            System.out.println("회원 탈퇴 되었습니다.");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
