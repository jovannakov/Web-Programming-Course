package mk.finki.ukim.mk.lab.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter
public class PizzaSizeFIlter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpResp = (HttpServletResponse) servletResponse;

        HttpServletRequest httpReq = (HttpServletRequest) servletRequest;

        HttpSession session = httpReq.getSession();

        String size = (String) session.getAttribute("size");


        if(! "/PizzaOrder.do".equals(httpReq.getServletPath()) &&
                size == null){
            httpResp.sendRedirect("/selectPizzaSize");
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

