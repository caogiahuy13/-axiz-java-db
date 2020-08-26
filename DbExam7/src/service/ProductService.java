package service;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import dao.ProductDao;
import entity.Product;
import util.DbUtil;

public class ProductService {
	public List<Product> findAll() {
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

	public List<Product> findByName(String name) {
		try (Connection conn = DbUtil.getConnection()) {
			ProductDao productDao = new ProductDao(conn);
			return productDao.findByProductName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	public List<Product> findByPrice(int price) {
		try (Connection conn = DbUtil.getConnection()) {
			ProductDao productDao = new ProductDao(conn);
			return productDao.findByPrice(price);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	public List<Product> findByNameAndPrice(String name, int price) {
		try (Connection conn = DbUtil.getConnection()) {
			ProductDao productDao = new ProductDao(conn);
			return productDao.findByProductNameAndPrice(name, price);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	public void register(Product product) {
		try (Connection conn = DbUtil.getConnection()) {
			ProductDao productDao = new ProductDao(conn);
			productDao.register(product);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return;
	}
}
