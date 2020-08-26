package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Book;
import service.BookService;

/**
 * Servlet implementation class InsertConfirmServlet
 */
@WebServlet({ "/InsertConfirmServlet", "/insertConfirm" })
public class InsertConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertConfirmServlet() {
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

		String btn = request.getParameter("btn");

		if (btn.equals("return")) {
			request.getRequestDispatcher("insert.jsp").forward(request, response);
			return;
		}

		String name = request.getParameter("name");
		int publisher = Integer.parseInt(request.getParameter("publisher"));
		int price = Integer.parseInt(request.getParameter("price"));

		BookService bookService = new BookService();
		Book newBook = new Book(name, publisher, price);

		if (bookService.insert(newBook) <= 0) {
			request.getRequestDispatcher("insert.jsp").forward(request, response);
			return;
		}

		request.getRequestDispatcher("insertResult.jsp").forward(request, response);
		return;
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
