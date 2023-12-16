package sit.int202.classicmodels.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sit.int202.classicmodels.repositories.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "DeleteOfficeServlet", value = "/deleteOffice")
public class DeleteOfficeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String officeCode = request.getParameter("officeCode");
        OfficeRepository officeRepository = new OfficeRepository();
        if (officeCode != null) {
            try {
                boolean statusDelete = officeRepository.delete(officeCode);
                if (statusDelete) {
                    request.setAttribute("messageDelete", "Delete office successfully");
                    request.setAttribute("statusDelete", true);
                } else {
                    request.setAttribute("messageDelete", "Delete office not successfully");
                    request.setAttribute("statusDelete", false);
                }
            } catch (Exception e) {
                request.getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("messageDelete", "Delete office not successfully");
            request.setAttribute("statusDelete", false);
        }
        session.setAttribute("offices", officeRepository.findAll());
        request.getServletContext().getRequestDispatcher("/office-list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}