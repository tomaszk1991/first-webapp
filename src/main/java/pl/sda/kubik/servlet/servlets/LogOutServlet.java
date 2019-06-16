package pl.sda.kubik.servlet.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/logOut")
public class LogOutServlet extends HttpServlet {
    private static final long serialVersionUID = 3059435441146800242L;

    @Override
    public void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {


        httpServletRequest
                .getRequestDispatcher("logOut.jsp")
                .forward(httpServletRequest, httpServletResponse);


    }

    @Override
    public void doPost(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getSession().invalidate();
        httpServletResponse.sendRedirect("/homepage");
    }
}
