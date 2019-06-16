package pl.sda.kubik.servlet.servlets;

import pl.sda.kubik.servlet.dao.OrderDb;
import pl.sda.kubik.servlet.domain.Order;
import pl.sda.kubik.servlet.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/orders")

public class OrdersServlet extends HttpServlet {
    private static final long serialVersionUID = -3647412328394385570L;
    private OrderDb orderDb;

    @Override
    protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {

        final User user = (User) httpServletRequest.getSession().getAttribute("loggedUser");
        if (user != null) {
            final List<Order> orderForUser = this.orderDb.getOrderForUser(user);
            httpServletRequest.setAttribute("orders", orderForUser);
            httpServletRequest.setAttribute("cart", null);
            httpServletRequest.getRequestDispatcher("orders.jsp").forward(httpServletRequest, httpServletResponse);
        } else {
            httpServletRequest.setAttribute("cart", null);
            httpServletRequest.getRequestDispatcher("orders.jsp").forward(httpServletRequest, httpServletResponse);
        }


    }

    @Override
    public void init() throws ServletException {
        this.orderDb = OrderDb.getInstance();
        super.init();
    }
}
