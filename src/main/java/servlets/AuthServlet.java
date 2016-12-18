package servlets;

import entities.Customer;
import interfaces.ORM;
import utils.MsORM;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

public class AuthServlet extends HttpServlet {
    /*
    *Осуществляет авторизацию пользователя с помощью формы и проверки существования введенной пары email/password
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("name")!=null) {
            resp.sendRedirect("/personal");
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/view/aut_view.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ORM orm = new MsORM();

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        boolean found = false;

        try {
            ArrayList<Customer> customers = orm.selectAll(Customer.class);
            for(Customer c:customers){
                if(email.equals(c.getEaddress())){
                    if(password.equals(c.getPassword())){
                        HttpSession session = req.getSession();

                        session.setAttribute("name", c.getName());
                        session.setAttribute("city", c.getCity());
                        session.setAttribute("phone", c.getPhone_number());
                        session.setMaxInactiveInterval(30 * 60);
                        found = true;
                        resp.sendRedirect("/personal");
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        if (!found) {
            req.setAttribute("message", "Check your Email, password or Register");
            req.setAttribute("ref", "To registration page");
            getServletContext().getRequestDispatcher("/WEB-INF/view/aut_view.jsp").forward(req, resp);
        }

    }
}
