package App.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HomeAdminServlet", value = "/admin")
public class HomeAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this
                .getServletContext() // -> récupérer le contexte de Servlet
                .getRequestDispatcher("/WEB-INF/Admin-view/home-admin.jsp") // -> récupérer le dispacher
                .forward(request, response); // -> transfert de la requète et réponse HTTP
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
