package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.*;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.util.List;
import java.util.Map;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // You shouldn't end up here with a GET-request, thus you get sent back to frontpage
        response.sendRedirect("index.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        session.setAttribute("user", null); // invalidating user object in session scope
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            User user = UserFacade.login(username, password, connectionPool);
            session = request.getSession();
            session.setAttribute("user", user); // adding user object to session scope

            Map<String, Bottom> bottomMap = BottomFacade.getBottoms(connectionPool);
            request.setAttribute("bottomMap", bottomMap);

            Map<String, Topping> toppingMap = ToppingFacade.getToppings(connectionPool);
            request.setAttribute("toppingMap", toppingMap);

            ShoppingCart shoppingCart = new ShoppingCart();
            session.setAttribute("shoppingCart", shoppingCart);

            List<Order> orderList = OrderFacade.getOrders(connectionPool);
            request.setAttribute("orderList", orderList);

            Map<ShoppingCart, Order> orderListUser = OrderFacade.getOrderListUser(user.getUsername(), connectionPool);
            request.setAttribute("orderListUser", orderListUser);

            Map<ShoppingCart, Order> adminOrderList = OrderFacade.getOrderListForAdmin(connectionPool);
            request.setAttribute("adminOrderList", adminOrderList);


            if (user.getRole().equals("admin")) {
                request.getRequestDispatcher("WEB-INF/kunder.jsp").forward(request, response);
            }

            request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);

        } catch (DatabaseException e) {
            request.setAttribute("besked", "Fejl ved login. Prøv igen");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }

}