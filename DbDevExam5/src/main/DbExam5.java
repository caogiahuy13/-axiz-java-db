package main;

import java.sql.Connection;
import java.util.List;

import dao.ProductDao;
import entity.Product;
import util.DbUtil;

public class DbExam5 {
	public static void main(String[] args) {
		Connection con = DbUtil.getConnection();
		ProductDao productDao = new ProductDao(con);
		Product product = new Product("ボールペン", 200);

		productDao.register(product);

		List<Product> products = productDao.findAll();

		products.forEach(p -> System.out.println(p));
	}
}
