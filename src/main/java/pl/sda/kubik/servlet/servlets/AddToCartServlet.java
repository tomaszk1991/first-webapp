package pl.sda.kubik.servlet.servlets;


import pl.sda.kubik.servlet.dao.ProductDb;
import pl.sda.kubik.servlet.domain.Cart;
import pl.sda.kubik.servlet.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


@WebServlet(urlPatterns = "/addToCart")

public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = -1491133344499640269L;
    private ProductDb db;


    @Override
    protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {


        httpServletRequest.getRequestDispatcher("cart.jsp").forward(httpServletRequest, httpServletResponse);

    }

    @Override
    public void doPost(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {

        final Long id = Long.valueOf(httpServletRequest.getParameter("id"));
        final int qt = Integer.valueOf(httpServletRequest.getParameter("qt"));

        final Optional<Product> product = this.db.getProductByID(id);

        Cart cart = (Cart) httpServletRequest.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }
        if (product.isPresent()) {

            cart.update(product.get(), qt);
            httpServletRequest.getSession().setAttribute("cart", cart);

        }


        httpServletRequest.getRequestDispatcher("/cart.jsp").forward(httpServletRequest, httpServletResponse);

    }

    @Override
    public void init() throws ServletException {
        this.db = ProductDb.getInstance();


        super.init();
    }
}
