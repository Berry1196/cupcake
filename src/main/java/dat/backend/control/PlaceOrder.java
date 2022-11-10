package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.entities.User;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PlaceOrder", value = "/placeOrder")
public class PlaceOrder extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");

        session.setAttribute("shoppingCart", shoppingCart);

        request.getRequestDispatcher("betaling.jsp").forward(request, response);
    }
}
