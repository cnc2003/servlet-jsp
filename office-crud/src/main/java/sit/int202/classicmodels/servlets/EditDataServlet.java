package sit.int202.classicmodels.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sit.int202.classicmodels.entities.Office;
import sit.int202.classicmodels.repositories.OfficeRepository;
import sit.int202.classicmodels.utils.Utils;

import java.io.IOException;

@WebServlet(name = "EditDataServlet", value = "/editData")
public class EditDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String officeCode = request.getParameter("officeCode");
        String city = request.getParameter("city");
        String phone = request.getParameter("phone");
        String addressLine1 = request.getParameter("addressLine1");
        String country = request.getParameter("country");
        String postalCode = request.getParameter("postalCode");
        String territory = request.getParameter("territory");
        OfficeRepository officeRepository = new OfficeRepository();
        if (Utils.validateIsNotEmpty(officeCode, city, phone, addressLine1, country, postalCode, territory) &&
                Utils.validateIsInteger(officeCode) && Utils.validateIsLetter(city) &&
                Utils.validateIsPhone(phone) && Utils.validateHaveSomeLetter(addressLine1) &&
                Utils.validateHaveSomeInteger(addressLine1) && Utils.validateIsLetter(country) &&
                !Utils.validateHaveSomeSpecial(postalCode) && Utils.validateIsLetter(territory)) {
            Office newOffice = new Office(officeCode, city, phone, addressLine1, country, postalCode, territory);
            boolean statusUpdate = officeRepository.update(newOffice);
            if (statusUpdate) {
                request.setAttribute("messageUpdate", "Update office successfully");
                request.setAttribute("statusUpdate", true);
            } else {
                request.setAttribute("messageUpdate", "Update office not successfully");
                request.setAttribute("statusUpdate", false);
            }
        } else {
            request.setAttribute("messageUpdate", "Update office not successfully");
            request.setAttribute("statusUpdate", false);
        }
        session.setAttribute("offices", officeRepository.findAll());
        request.getServletContext().getRequestDispatcher("/office-list.jsp").forward(request, response);
    }
}