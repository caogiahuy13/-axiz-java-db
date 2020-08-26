package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Book;
import util.ParamUtil;

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
		request.getRequestDispatcher("insert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String publisherStr = request.getParameter("publisher");
		String priceStr = request.getParameter("price");

		boolean isBlank = false;

		if (ParamUtil.isNullOrEmpty(name)) {
			request.setAttribute("errName", "書籍名は必須です");
			isBlank = true;
		}

		if (ParamUtil.isNullOrEmpty(publisherStr)) {
			request.setAttribute("errPublisher", "出版社IDは必須です");
			isBlank = true;
		}

		if (ParamUtil.isNullOrEmpty(priceStr)) {
			request.setAttribute("errPrice", "定価は必須です");
			isBlank = true;
		}

		if (isBlank) {
			request.getRequestDispatcher("insert.jsp").forward(request, response);
			return;
		}

		Book book = new Book(name, Integer.parseInt(publisherStr), Integer.parseInt(priceStr));

		request.setAttribute("book", book);
		request.getRequestDispatcher("insertConfirm.jsp").forward(request, response);
	}

}
