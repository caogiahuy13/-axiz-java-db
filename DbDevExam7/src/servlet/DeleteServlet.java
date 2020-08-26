package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductService;
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

		String idStr = request.getParameter("id");

		if (ParamUtil.isNullOrEmpty(idStr)) {
			request.setAttribute("idErr", "product_idは必須です");
			request.getRequestDispatcher("delete.jsp").forward(request, response);
			return;
		}

		if (!ParamUtil.isNumber(idStr)) {
			request.setAttribute("msg", "対象のデータはありません");
			request.getRequestDispatcher("delete.jsp").forward(request, response);
			return;
		}

		int id = Integer.parseInt(idStr);
		ProductService productService = new ProductService();
		if (productService.deleteById(id) > 0) {
			request.getRequestDispatcher("deleteResult.jsp").forward(request, response);
			return;
		} else {
			request.setAttribute("msg", "対象のデータはありません");
			request.getRequestDispatcher("delete.jsp").forward(request, response);
			return;
		}

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
