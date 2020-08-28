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
import jp.co.axiz.web.util.ParamUtil;

/**
 * Servlet implementation class DeleteConfirmServlet
 */
@WebServlet({ "/DeleteConfirmServlet", "/deleteConfirm" })
public class DeleteConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteConfirmServlet() {
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

		String loginId = request.getParameter("loginId");

		if (ParamUtil.isNullOrEmpty(loginId)) {
			request.setAttribute("errId", "IDは必須です");
			request.getRequestDispatcher("delete.jsp").forward(request, response);
			return;
		}

		HttpSession session = request.getSession();
		User curUser = (User) session.getAttribute("user");

		if (curUser.getLoginId().equals(loginId)) {
			request.setAttribute("msg", "ログインユーザは削除できません");
			request.getRequestDispatcher("delete.jsp").forward(request, response);
			return;
		}

		UserService userService = new UserService();
		User user = userService.findByLoginId(loginId);

		if (user == null) {
			request.setAttribute("msg", "入力されたデータは存在しません");
			request.getRequestDispatcher("delete.jsp").forward(request, response);
			return;
		}

		request.setAttribute("user", user);
		request.getRequestDispatcher("deleteConfirm.jsp").forward(request, response);
		return;
	}

}
