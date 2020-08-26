package service;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import dao.BookDao;
import entity.Book;
import util.DbUtil;

public class BookService {
	public List<Book> findAll() {
		try (Connection conn = DbUtil.getConnection()) {
			BookDao bookDao = new BookDao(conn);
			return bookDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	public List<Book> findByName(String name) {
		try (Connection conn = DbUtil.getConnection()) {
			BookDao bookDao = new BookDao(conn);
			return bookDao.findByBookName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	public Book findById(int id) {
		try (Connection conn = DbUtil.getConnection()) {
			BookDao bookDao = new BookDao(conn);
			return bookDao.findByBookId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public int insert(Book book) {
		try (Connection conn = DbUtil.getConnection()) {
			BookDao bookDao = new BookDao(conn);
			return bookDao.insert(book);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(int id) {
		try (Connection conn = DbUtil.getConnection()) {
			BookDao bookDao = new BookDao(conn);
			return bookDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
