package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CreateUserForm", value = "/createuserform")
public class CreateUserForm extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String besked = "";
        HttpSession session = request.getSession();

        String username = request.getParameter("newusername");
        String newpassword = request.getParameter("newpassword");
        String repnewpassword = request.getParameter("repnewpassword");
        String role = "user";

        try {
            for (String name : UserFacade.getAllUsers(connectionPool)) {
                if (username.equals(name)) {
                    besked = "En bruger med dette navn findes allerede. Prøv igen!";
                    session.setAttribute("besked", besked);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            }

            if (newpassword.equals(repnewpassword)) {
                User user = UserFacade.createUser(username, newpassword, role, connectionPool);

                besked = "Du har nu oprettet en bruger. Venligst log på";

                session.setAttribute("user", user); // adding user object to session scope
                session.setAttribute("username", username);

                session.setAttribute("besked", besked);
                request.getRequestDispatcher("index.jsp").forward(request, response);

            }
            besked = "Adgangskoderne er ikke ens. Prøv igen!";
            session.setAttribute("besked", besked);
            request.getRequestDispatcher("index.jsp").forward(request, response);


        } catch (DatabaseException e) {
            e.printStackTrace();
        }

    }
}
