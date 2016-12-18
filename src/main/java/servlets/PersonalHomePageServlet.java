package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class PersonalHomePageServlet extends HttpServlet {
    /*
    Отвечает за показ личных данных пользователя
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session =req.getSession();

        req.setAttribute("name", session.getAttribute("name"));
        req.setAttribute("city", session.getAttribute("city"));
        req.setAttribute("phone", session.getAttribute("phone"));


        getServletContext().getRequestDispatcher("/WEB-INF/view/personalHome.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
