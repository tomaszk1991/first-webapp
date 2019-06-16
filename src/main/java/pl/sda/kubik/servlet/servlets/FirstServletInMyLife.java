package pl.sda.kubik.servlet.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/home")
public class FirstServletInMyLife extends HttpServlet {

    private static final long serialVersionUID = -4403859653340060550L;

    @Override
    public void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        //  PrintWriter writer= httpServletResponse.getWriter();
        // writer.print("Hello world");


        httpServletRequest.setAttribute("name", "Tomek");
        // wszystko musi byc przed .forward
        httpServletRequest.getRequestDispatcher("/index.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
