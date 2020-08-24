import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbDevExam4_SelectSum {
	public static void main(String[] args) {
		String sql = "SELECT price FROM products";

		try {
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://localhost:5432/dbconnection";
			String user = "axizuser";
			String pass = "axiz";

			try (Connection con = DriverManager.getConnection(url, user, pass);
					PreparedStatement stmt = con.prepareStatement(sql)) {
				ResultSet rs = stmt.executeQuery();

				int sum = 0;

				while (rs.next()) {
					sum += rs.getInt("price");
				}

				System.out.println(String.format("合計金額: %d", sum));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
