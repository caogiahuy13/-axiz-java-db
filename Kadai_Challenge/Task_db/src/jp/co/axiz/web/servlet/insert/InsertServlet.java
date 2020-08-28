package jp.co.axiz.web.servlet.insert;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.axiz.web.entity.User;
import jp.co.axiz.web.service.UserService;
import jp.co.axiz.web.util.ParamUtil;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet({ "/InsertServlet", "/insert" })
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertServlet() {
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

		String btn = request.getParameter("btn");

		if (btn.equals("return")) {
			request.getRequestDispatcher("insert.jsp").forward(request, response);
			return;
		}

		String loginId = request.getParameter("loginId");
		String userName = request.getParameter("userName");
		String tel = request.getParameter("tel");
		String roleId = request.getParameter("roleId");
		String roleName = request.getParameter("roleName");
		String pass = request.getParameter("pass");
		String rePass = request.getParameter("rePass");

		if (ParamUtil.isNullOrEmpty(rePass) || !pass.equals(rePass)) {
			request.setAttribute("msg", "前画面で入力したパスワードと一致しません");
			request.setAttribute("loginId", loginId);
			request.setAttribute("userName", userName);
			request.setAttribute("tel", tel);
			request.setAttribute("roleId", roleId);
			request.setAttribute("roleName", roleName);
			request.setAttribute("pass", pass);
			request.getRequestDispatcher("insertConfirm.jsp").forward(request, response);
			return;
		}

		UserService userService = new UserService();
		User user = User.builder()
				.loginId(loginId)
				.userName(userName)
				.tel(tel)
				.roleId(Integer.parseInt(roleId))
				.password(pass)
				.build();

		if (userService.insert(user) <= 0) {
			request.getRequestDispatcher("insert.jsp").forward(request, response);
			return;
		}

		HttpSession session = request.getSession();
		User curUser = (User) session.getAttribute("user");

		request.setAttribute("name", curUser.getUserName());
		request.getRequestDispatcher("insertResult.jsp").forward(request, response);
		return;
	}

}
