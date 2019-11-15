package mk.finki.ukim.mk.lab.web;

import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Order-Web-Servlet", urlPatterns = "/PizzaOrder.do")
public class PizzaOrder extends HttpServlet {


    private SpringTemplateEngine stEngine;
    private WebContext wContext;

    public PizzaOrder(SpringTemplateEngine stEngine){
        this.stEngine = stEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.wContext = new WebContext(req, resp, req.getServletContext());
        this.wContext.setVariable("size", req.getSession().getAttribute("size"));
        this.wContext.setVariable("pizza", req.getSession().getAttribute("pizza"));
        this.stEngine.process("deliveryInfo.html", this.wContext, resp.getWriter());
   }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("clientName");
        String address = req.getParameter("clientAddress");

        HttpSession session = req.getSession();
        session.setAttribute("clientName", name);
        session.setAttribute("clientAddress", address);

        resp.sendRedirect("/ConfirmationInfo.do");
    }
}
