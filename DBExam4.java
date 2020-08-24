import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBExam4 {
	public static void main(String[] args) {
		String sql = "SELECT * FROM products WHERE product_id = ? OR product_name = ?";

		try {
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://localhost:5432/dbconnection";
			String username = "axizuser";
			String password = "axiz";

			try (
					Connection con = DriverManager.getConnection(url, username, password);
					PreparedStatement stmt = con.prepareStatement(sql);) {
				stmt.setInt(1, 101);
				stmt.setString(2, "地球儀");

				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					int id = rs.getInt("product_id");
					String name = rs.getString("product_name");
					int price = rs.getInt("price");

					System.out.println(String.format("product_id:%d, product_name:%s, price:%d", id, name, price));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
