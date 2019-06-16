package pl.sda.kubik.servlet.servlets;


import org.apache.commons.validator.routines.EmailValidator;
import pl.sda.kubik.servlet.dao.UserDb;
import pl.sda.kubik.servlet.domain.User;
import pl.sda.kubik.servlet.domain.UsersRole;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;


@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = -7663485227533677366L;
    private UserDb users;

    @Override
    public void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {


        httpServletRequest
                .getRequestDispatcher("register.jsp")
                .forward(httpServletRequest, httpServletResponse);

    }

    @Override
    public void doPost(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {


        final String login = httpServletRequest.getParameter("login");
        final String password = httpServletRequest.getParameter("password");
        final String email = httpServletRequest.getParameter("email");
        final boolean valid = EmailValidator.getInstance().isValid(email);
        boolean userCrated = false;
        if (login != null && password != null && email != null && valid) {

            if (this.users.findByLogin(login).isPresent()) {

                httpServletRequest.setAttribute("loginError", "login istnieje");


            }
            if (this.users.findByEmail(email).isPresent()) {
                httpServletRequest.setAttribute("emailError", "email istnieje");

            }
            if (!this.users.findByEmail(email).isPresent() && !this.users.findByLogin(login).isPresent()) {
                this.users.createUser(login, password, email, UsersRole.USER);
                final Optional<User> user = this.users.findByLogin(login);
                httpServletRequest.setAttribute("userCreated", "pomyslnie utworzono");
                httpServletRequest.getSession().invalidate();
                if (user.isPresent()) {

                    httpServletRequest.getSession().setAttribute("loggedUser", user.get());
                    userCrated = true;

                }


            }
        } else {
            httpServletRequest.setAttribute("blank", "wypelnij wszystkie pola");

        }
        if (userCrated) {
            httpServletResponse.sendRedirect("/homepage");
        } else {
            httpServletRequest.getRequestDispatcher("/register.jsp").forward(httpServletRequest, httpServletResponse);
        }

    }

    @Override
    public void init() throws ServletException {


        this.users = UserDb.getInstance();
        super.init();
    }
}
