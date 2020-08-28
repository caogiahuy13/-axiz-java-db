package jp.co.axiz.web.servlet;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class LoginServlet
 */
@WebServlet({ "/LoginServlet", "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		request.setCharacterEncoding("UTF8");

		String loginId = request.getParameter("loginId");
		String pass = request.getParameter("pass");
		boolean isBlank = false;

		if (ParamUtil.isNullOrEmpty(loginId)) {
			request.setAttribute("errId", "IDは必須です");
			isBlank = true;
		}

		if (ParamUtil.isNullOrEmpty(pass)) {
			request.setAttribute("errPass", "PASSは必須です");
			isBlank = true;
		}

		if (isBlank) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		UserService userService = new UserService();
		User user = userService.authenticate(loginId, pass);

		if (user == null) {
			request.setAttribute("msg", "IDまたはPASSが間違っています");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		RoleService roleService = new RoleService();
		List<Role> roles = roleService.findAll();

		HttpSession session = request.getSession();
		session.setAttribute("roles", roles);
		session.setAttribute("user", user);

		request.getRequestDispatcher("menu.jsp").forward(request, response);
	}

}
