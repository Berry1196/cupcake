package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.entities.Topping;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.ToppingFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShoppingCartServlet", value = "/shoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {


    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();
    //public    ShoppingCart shoppingCart = new ShoppingCart();




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

//        session.getAttribute("cakePrice");
//        session.getAttribute("totalCakePrice");
//        session.getAttribute("totalCartPrice");

        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        session.setAttribute("shoppingCart", shoppingCart);
//        request.setAttribute("totalCartPrice", shoppingCart.getTotalCartPrice());
        request.getRequestDispatcher("kurv.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
