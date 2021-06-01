package App.servlet;

import App.service.AdressService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/add-patient")
public class AddPatientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdressService adrServ = new AdressService();

        request.setAttribute("addresses",adrServ.findAll());

        this
                .getServletContext()
                .getRequestDispatcher("/WEB-INF/patient-form.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String lastname = request.getParameter("lname");
        String firstname = request.getParameter("fname");
        String secNumber = request.getParameter("fname");

        /* <input type="text" name="secu" value="${ patient.numberSecSoc }" />
            </div>
            <div>
                <label>Birthdate</label>
                <input type="date" name="birthdate" value="${ patient.birthday }" >
            </div>
            <div>
                <label>Phone number</label>
                <input type="text" name="tel" value="${ patient.tel }" >
            </div>*/
    }
}
