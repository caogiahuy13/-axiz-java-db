import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DbDevExam4_Update {
	public static void main(String[] args) {
		String sql = "UPDATE products SET price = ? WHERE product_id = ?";

		try {
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://localhost:5432/dbconnection";
			String user = "axizuser";
			String pass = "axiz";

			try (Connection con = DriverManager.getConnection(url, user, pass);
					PreparedStatement stmt = con.prepareStatement(sql)) {
				stmt.setInt(1, 60);
				stmt.setInt(2, 101);

				if (stmt.executeUpdate() > 0) {
					System.out.println("更新しました");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
