package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.ShoppingCart;

import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ShoppingCartServlet", value = "/shoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {


    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        session.setAttribute("shoppingCart", shoppingCart);

        request.getRequestDispatcher("WEB-INF/kurv.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
