package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.*;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.BottomFacade;
import dat.backend.model.persistence.ToppingFacade;
import dat.backend.model.persistence.UserFacade;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "login", urlPatterns = {"/login"} )
public class Login extends HttpServlet
{
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        // You shouldn't end up here with a GET-request, thus you get sent back to frontpage
        response.sendRedirect("index.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        session.setAttribute("user", null); // invalidating user object in session scope
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try
        {
            User user = UserFacade.login(username, password, connectionPool);
            session = request.getSession();
            session.setAttribute("user", user); // adding user object to session scope

            List<Bottom> bottomList = BottomFacade.getBottoms(connectionPool);
            request.setAttribute("bottomList", bottomList);
            List<Topping> toppingList = ToppingFacade.getToppings(connectionPool);
            request.setAttribute("toppingList", toppingList);


            ArrayList<Cake> cakesInCart = new ArrayList<>();
            request.setAttribute("cakesInCart", cakesInCart);

            request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);

        }
        catch (DatabaseException e)
        {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }


    }

}