package mk.finki.ukim.mk.lab.web;


import mk.finki.ukim.mk.lab.service.PizzaService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="Pizza-Web-Servlet", urlPatterns = "")
public class ShowPizza extends HttpServlet {

    private final PizzaService pizzaService;
    private SpringTemplateEngine stEngine;
    private WebContext wContext;

    public ShowPizza(PizzaService pizzaService, SpringTemplateEngine stEngine){
        this.pizzaService = pizzaService;
        this.stEngine = stEngine;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.wContext = new WebContext(req, resp, req.getServletContext());
        this.wContext.setVariable("pizzas", pizzaService.listAllPizzas());
        this.stEngine.process("listPizzas.html", this.wContext, resp.getWriter());
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("pizza", req.getParameter("pizza"));
        resp.sendRedirect("/selectPizzaSize");
    }
}
