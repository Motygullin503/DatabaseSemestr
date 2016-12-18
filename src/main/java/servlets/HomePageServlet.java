package servlets;

import entities.Customer;
import entities.Organization;
import entities.Specialization;
import utils.MsORM;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class HomePageServlet extends HttpServlet {

    /*
    Отвечает за показ списка доступных организаций и их данные
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MsORM orm = new MsORM();

        try {

            req.setAttribute("list", orm.selectAll(Organization.class));
            ArrayList<String> arrayList= orm.selectColumn(Organization.class, "org_id");


        } catch (Exception e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/WEB-INF/view/main_page.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
