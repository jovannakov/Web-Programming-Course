package mk.finki.ukim.mk.lab.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter
public class ConfirmationInfoFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpResp = (HttpServletResponse) servletResponse;

        HttpServletRequest httpReq = (HttpServletRequest) servletRequest;

        HttpSession session = httpReq.getSession();

        String name = (String) session.getAttribute("clientName");
        String address = (String) session.getAttribute("clientAddress");

        if( "/ConfirmationInfo.do".equals(httpReq.getServletPath()) &&
                (name == null || address == null)){
            httpResp.sendRedirect("/PizzaOrder.do");
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }


    }

    @Override
    public void destroy() {

    }
}
