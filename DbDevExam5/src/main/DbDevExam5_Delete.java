package main;

import java.sql.Connection;
import java.util.List;

import dao.ProductDao;
import entity.Product;
import util.DbUtil;

public class DbDevExam5_Delete {
	public static void main(String[] args) {
		Connection con = DbUtil.getConnection();
		ProductDao productDao = new ProductDao(con);

		productDao.delete("ボールペン");

		List<Product> products = productDao.findAll();

		products.forEach(p -> System.out.println(p));
	}
}
