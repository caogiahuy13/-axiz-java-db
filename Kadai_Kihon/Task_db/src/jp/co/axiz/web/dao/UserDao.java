package jp.co.axiz.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.axiz.web.entity.User;
import jp.co.axiz.web.util.ParamUtil;

public class UserDao {
	private static final String USER_ID = "user_id";
	private static final String LOGIN_ID = "login_id";
	private static final String USER_NAME = "user_name";
	private static final String TELEPHONE = "telephone";
	private static final String PASSWORD = "password";
	private static final String ROLE_ID = "role_id";
	private static final String ROLE_NAME = "role_name";

	private static final String SELECT = "SELECT * FROM user_info ";
	private static final String INSERT = "INSERT INTO user_info (login_id, user_name, telephone, password, role_id) VALUES (?, ?, ?, ?, ?)";
	private static final String SELECT_JOIN_ROLE = "SELECT * FROM user_info JOIN role ON user_info.role_id = role.role_id ";
	private static final String SELECT_WHERE = "SELECT * FROM user_info WHERE ";
	private static final String ORDER_BY = "ORDER BY user_id ";

	private static final String SQL_SELECT_WHERE_LOGIN_ID_AND_PASSWORD = SELECT + "WHERE login_id = ? AND password = ? "
			+ ORDER_BY;
	private static final String SQL_SELECT_WHERE_LOGIN_ID = SELECT + "WHERE login_id = ? " + ORDER_BY;

	private Connection connection;

	public UserDao(Connection connection) {
		this.connection = connection;
	}

	public User findByLoginIdAndPassword(String loginId, String password) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_WHERE_LOGIN_ID_AND_PASSWORD)) {
			stmt.setString(1, loginId);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return User.builder()
						.userId(rs.getInt(USER_ID))
						.loginId(rs.getString(LOGIN_ID))
						.userName(rs.getString(USER_NAME))
						.tel(rs.getString(TELEPHONE))
						.password(rs.getString(PASSWORD))
						.roleId(rs.getInt(ROLE_ID))
						.build();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return null;
	}

	public User findByLoginId(String loginId) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_WHERE_LOGIN_ID)) {
			stmt.setString(1, loginId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return User.builder()
						.userId(rs.getInt(USER_ID))
						.loginId(rs.getString(LOGIN_ID))
						.userName(rs.getString(USER_NAME))
						.tel(rs.getString(TELEPHONE))
						.password(rs.getString(PASSWORD))
						.roleId(rs.getInt(ROLE_ID))
						.build();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return null;
	}

	public List<User> findAll() {
		List<User> list = new ArrayList<>();

		try (PreparedStatement stmt = connection.prepareStatement(SELECT_JOIN_ROLE + ORDER_BY)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				User user = User.builder()
						.userId(rs.getInt(USER_ID))
						.loginId(rs.getString(LOGIN_ID))
						.userName(rs.getString(USER_NAME))
						.tel(rs.getString(TELEPHONE))
						.password(rs.getString(PASSWORD))
						.roleName(rs.getString(ROLE_NAME))
						.build();
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<User> find(User user) {
		ArrayList<String> conditionList = new ArrayList<>();
		ArrayList<Object> paramList = new ArrayList<>();

		String userName = null;
		String tel = null;

		if (user != null) {
			userName = user.getUserName();
			tel = user.getTel();
		}

		if (ParamUtil.isNullOrEmpty(userName) && ParamUtil.isNullOrEmpty(tel)) {
			return findAll();
		}

		if (!ParamUtil.isNullOrEmpty(userName)) {
			conditionList.add(USER_NAME + " = ?");
			paramList.add(userName); //
		}

		if (!ParamUtil.isNullOrEmpty(tel)) {
			conditionList.add(TELEPHONE + " = ?");
			paramList.add(tel);
		}

		String whereString = String.join(" AND ", conditionList.toArray(new String[] {}));

		List<User> list = new ArrayList<>();

		String sql = SELECT_JOIN_ROLE + "WHERE " + whereString + ORDER_BY;

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			for (int i = 0; i < paramList.size(); i++) {
				stmt.setObject(i + 1, paramList.get(i));
			}

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				User u = User.builder()
						.userId(rs.getInt(USER_ID))
						.loginId(rs.getString(LOGIN_ID))
						.userName(rs.getString(USER_NAME))
						.tel(rs.getString(TELEPHONE))
						.password(rs.getString(PASSWORD))
						.roleId(rs.getInt(ROLE_ID))
						.roleName(rs.getString(ROLE_NAME))
						.build();
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public int insert(User user) {
		try (PreparedStatement stmt = connection.prepareStatement(INSERT)) {
			stmt.setString(1, user.getLoginId());
			stmt.setString(2, user.getUserName());
			stmt.setString(3, user.getTel());
			stmt.setString(4, user.getPassword());
			stmt.setInt(5, user.getRoleId());
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}
}
