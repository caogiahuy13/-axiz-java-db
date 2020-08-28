package jp.co.axiz.web.entity;

import java.util.Date;

public class User {
	private Integer userId;
	private String loginId;
	private String userName;
	private String tel;
	private String password;
	private Integer roleId;
	private String roleName;
	private Date createDateTime;
	private Date updateDateTime;

	public User() {

	}

	public User(Integer userId, String loginId, String userName, String tel, String password, Integer roleId,
			String roleName) {
		this.userId = userId;
		this.loginId = loginId;
		this.userName = userName;
		this.tel = tel;
		this.password = password;
		this.roleId = roleId;
		this.roleName = roleName;
	}

	private User(Builder builder) {
		this.userId = builder.userId;
		this.loginId = builder.loginId;
		this.userName = builder.userName;
		this.tel = builder.tel;
		this.password = builder.password;
		this.roleId = builder.roleId;
		this.roleName = builder.roleName;
		this.createDateTime = builder.createDateTime;
		this.updateDateTime = builder.updateDateTime;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private Integer userId;
		private String loginId;
		private String userName;
		private String tel;
		private String password;
		private Integer roleId;
		private String roleName;
		private Date createDateTime;
		private Date updateDateTime;

		private Builder() {
		}

		public Builder userId(Integer userId) {
			this.userId = userId;
			return this;
		}

		public Builder loginId(String loginId) {
			this.loginId = loginId;
			return this;
		}

		public Builder userName(String userName) {
			this.userName = userName;
			return this;
		}

		public Builder tel(String tel) {
			this.tel = tel;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public Builder roleId(Integer roleId) {
			this.roleId = roleId;
			return this;
		}

		public Builder roleName(String roleName) {
			this.roleName = roleName;
			return this;
		}

		public Builder createDateTime(Date createDateTime) {
			this.createDateTime = createDateTime;
			return this;
		}

		public Builder updateDateTime(Date updateDateTime) {
			this.updateDateTime = updateDateTime;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

}
