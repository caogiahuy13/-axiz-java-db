import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DbDevExam4_Insert {
	public static void main(String[] args) {
		String sql = "INSERT INTO products (product_name, price) VALUES (?, ?)";

		try {
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://localhost:5432/dbconnection";
			String user = "axizuser";
			String pass = "axiz";

			try (Connection con = DriverManager.getConnection(url, user, pass);
					PreparedStatement stmt = con.prepareStatement(sql)) {
				stmt.setString(1, "ボールペン");
				stmt.setInt(2, 200);

				if (stmt.executeUpdate() > 0) {
					System.out.println("登録しました");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
