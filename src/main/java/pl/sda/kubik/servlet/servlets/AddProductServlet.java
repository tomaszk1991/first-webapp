package pl.sda.kubik.servlet.servlets;


import pl.sda.kubik.servlet.dao.ProductDb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = "/addProduct", name = "AddProductServlet")
public class AddProductServlet extends HttpServlet {
    private static final long serialVersionUID = -4393037618261924270L;
    private ProductDb db;

    @Override
    public void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {


        httpServletRequest
                .getRequestDispatcher("addProduct.jsp")
                .forward(httpServletRequest, httpServletResponse);
    }

    @Override
    public void doPost(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {


        final String name = httpServletRequest.getParameter("name");
        final String description = httpServletRequest.getParameter("description");
        final Long price = Long.valueOf(httpServletRequest.getParameter("price"));
        final String image = httpServletRequest.getParameter("image");

        final String[] ids = httpServletRequest.getParameterValues("category");
        final List<String> category = Arrays.asList(ids);
        final long idCreated = this.db.createNewProduct(name, description, price, image, category);

        httpServletResponse.sendRedirect("/productView?id=" + idCreated);

    }


//    Zarejestrowac ten servlet pod addProduct
//    Przeladowac init i doPost i doGet
//    Dodac baze z produktami jak w homepage servlet
//    Stworzyc plik addproduct.jsp

    @Override
    public void init() throws ServletException {
        this.db = ProductDb.getInstance();
        super.init();
    }


}
