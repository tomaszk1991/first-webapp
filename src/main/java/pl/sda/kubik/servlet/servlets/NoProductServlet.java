package pl.sda.kubik.servlet.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/noProduct")
public class NoProductServlet extends HttpServlet {
    private static final long serialVersionUID = -2525902374962824157L;

    @Override
    public void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        final String id = httpServletRequest.getParameter("id");
        httpServletRequest.setAttribute("id", id);

        httpServletRequest.getRequestDispatcher("/noProduct.jsp").forward(httpServletRequest, httpServletResponse);

    }
}
