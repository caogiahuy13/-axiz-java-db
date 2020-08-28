package jp.co.axiz.web.servlet.update;

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
 * Servlet implementation class UpdateInputServlet
 */
@WebServlet({ "/UpdateInputServlet", "/updateInput" })
public class UpdateInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateInputServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("update.jsp").forward(request, response);
		return;
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
			request.getRequestDispatcher("update.jsp").forward(request, response);
			return;
		}

		UserService userService = new UserService();
		User user = userService.findByLoginId(loginId);

		if (user == null) {
			request.setAttribute("msg", "入力されたデータは存在しません");
			request.getRequestDispatcher("update.jsp").forward(request, response);
			return;
		}

		HttpSession session = request.getSession();
		session.setAttribute("curUpdateUser", user);

		request.getRequestDispatcher("updateInput.jsp").forward(request, response);
		return;
	}

}
