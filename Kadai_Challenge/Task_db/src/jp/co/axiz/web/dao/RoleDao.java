package jp.co.axiz.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.axiz.web.entity.Role;

public class RoleDao {
	private static final String ROLE_ID = "role_id";
	private static final String ROLE_NAME = "role_name";

	private static final String SELECT = "SELECT * FROM role ";
	private static final String SELECT_WHERE = "SELECT * FROM role WHERE ";
	private static final String ORDER_BY = "ORDER BY role_id";

	private static final String SQL_SELECT_ALL = SELECT + ORDER_BY;
	private static final String SQL_SELECT_WHERE_ROLE_ID = SELECT_WHERE + "role_id = ? " + ORDER_BY;

	private Connection connection;

	public RoleDao(Connection connection) {
		this.connection = connection;
	}

	public List<Role> findAll() {
		List<Role> list = new ArrayList<Role>();
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				list.add(new Role(rs.getInt(ROLE_ID), rs.getString(ROLE_NAME)));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public Role findById(Integer id) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_WHERE_ROLE_ID)) {
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new Role(rs.getInt(ROLE_ID), rs.getString(ROLE_NAME));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return null;
	}
}
