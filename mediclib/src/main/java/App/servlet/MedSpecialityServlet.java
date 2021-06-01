package App.servlet;

import App.model.MedSpeciality;
import App.service.MedSpecialityService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MedSpecialityServlet", value = "/medspe")
public class MedSpecialityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MedSpecialityService medSpeSrv = new MedSpecialityService();
        List<MedSpeciality> medSpecialityList = medSpeSrv.findAll();
        request.setAttribute("specialities", medSpecialityList);
        this
                .getServletContext()
                .getRequestDispatcher("/WEB-INF/Admin-view/MedSpeciality.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
