package jp.co.axiz.web.service;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import jp.co.axiz.web.dao.RoleDao;
import jp.co.axiz.web.entity.Role;
import jp.co.axiz.web.util.DbUtil;

public class RoleService {
	public List<Role> findAll() {
		try (Connection conn = DbUtil.getConnection()) {
			RoleDao roleDao = new RoleDao(conn);
			return roleDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	public Role findById(Integer id) {
		try (Connection conn = DbUtil.getConnection()) {
			RoleDao roleDao = new RoleDao(conn);
			return roleDao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
