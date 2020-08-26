package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Product;
import service.ProductService;
import util.ParamUtil;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet({ "/UpdateServlet", "/update" })
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateServlet() {
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
		String name = request.getParameter("name");
		String priceStr = request.getParameter("price");
		boolean isBlank = false;

		if (ParamUtil.isNullOrEmpty(idStr)) {
			request.setAttribute("idErr", "product_idは必須です");
			isBlank = true;
		}

		if (ParamUtil.isNullOrEmpty(name)) {
			request.setAttribute("nameErr", "product_nameは必須です");
			isBlank = true;
		}

		if (ParamUtil.isNullOrEmpty(priceStr)) {
			request.setAttribute("priceErr", "priceは必須です");
			isBlank = true;
		}

		if (isBlank) {
			request.getRequestDispatcher("update.jsp").forward(request, response);
			return;
		}

		if (!ParamUtil.isNumber(idStr) || !ParamUtil.isNumber(priceStr)) {
			request.setAttribute("msg", "対象のデータはありません");
			request.getRequestDispatcher("update.jsp").forward(request, response);
			return;
		}

		int id = Integer.parseInt(idStr);
		int price = Integer.parseInt(priceStr);

		ProductService productService = new ProductService();
		Product oldProduct = productService.findById(id);
		Product newProduct = new Product(id, name, price);

		if (oldProduct == null || productService.update(newProduct) <= 0) {
			request.setAttribute("msg", "対象のデータはありません");
			request.getRequestDispatcher("update.jsp").forward(request, response);
			return;
		}

		request.setAttribute("oldProduct", oldProduct);
		request.setAttribute("newProduct", newProduct);
		request.getRequestDispatcher("updateResult.jsp").forward(request, response);
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
