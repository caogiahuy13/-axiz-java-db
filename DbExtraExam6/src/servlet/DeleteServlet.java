package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Book;
import service.BookService;
import util.ParamUtil;

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
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");

		if (ParamUtil.isNullOrEmpty(id)) {
			request.setAttribute("errId", "書籍IDは必須です");
			request.getRequestDispatcher("delete.jsp").forward(request, response);
			return;
		}

		if (!ParamUtil.isNumber(id)) {
			request.setAttribute("msg", "入力された書籍はありませんでした");
			request.getRequestDispatcher("delete.jsp").forward(request, response);
			return;
		}

		BookService bookService = new BookService();
		Book book = bookService.findById(Integer.parseInt(id));

		if (book == null) {
			request.setAttribute("msg", "入力された書籍はありませんでした");
			request.getRequestDispatcher("delete.jsp").forward(request, response);
			return;
		}

		request.setAttribute("book", book);
		request.getRequestDispatcher("deleteConfirm.jsp").forward(request, response);
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
