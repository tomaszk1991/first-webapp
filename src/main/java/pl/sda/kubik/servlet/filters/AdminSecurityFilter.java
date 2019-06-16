package pl.sda.kubik.servlet.filters;


import pl.sda.kubik.servlet.domain.User;
import pl.sda.kubik.servlet.domain.UsersRole;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AdminSecurityFilter", servletNames = {"AddProductServlet"})
public class AdminSecurityFilter implements Filter {
    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        final Object object = request.getSession().getAttribute("loggedUser");
        if (object != null) {

            final User user = (User) object;
            if (user.getRoles().contains(UsersRole.ADMIN)) {
                filterChain.doFilter(servletRequest, servletResponse);

            } else {


                response.sendRedirect("/home");


            }


        } else {
            response.sendRedirect("/home");


        }


    }

    @Override
    public void destroy() {

    }
}
