package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Book;

public class BookDao {
	private static final String SQL_SELECT_ALL = "SELECT * FROM books ORDER BY book_id";
	private static final String SQL_SELECT_BOOK_NAME = "SELECT * FROM books WHERE book_name = ? ORDER BY book_id";
	private static final String SQL_SELECT_BOOK_ID = "SELECT * FROM books WHERE book_id = ? ORDER BY book_id";
	private static final String SQL_INSERT = "INSERT INTO books(book_name, publisher, price) VALUES (?, ?, ?)";
	private static final String SQL_DELETE_BOOK_ID = "DELETE FROM books WHERE book_id = ?";

	private Connection connection;

	public BookDao(Connection connection) {
		this.connection = connection;
	}

	public List<Book> findAll() {
		List<Book> list = new ArrayList<Book>();

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				list.add(new Book(rs.getInt("book_id"), rs.getString("book_name"), rs.getInt("publisher"),
						rs.getInt("price")));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public List<Book> findByBookName(String name) {
		List<Book> list = new ArrayList<Book>();

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_BOOK_NAME)) {
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				list.add(new Book(rs.getInt("book_id"), rs.getString("book_name"), rs.getInt("publisher"),
						rs.getInt("price")));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public Book findByBookId(int id) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_BOOK_ID)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				return new Book(rs.getInt("book_id"), rs.getString("book_name"), rs.getInt("publisher"),
						rs.getInt("price"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return null;
	}

	public int insert(Book book) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)) {
			stmt.setString(1, book.getBookName());
			stmt.setInt(2, book.getPublisher());
			stmt.setInt(3, book.getPrice());

			return stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int delete(int id) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_DELETE_BOOK_ID)) {
			stmt.setInt(1, id);

			return stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
