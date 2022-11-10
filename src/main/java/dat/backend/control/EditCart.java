package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Cake;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.persistence.CartFacade;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "EditCart", value = "/editcart")
public class EditCart extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        session.setAttribute("shoppingCart", shoppingCart);

        int cakeIndex = Integer.parseInt(request.getParameter("cakeIndex"));
        request.setAttribute("cakeIndex", cakeIndex);
        Cake cake = shoppingCart.getCakeByIndex(cakeIndex);
        request.setAttribute("cake", cake);
        request.getRequestDispatcher("editCart.jsp").forward(request, response);
    }
}
