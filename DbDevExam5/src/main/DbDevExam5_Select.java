package main;

import java.sql.Connection;

import dao.ProductDao;
import entity.Product;
import util.DbUtil;

public class DbDevExam5_Select {
	public static void main(String[] args) {
		Connection con = DbUtil.getConnection();
		ProductDao productDao = new ProductDao(con);

		int productId = 102;
		Product product = productDao.findByProductId(productId);

		System.out.println(product);
	}
}
