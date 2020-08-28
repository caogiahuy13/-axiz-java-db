package jp.co.axiz.web.service;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import jp.co.axiz.web.dao.UserDao;
import jp.co.axiz.web.entity.User;
import jp.co.axiz.web.util.DbUtil;

public class UserService {
	public User authenticate(String loginId, String password) {
		try (Connection conn = DbUtil.getConnection()) {
			UserDao userDao = new UserDao(conn);
			return userDao.findByLoginIdAndPassword(loginId, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<User> find(User user) {
		try (Connection conn = DbUtil.getConnection()) {
			UserDao userDao = new UserDao(conn);
			return userDao.find(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	public User findByLoginId(String loginId) {
		try (Connection conn = DbUtil.getConnection()) {
			UserDao userDao = new UserDao(conn);
			return userDao.findByLoginId(loginId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public int insert(User user) {
		try (Connection conn = DbUtil.getConnection()) {
			UserDao userDao = new UserDao(conn);
			return userDao.insert(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}
}
