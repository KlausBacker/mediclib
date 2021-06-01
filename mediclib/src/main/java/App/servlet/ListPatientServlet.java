package App.servlet;

import App.service.PatientService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/list-patients")
public class ListPatientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PatientService patServ = new PatientService();

        request.setAttribute("patients", patServ.findAll());

        this
                .getServletContext()
                .getRequestDispatcher("/WEB-INF/list-patients.jsp")
                .forward(request, response);

        request.setAttribute("addPatient",null);

    }

}
