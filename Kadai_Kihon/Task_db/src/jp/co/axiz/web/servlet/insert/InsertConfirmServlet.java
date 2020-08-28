package jp.co.axiz.web.servlet.insert;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.axiz.web.entity.Role;
import jp.co.axiz.web.entity.User;
import jp.co.axiz.web.service.RoleService;
import jp.co.axiz.web.service.UserService;
import jp.co.axiz.web.util.ParamUtil;

/**
 * Servlet implementation class InsertConfirmServlet
 */
@WebServlet({ "/InsertConfirmServlet", "/insertConfirm" })
public class InsertConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertConfirmServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

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

		UserService userService = new UserService();
		User user = userService.findByLoginId(loginId);

		if (user != null) {
			request.setAttribute("msg", "IDが重複しています");
			request.getRequestDispatcher("insert.jsp").forward(request, response);
			return;
		}

		RoleService roleService = new RoleService();
		Role role = roleService.findById(Integer.parseInt(roleId));

		request.setAttribute("loginId", loginId);
		request.setAttribute("userName", userName);
		request.setAttribute("tel", tel);
		request.setAttribute("roleId", roleId);
		request.setAttribute("roleName", role.getRoleName());
		request.setAttribute("pass", pass);

		request.getRequestDispatcher("insertConfirm.jsp").forward(request, response);
	}

}
