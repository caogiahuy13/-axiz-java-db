package jp.co.axiz.web.servlet.update;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.axiz.web.entity.Role;
import jp.co.axiz.web.entity.User;
import jp.co.axiz.web.service.RoleService;
import jp.co.axiz.web.service.UserService;
import jp.co.axiz.web.util.ParamUtil;

/**
 * Servlet implementation class UpdateConfirmServlet
 */
@WebServlet({ "/UpdateConfirmServlet", "/updateConfirm" })
public class UpdateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateConfirmServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();

		String btn = request.getParameter("btn");

		if (btn.equals("return")) {
			String url = Arrays
					.stream(request.getHeader("Referer").split("/"))
					.reduce((first, second) -> second)
					.orElse(null);
			session.removeAttribute("curUpdateUser");
			response.sendRedirect(url);
			return;
		}

		String userId = request.getParameter("userId");
		String loginId = request.getParameter("loginId");
		String userName = request.getParameter("userName");
		String tel = request.getParameter("tel");
		String roleId = request.getParameter("roleId");
		String pass = request.getParameter("pass");

		boolean isBlank = false;

		if (ParamUtil.isNullOrEmpty(loginId)) {
			request.setAttribute("errId", "IDは必須です");
			isBlank = true;
		}
		if (ParamUtil.isNullOrEmpty(userName)) {
			request.setAttribute("errUserName", "名前は必須です");
			isBlank = true;
		}
		if (ParamUtil.isNullOrEmpty(tel)) {
			request.setAttribute("errTel", "TELは必須です");
			isBlank = true;
		}
		if (ParamUtil.isNullOrEmpty(pass)) {
			request.setAttribute("errPass", "PASSは必須です");
			isBlank = true;
		}

		if (isBlank) {
			request.getRequestDispatcher("insert.jsp").forward(request, response);
			return;
		}

		User curUpdateUser = (User) session.getAttribute("curUpdateUser");

		if (curUpdateUser.getLoginId().equals(loginId)
				&& curUpdateUser.getUserName().equals(userName)
				&& curUpdateUser.getTel().equals(tel)
				&& curUpdateUser.getRoleId() == Integer.parseInt(roleId)
				&& curUpdateUser.getPassword().equals(pass)) {
			request.setAttribute("msg", "１項目以上変更してください");
			request.getRequestDispatcher("updateInput.jsp").forward(request, response);
			return;
		}

		UserService userService = new UserService();
		User existedUser = userService.findByLoginId(loginId);

		if (existedUser != null && existedUser.getLoginId().equals(loginId)
				&& existedUser.getUserId() != Integer.parseInt(userId)) {
			request.setAttribute("msg", "IDが重複しています");
			request.getRequestDispatcher("updateInput.jsp").forward(request, response);
			return;
		}

		RoleService roleService = new RoleService();
		Role role = roleService.findById(Integer.parseInt(roleId));

		request.setAttribute("userId", userId);
		request.setAttribute("loginId", loginId);
		request.setAttribute("userName", userName);
		request.setAttribute("tel", tel);
		request.setAttribute("roleId", roleId);
		request.setAttribute("roleName", role.getRoleName());
		request.setAttribute("pass", pass);

		request.getRequestDispatcher("updateConfirm.jsp").forward(request, response);
	}

}
