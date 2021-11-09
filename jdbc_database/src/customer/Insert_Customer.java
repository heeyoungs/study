package customer;

import conf.Conf;
import java.sql.*;

public class Insert_Customer {
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement psmtQuery = null;
		PreparedStatement psmtUpdate = null;
		
		ResultSet rs = null;
		
		//insert할 고객 데이터를 기입한다.	
		String customerId = "grape";
		String customerName = "홍길동";
		int age = 20;
		String grade = "gold";
		String jobTitle = "대학생";
		int savedMoney = 10000;
		
		try {
			// 드라이버를 로딩한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 데이터베이스의 연결을 설정한다.
			conn = DriverManager.getConnection(Conf.DB_URL, Conf.DB_USER, Conf.DB_PASSWORD);

			// 고객 정보가 있는지 확인
			String query = "select customer_id from customer where customer_id = ?";
			psmtQuery = conn.prepareStatement(query);
			psmtQuery.setString(1,  customerId);
			rs = psmtQuery.executeQuery();

			if (rs.next()) { // 고객 정보가 있는 경우
				System.out.println("에러 : 중복되는 아이디가 존재합니다.");
			} else { // 고객 정보가 없는 경우, insert를 진행한다.
				String insertStatement = "INSERT INTO customer VALUES (?,?,?,?,?,?)";
				
				psmtUpdate = conn.prepareStatement(insertStatement);	
				
				psmtUpdate.setString(1, customerId);
				psmtUpdate.setString(2, customerName);
				psmtUpdate.setInt(3, age);
				psmtUpdate.setString(4, grade);
				psmtUpdate.setString(5, jobTitle);
				psmtUpdate.setInt(6, savedMoney);
				
				psmtUpdate.executeUpdate();

				System.out.println(customerId + "의 정보가 생성 되었습니다.");
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		} finally {
			try {
				// ResultSet를 닫는다.
				if (rs != null) rs.close();
				// Statement를 닫는다.
				if (psmtQuery != null) psmtQuery.close();
				if (psmtUpdate != null) psmtUpdate.close();
				// Connection를 닫는다.
				if (conn != null) conn.close();
			} catch ( SQLException e ) {}
		}
	}
}