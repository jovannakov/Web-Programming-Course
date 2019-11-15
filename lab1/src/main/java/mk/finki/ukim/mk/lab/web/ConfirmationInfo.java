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

@WebServlet(name="Info-Web-Servlet", urlPatterns = "/ConfirmationInfo.do")
public class ConfirmationInfo extends HttpServlet {

    protected WebContext webContext;
    protected SpringTemplateEngine springTemplateEngine;

    public ConfirmationInfo(SpringTemplateEngine springTemplateEngine){
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.webContext = new WebContext(req, resp, req.getServletContext());
        HttpSession session = req.getSession();
        webContext.setVariable("name", session.getAttribute("clientName"));
        webContext.setVariable("address", session.getAttribute("clientAddress"));
        webContext.setVariable("pizza", session.getAttribute("pizza"));
        webContext.setVariable("size", session.getAttribute("size"));
        webContext.setVariable("browser", req.getHeader("User-Agent"));
        webContext.setVariable("ip", req.getRemoteHost());
        this.springTemplateEngine.process("confirmationInfo.html", this.webContext, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect("");
    }
}
