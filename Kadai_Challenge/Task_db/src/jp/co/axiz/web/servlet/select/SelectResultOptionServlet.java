package jp.co.axiz.web.servlet.select;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class SelectResultOptionServlet
 */
@WebServlet({ "/SelectResultOptionServlet", "/selectResultOption" })
public class SelectResultOptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectResultOptionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("selectResult.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String btn = request.getParameter("btn");

		if (btn.equals("update")) {
			update(request, response);
		}

		if (btn.equals("delete")) {
			delete(request, response);
		}

		return;
	}

	public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checkboxes[] = request.getParameterValues("checkboxes");

		if (checkboxes == null || checkboxes.length == 0) {
			request.setAttribute("msg", "編集する対象を選択してください");
			request.getRequestDispatcher("selectResult.jsp").forward(request, response);
			return;
		}

		if (checkboxes.length > 1) {
			request.setAttribute("msg", "編集する場合は、1つのみ選択可能です");
			request.getRequestDispatcher("selectResult.jsp").forward(request, response);
			return;
		}

		UserService userService = new UserService();
		User user = userService.findByLoginId(checkboxes[0]);

		HttpSession session = request.getSession();
		session.setAttribute("curUpdateUser", user);

		request.setAttribute("user", user);
		request.getRequestDispatcher("updateInput.jsp").forward(request, response);
		return;
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String checkboxes[] = request.getParameterValues("checkboxes");

		if (checkboxes == null || checkboxes.length == 0) {
			request.setAttribute("msg", "削除する対象を選択してください");
			request.getRequestDispatcher("selectResult.jsp").forward(request, response);
			return;
		}

		HttpSession session = request.getSession();
		UserService userService = new UserService();
		User curUser = (User) session.getAttribute("user");
		List<User> users = new ArrayList<>();

		for (String loginId : checkboxes) {
			if (loginId.equals(curUser.getLoginId())) {
				request.setAttribute("msg", "ログインユーザは削除できません");
				request.getRequestDispatcher("selectResult.jsp").forward(request, response);
				return;
			}

			users.add(userService.findByLoginId(loginId));
		}

		session.setAttribute("usersToDelete", users);

		request.getRequestDispatcher("selectResultDelete.jsp").forward(request, response);
		return;
	}
}
