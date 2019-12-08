package mk.finki.ukim.mk.lab.web.filters;

import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;


@WebFilter
public class MultifunctionalFilter implements Filter {



    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpResp = (HttpServletResponse) servletResponse;

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;


        String pizza = (String) httpRequest
                .getSession()
                .getAttribute("pizza");

        String size = (String) httpRequest
                .getSession()
                .getAttribute("size");

        String client = (String) httpRequest
                .getSession()
                .getAttribute("clientName");

        String address = (String) httpRequest
                .getSession()
                .getAttribute("clientAddress");


        if(!"".equals(httpRequest.getServletPath()) &&
                (pizza == null || pizza.isEmpty())){
            //System.out.println("REDIRECTED");
            httpResp.sendRedirect("/");
        }else if (!"".equals(httpRequest.getServletPath())
                && !"/selectPizzaSize".equals(httpRequest.getServletPath())
                && (size == null || size.isEmpty())){
            //System.out.println("REDIRECTED 1");
            httpResp.sendRedirect("/selectPizzaSize");
        }else if ((!"".equals(httpRequest.getServletPath())
                && !"/selectPizzaSize".equals(httpRequest.getServletPath())
                && !"/PizzaOrder.do".equals(httpRequest.getServletPath()))
                && (client == null || client.isEmpty()
                || address == null || address.isEmpty())){
            //System.out.println("REDIRECTED 2");
            httpResp.sendRedirect("/PizzaOrder.do");
        }
        else{
            filterChain.doFilter(httpRequest, httpResp);
        }





    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
