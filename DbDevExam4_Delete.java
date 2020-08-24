import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DbDevExam4_Delete {
	public static void main(String[] args) {
		String sql = "DELETE FROM products WHERE product_name = ?";

		try {
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://localhost:5432/dbconnection";
			String user = "axizuser";
			String pass = "axiz";

			try (Connection con = DriverManager.getConnection(url, user, pass);
					PreparedStatement stmt = con.prepareStatement(sql)) {
				stmt.setString(1, "ボールペン");

				if (stmt.executeUpdate() > 0) {
					System.out.println("削除しました");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
