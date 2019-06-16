package pl.sda.kubik.servlet.servlets;

import pl.sda.kubik.servlet.dao.ProductDb;
import pl.sda.kubik.servlet.domain.CurrencyUtil;
import pl.sda.kubik.servlet.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/homepage")
public class HomePageServlet extends HttpServlet {
    private static final long serialVersionUID = 4213720041139684344L;
    private ProductDb db;


    @Override
    public void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {

        // httpServletRequest.setAttribute("products", db.getAllProducts());
        // wszystko musi byc przed .forward

        final String category = httpServletRequest.getParameter("category");
        final String locale = (String) httpServletRequest.getSession().getAttribute("locale");
        List<Product> productList = this.db.getAllProducts();


        if (category != null) {
            productList = productList.stream()
                    .filter(x -> x.getCategories().contains(category))
                    .collect(Collectors.toList());
        }

        final double rate = CurrencyUtil.reCalc(locale);
        final List<Product> recalcProducts = productList.stream().map(product -> {
            return new Product(product.getId(), product.getName(), product.getDescription(), product.getPrice() * rate, product.getImage(), product.getCategories());
        }).collect(Collectors.toList());
        httpServletRequest.setAttribute("products", recalcProducts);
        httpServletRequest.getRequestDispatcher("/homepage.jsp").forward(httpServletRequest, httpServletResponse);

    }

    @Override
    public void init() throws ServletException {
        this.db = ProductDb.getInstance();
        super.init();
    }
}
