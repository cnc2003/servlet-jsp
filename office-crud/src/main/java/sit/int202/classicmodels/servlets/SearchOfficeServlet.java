package sit.int202.classicmodels.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sit.int202.classicmodels.entities.Office;
import sit.int202.classicmodels.repositories.OfficeRepository;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchOfficeServlet", value = "/searchOffice")
public class SearchOfficeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchByCityOrCountry = request.getParameter("searchByCityOrCountry");
        HttpSession session = request.getSession(true);
        if (searchByCityOrCountry != null) {
            OfficeRepository officeRepository = new OfficeRepository();
            List<Office> offices = officeRepository.findByCityOrCountry(searchByCityOrCountry);
            session.setAttribute("offices", offices);
        }
        request.getServletContext().getRequestDispatcher("/office-list.jsp").forward(request, response);
    }
}