package pl.sda.kubik.servlet.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter("/*")
public class LocaleFilter implements Filter {
    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {


    }

    @Override
    public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse, final FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        final String locale = (String) request.getSession().getAttribute("locale");
        if (locale == null) {
            request.getSession().setAttribute("locale", "pl");
        }
        filterChain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}
