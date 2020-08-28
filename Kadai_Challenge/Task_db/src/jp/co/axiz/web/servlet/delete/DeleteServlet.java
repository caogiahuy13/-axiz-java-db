package jp.co.axiz.web.servlet.delete;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.axiz.web.entity.User;
import jp.co.axiz.web.service.UserService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet({ "/DeleteServlet", "/delete" })
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteServlet() {
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
			request.getRequestDispatcher("delete.jsp").forward(request, response);
			return;
		}

		String loginId = request.getParameter("loginId");

		UserService userService = new UserService();

		if (userService.deleteByLoginId(loginId) <= 0) {
			request.getRequestDispatcher("delete.jsp").forward(request, response);
			return;
		}

		HttpSession session = request.getSession();
		User curUser = (User) session.getAttribute("user");

		request.setAttribute("name", curUser.getUserName());
		request.getRequestDispatcher("deleteResult.jsp").forward(request, response);
		return;
	}

}
