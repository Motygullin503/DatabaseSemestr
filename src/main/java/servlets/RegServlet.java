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

/**
 * Created by UseR7 on 12.12.2016.
 */
public class RegServlet extends HttpServlet {
    /*
    Отвечает за регистрацию пользователя в системе
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (req.getParameter("status") != null) {
            if (req.getParameter("status").equals("1")) {
                req.setAttribute("message", "Registration successfull");
            }
            if (req.getParameter("status").equals("0")) {
                session.setAttribute("email", null);
            }
        }
        if (session.getAttribute("email") != null) {
            resp.sendRedirect("/home");
            return;
        }

        getServletContext().getRequestDispatcher("/WEB-INF/view/reg_view.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullname = req.getParameter("fullname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");
        String city = req.getParameter("city");
        String phone = req.getParameter("phone");

        boolean found = false;

        ORM orm = new MsORM();

        try {
            for (Object o : orm.selectColumn(Customer.class, "eaddress")) {
                if (email.equals(o.toString())) {
                    found = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (email.length() != 0 && fullname.length() != 0 && password.length() != 0 && password2.length() != 0) {
            if (password.equals(password2)) {
                if (!found) {
                    Customer customer = new Customer(fullname, city, email, phone, password);
                    try {
                        orm.insert(Customer.class, customer);
                    } catch (NoSuchMethodException | SQLException | InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } else {
                    req.setAttribute("message", "Already registered");

                }

            } else {
                req.setAttribute("name", fullname);
                req.setAttribute("email", email);
                req.setAttribute("phone", phone);
                req.setAttribute("city", city);

                req.setAttribute("message", "Passwords must match");
            }

        } else {
            req.setAttribute("name", fullname);
            req.setAttribute("email", email);
            req.setAttribute("password", password);
            req.setAttribute("password2", password2);
            req.setAttribute("phone", phone);
            req.setAttribute("city", city);
            req.setAttribute("message", "Fill all fields, please");
        }
        getServletContext().getRequestDispatcher("/WEB-INF/view/reg_view.jsp").forward(req, resp);
    }
}

