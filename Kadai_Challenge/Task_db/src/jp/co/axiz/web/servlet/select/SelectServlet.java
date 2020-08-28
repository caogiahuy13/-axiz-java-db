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
import jp.co.axiz.web.util.ParamUtil;

/**
 * Servlet implementation class SelectServlet
 */
@WebServlet({ "/SelectServlet", "/select" })
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String userName = request.getParameter("userName");
		String tel = request.getParameter("tel");

		User user = new User();
		user.setUserName(ParamUtil.isNullOrEmpty(userName) ? null : userName);
		user.setTel(ParamUtil.isNullOrEmpty(tel) ? null : tel);

		UserService userService = new UserService();
		List<User> users = userService.find(user);

		if (users.isEmpty()) {
			request.setAttribute("msg", "入力されたデータはありませんでした");
			request.getRequestDispatcher("select.jsp").forward(request, response);
			return;
		}

		HttpSession session = request.getSession();
		session.setAttribute("selectResult", users);
		request.getRequestDispatcher("selectResult.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
