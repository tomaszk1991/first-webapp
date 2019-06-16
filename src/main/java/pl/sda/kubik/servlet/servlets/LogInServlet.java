package pl.sda.kubik.servlet.servlets;

import pl.sda.kubik.servlet.dao.UserDb;
import pl.sda.kubik.servlet.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/logIn")

public class LogInServlet extends HttpServlet {
    private static final long serialVersionUID = -8012885431310085875L;
    private UserDb userDb;

    @Override
    public void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("logIn.jsp").forward(httpServletRequest, httpServletResponse);

    }

    @Override
    public void doPost(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        final String login = httpServletRequest.getParameter("login");
        final String password = httpServletRequest.getParameter("password");

        if (login != null && password != null) {

            final Optional<User> optUser = this.userDb.checkLogin(login, password);
            if (optUser.isPresent()) {

                httpServletRequest.getSession().setAttribute("loggedUser", optUser.get());
                httpServletResponse.sendRedirect("/homepage");
            } else {


                httpServletRequest.setAttribute("logInError", "Zły login lub hasło");
                httpServletResponse.sendRedirect("/homepage");
                //httpServletRequest.getRequestDispatcher("/logIn.jsp").forward(httpServletRequest, httpServletResponse);

            }


        } else {

            httpServletRequest.setAttribute("logInError", "Zły login lub hasło");
            httpServletResponse.sendRedirect("/homepage");
            // httpServletRequest.getRequestDispatcher("/logIn.jsp").forward(httpServletRequest, httpServletResponse);

        }

    }

    @Override
    public void init() throws ServletException {
        this.userDb = UserDb.getInstance();
        super.init();
    }
}
