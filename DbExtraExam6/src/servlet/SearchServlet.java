package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Book;
import service.BookService;
import util.ParamUtil;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet({ "/SearchServlet", "/search" })
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
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

		String name = request.getParameter("name");

		if (ParamUtil.isNullOrEmpty(name)) {
			request.setAttribute("msg", "書籍名入力してください");
			request.getRequestDispatcher("select.jsp").forward(request, response);
			return;
		}

		BookService bookService = new BookService();
		List<Book> books = bookService.findByName(name);

		if (books.isEmpty()) {
			request.setAttribute("msg", "入力された書籍はありませんでした");
			request.getRequestDispatcher("select.jsp").forward(request, response);
			return;
		}

		request.setAttribute("books", books);
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
