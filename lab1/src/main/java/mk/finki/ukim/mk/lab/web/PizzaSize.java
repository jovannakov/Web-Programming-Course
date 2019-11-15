package mk.finki.ukim.mk.lab.web;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name="PizzaSize-Web-Servlet", urlPatterns = "/selectPizzaSize")
public class PizzaSize extends HttpServlet {

    private SpringTemplateEngine stEngine;
    private WebContext wContext;
    private String pizza;

    @RequestMapping(value = "/selectPizzaSize", method = RequestMethod.GET)
    private String returnPizza(@RequestParam(value="pizza") String pizza, Model model) {
        model.addAttribute("pizza", pizza);
        this.pizza = pizza;
        return "Got it";
    }

    public PizzaSize(SpringTemplateEngine stEngine){
        this.stEngine = stEngine;
    }

    private HashMap<String, String> Query2Map(String string){
        HashMap<String, String> map = new HashMap<>();

        for(String s : string.split("&")){
            map.put(s.split("=")[0], s.split("=")[1].replace("+", " "));
        }

        return map;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.wContext = new WebContext(req, resp, req.getServletContext());
        /*HashMap<String, String> query = Query2Map(req.getQueryString());
        pizza = query.get("pizza");*/
        this.wContext.setVariable("pizza", req.getSession().getAttribute("pizza"));
        this.stEngine.process("pizzaSize.html", this.wContext, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String size = req.getParameter("pizza_size");
        session.setAttribute("size", size);
        session.setAttribute("pizza", session.getAttribute("pizza"));
        resp.sendRedirect("/PizzaOrder.do");
    }
}
