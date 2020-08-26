package servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Product;
import service.ProductService;
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

		String btn = request.getParameter("btn");

		if (btn.equals("search")) {
			search(request, response);
		} else if (btn.equals("register")) {
			register(request, response);
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

	public void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String priceStr = request.getParameter("price");

		ProductService productService = new ProductService();
		List<Product> products = Collections.emptyList();

		if (ParamUtil.isNullOrEmpty(name) && ParamUtil.isNullOrEmpty(priceStr)) {
			products = productService.findAll();
		}

		if (!ParamUtil.isNullOrEmpty(name) && ParamUtil.isNullOrEmpty(priceStr)) {
			products = productService.findByName(name);
		}

		if (ParamUtil.isNullOrEmpty(name) && !ParamUtil.isNullOrEmpty(priceStr)) {
			Integer price = ParamUtil.checkAndParseInt(priceStr);
			if (price != null) {
				products = productService.findByPrice(price);
			}
		}

		if (!ParamUtil.isNullOrEmpty(name) && !ParamUtil.isNullOrEmpty(priceStr)) {
			Integer price = ParamUtil.checkAndParseInt(priceStr);
			if (price != null) {
				products = productService.findByNameAndPrice(name, price);
			}
		}

		if (products.isEmpty()) {
			request.setAttribute("msg", "対象のデータはありません");
			request.getRequestDispatcher("top.jsp").forward(request, response);
			return;
		}

		request.setAttribute("products", products);
		request.getRequestDispatcher("searchResult.jsp").forward(request, response);
		return;
	}

	public void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String priceStr = request.getParameter("price");
		boolean isInputEmpty = false;

		if (ParamUtil.isNullOrEmpty(name)) {
			request.setAttribute("nameErr", "product_nameは必須です");
			isInputEmpty = true;
		}

		if (ParamUtil.isNullOrEmpty(priceStr) || !ParamUtil.isNumber(priceStr)) {
			request.setAttribute("priceErr", "priceは必須です");
			isInputEmpty = true;
		}

		if (isInputEmpty) {
			request.getRequestDispatcher("top.jsp").forward(request, response);
			return;
		}

		ProductService productService = new ProductService();
		productService.register(new Product(name, Integer.parseInt(priceStr)));

		request.getRequestDispatcher("insertResult.jsp").forward(request, response);
		return;
	}

}
