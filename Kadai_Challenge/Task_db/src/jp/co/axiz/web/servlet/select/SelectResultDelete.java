package jp.co.axiz.web.servlet.select;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.axiz.web.entity.User;
import jp.co.axiz.web.service.UserService;

/**
 * Servlet implementation class SelectResultDelete
 */
@WebServlet({ "/SelectResultDelete", "/selectResultDelete" })
public class SelectResultDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectResultDelete() {
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
			request.getRequestDispatcher("selectResult.jsp").forward(request, response);
			return;
		}

		HttpSession session = request.getSession();
		List<User> users = (List<User>) session.getAttribute("usersToDelete");
		User curUser = (User) session.getAttribute("user");

		UserService userService = new UserService();

		users.forEach(u -> userService.deleteByLoginId(u.getLoginId()));

		session.removeAttribute("usersToDelete");
		session.removeAttribute("selectResult");
		request.setAttribute("name", curUser.getUserName());
		request.getRequestDispatcher("deleteResult.jsp").forward(request, response);
		return;
	}

}
