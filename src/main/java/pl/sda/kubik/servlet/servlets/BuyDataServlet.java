package pl.sda.kubik.servlet.servlets;

import pl.sda.kubik.servlet.dao.OrderDb;
import pl.sda.kubik.servlet.domain.Adress;
import pl.sda.kubik.servlet.domain.Cart;
import pl.sda.kubik.servlet.domain.Order;
import pl.sda.kubik.servlet.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/buyData")
public class BuyDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1118430318878884989L;
    private OrderDb orderDb;


    @Override
    protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/buyData.jsp").forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {

        final Adress orderAdress;
        final String adress = httpServletRequest.getParameter("adress");
        final String homeNumber = httpServletRequest.getParameter("homeNumber");
        final String buildingNumber = httpServletRequest.getParameter("buildingNumber");
        final String city = httpServletRequest.getParameter("city");

        final String login = httpServletRequest.getParameter("login");
        final String password = httpServletRequest.getParameter("password");
        final String email = httpServletRequest.getParameter("email");
        User loggedUser = (User) httpServletRequest.getSession().getAttribute("loggedUser");
        final Cart cart = (Cart) httpServletRequest.getSession().getAttribute("cart");
        final String locale = (String) httpServletRequest.getSession().getAttribute("locale");


        if (adress != null && homeNumber != null && buildingNumber != null && city != null && cart != null) {
            orderAdress = new Adress(adress, homeNumber, buildingNumber, city);

            if (loggedUser != null) {
                this.orderDb.getAllOrders().add(new Order(cart, orderAdress, loggedUser, locale));

                httpServletResponse.sendRedirect("/orders");

            } else {
                loggedUser = new User(login, password, email);
                this.orderDb.getAllOrders().add(new Order(cart, orderAdress, loggedUser, locale));
                httpServletRequest.getSession().setAttribute("loggedUser", loggedUser);

                httpServletResponse.sendRedirect("/orders");
            }


        } else {
            httpServletResponse.sendRedirect("/buyData");
        }

    }

    @Override
    public void init() throws ServletException {

        this.orderDb = OrderDb.getInstance();

        super.init();
    }
}
