import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbDevExam4_Select {
	public static void main(String[] args) {
		String sql = "SELECT * FROM products";

		try {
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://localhost:5432/dbconnection";
			String user = "axizuser";
			String pass = "axiz";

			try (Connection con = DriverManager.getConnection(url, user, pass);
					PreparedStatement stmt = con.prepareStatement(sql)) {
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					int id = rs.getInt("product_id");
					String name = rs.getString("product_name");
					int price = rs.getInt("price");

					String output = String.format("product_id:%d, product_name:%s, price:%d", id, name, price);
					System.out.println(output);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
