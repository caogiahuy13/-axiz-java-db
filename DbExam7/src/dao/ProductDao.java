package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Product;

public class ProductDao {

	private static final String SQL_SELECT_ALL = "SELECT * FROM products ORDER BY product_id";
	private static final String SQL_SELECT_WHERE_PRODUCT_ID = "SELECT * FROM products WHERE product_id = ? ORDER BY product_id";
	private static final String SQL_SELECT_WHERE_PRODUCT_NAME = "SELECT * FROM products WHERE product_name = ? ORDER BY product_id";
	private static final String SQL_SELECT_WHERE_PRICE = "SELECT * FROM products WHERE price = ? ORDER BY product_id";
	private static final String SQL_SELECT_WHERE_PRODUCT_NAME_AND_PRICE = "SELECT * FROM products WHERE product_name = ? AND price = ? ORDER BY product_id";
	private static final String SQL_INSERT = "INSERT INTO products (product_name, price) VALUES (?, ?)";
	private static final String SQL_UPDATE = "UPDATE products SET product_name = ?, price = ? WHERE product_id = ?";
	private static final String SQL_DELETE_WHERE_PRODUCT_NAME = "DELETE FROM products WHERE product_name = ?";

	private Connection connection;

	public ProductDao(Connection connection) {
		this.connection = connection;
	}

	public List<Product> findAll() {
		List<Product> list = new ArrayList<Product>();

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Product p = new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
				list.add(p);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public void register(Product product) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)) {
			stmt.setString(1, product.getProductName());
			stmt.setInt(2, product.getPrice());

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Product findByProductId(int productId) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_WHERE_PRODUCT_ID)) {
			stmt.setInt(1, productId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return null;
	}

	public List<Product> findByProductName(String productName) {
		List<Product> list = new ArrayList<Product>();

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_WHERE_PRODUCT_NAME)) {
			stmt.setString(1, productName);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price")));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public List<Product> findByPrice(int price) {
		List<Product> list = new ArrayList<Product>();

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_WHERE_PRICE)) {
			stmt.setInt(1, price);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price")));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public List<Product> findByProductNameAndPrice(String productName, int price) {
		List<Product> list = new ArrayList<Product>();

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_WHERE_PRODUCT_NAME_AND_PRICE)) {
			stmt.setString(1, productName);
			stmt.setInt(2, price);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price")));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public void update(Product product) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE)) {
			stmt.setString(1, product.getProductName());
			stmt.setInt(2, product.getPrice());
			stmt.setInt(3, product.getProductId());

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(String productName) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_DELETE_WHERE_PRODUCT_NAME)) {
			stmt.setString(1, productName);

			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
