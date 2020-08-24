package main;

import java.sql.Connection;

import dao.ProductDao;
import entity.Product;
import util.DbUtil;

public class DbDevExam5_Update {
	public static void main(String[] args) {
		Connection con = DbUtil.getConnection();
		ProductDao productDao = new ProductDao(con);

		int productId = 101;
		Product product = productDao.findByProductId(productId);
		System.out.println("【更新前】");
		System.out.println(product);

		product.setProductName("シャープペンシル");
		product.setPrice(70);
		productDao.update(product);
		product = productDao.findByProductId(productId);
		System.out.println("【更新後】");
		System.out.println(product);
	}
}
