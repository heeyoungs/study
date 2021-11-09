package customer;

import conf.Conf;
import java.sql.*;

public class Delete_Customer {
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement psmtQuery = null;
		PreparedStatement psmtUpdate = null;
		
		ResultSet rs = null;
		
		String customerId = "grape";		
		
		try {
			// 드라이버를 로딩한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 데이터베이스의 연결을 설정한다.
			conn = DriverManager.getConnection(Conf.DB_URL, Conf.DB_USER, Conf.DB_PASSWORD);

			// 고객 정보가 있는지 확인
			String query = "select customer_id from customer where customer_id = ?";
			psmtQuery = conn.prepareStatement(query);
			psmtQuery.setString(1, customerId);
			rs = psmtQuery.executeQuery();

			if (!rs.next()) {// 고객 정보가 존재하지 않으면
				System.out.println("에러 :고객 정보가 존재하지 않습니다.");
			}
			else {				
				String deleteStatement = "DELETE FROM customer WHERE customer_id = ?";
				
				psmtUpdate = conn.prepareStatement(deleteStatement);			
				psmtUpdate.setString(1, customerId);		
				
				psmtUpdate.executeUpdate();

				System.out.println(customerId + "의 정보가 삭제되었습니다.");
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