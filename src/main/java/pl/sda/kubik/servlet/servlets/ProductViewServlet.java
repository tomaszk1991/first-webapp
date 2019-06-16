package pl.sda.kubik.servlet.servlets;


import pl.sda.kubik.servlet.dao.ProductDb;
import pl.sda.kubik.servlet.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/productView")
public class ProductViewServlet extends HttpServlet {
    private static final long serialVersionUID = -2460213128472355538L;
    private ProductDb db;

    @Override
    public void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {

        final long idCreatet = Long.valueOf(httpServletRequest.getParameter("id"));


        final Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null) {
            for (final Cookie cookie : cookies) {
                if (cookie.getName().equals("lastView")) {
                    httpServletRequest.setAttribute("lastView", this.db.getProductByID(Long.valueOf(cookie.getValue())).get());
                }
            }


        }
        final Cookie lastView = new Cookie("lastView", String.valueOf(idCreatet));
        httpServletResponse.addCookie(lastView);


        final Optional<Product> created = this.db.getProductByID(idCreatet);


        if (created.isPresent()) {


            httpServletRequest.setAttribute("product", created.get());

            httpServletRequest.getRequestDispatcher("/productView.jsp").forward(httpServletRequest, httpServletResponse);

        } else {
            httpServletResponse.sendRedirect("/noProduct?id=" + idCreatet);
        }
    }


//    Stworz ProductViewServlet
//    W DAO/Bazie zwroc ID nowego produktu do servlet'a
//    Servlet POST addProduct powinien przekierowac na nowy servlet za pomoca +
//            response.sendRedirect("/viewProduct?id=idnowego")
//    Zarejestruj ProductViewServlet pod /viewProduct
//    Dodaj baze danych do ProductViewServlet
//    W metodzie init przypisz baze danych
//    Przeladuj doGet
//    W doGet wyciagnij z bazy jeden produkt ktorego ID zostalo przeslane
//    Stworz viewproduct.jsp
//    W viewproduct.jsp wyswietl zadany produkt


    @Override
    public void init() throws ServletException {
        this.db = ProductDb.getInstance();
        super.init();
    }


}
