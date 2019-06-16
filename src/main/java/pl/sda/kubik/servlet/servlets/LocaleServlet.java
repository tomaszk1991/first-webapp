package pl.sda.kubik.servlet.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/locale")
public class LocaleServlet extends HttpServlet {
    private static final long serialVersionUID = -1767346742661583274L;

    @Override
    protected void doPost(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        final String locale = httpServletRequest.getParameter("locale");
        httpServletRequest.getSession().setAttribute("locale", locale);


        httpServletResponse.sendRedirect(httpServletRequest.getContextPath());
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
