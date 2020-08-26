package service;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import dao.ProductDao;
import entity.Product;
import util.DbUtil;

public class ProductService {
	public List<Product> find() {
		try (Connection conn = DbUtil.getConnection()) {
			ProductDao productDao = new ProductDao(conn);
			return productDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	public Product findById(int id) {
		try (Connection conn = DbUtil.getConnection()) {
			ProductDao productDao = new ProductDao(conn);
			return productDao.findByProductId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
