package mk.finki.ukim.mk.lab.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter
public class ShowPizzaFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse httpResp = (HttpServletResponse) servletResponse;

        HttpServletRequest httpReq = (HttpServletRequest) servletRequest;

        HttpSession session = httpReq.getSession();

        String pizza = (String) session.getAttribute("pizza");



        if( "/selectPizzaSize".equals(httpReq.getServletPath()) &&  pizza == null){
            httpResp.sendRedirect("");
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }


    @Override
    public void destroy() {

    }
}
