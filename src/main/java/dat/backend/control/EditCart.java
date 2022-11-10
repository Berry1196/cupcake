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
//        int quantity = Integer.parseInt(request.getParameter("quantity"));
//        String bottomName = request.getParameter("bottomName");
//        String toppingName = request.getParameter("toppingName");
//        int cakeIndex = Integer.parseInt(request.getParameter("cakeIndex"));
//
//        request.setAttribute("quantity", quantity);
//        request.setAttribute("bottomName", bottomName);
//        request.setAttribute("toppingName", toppingName);
//        request.setAttribute("cakeIndex", cakeIndex);
//
//        //request.setAttribute("shoppingCart", shoppingCart.getCakesInCart().);
//
//        request.getRequestDispatcher("editCart.jsp").forward(request, response);
        HttpSession session = request.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        session.setAttribute("shoppingCart", shoppingCart);

//        ArrayList<Cake> cakesInCart = shoppingCart.getCakesInCart();


        int cakeIndex = Integer.parseInt(request.getParameter("cakeIndex"));
        request.setAttribute("cakeIndex", cakeIndex);
        Cake cake = shoppingCart.getCakeByIndex(cakeIndex);
        request.setAttribute("cake", cake);
        request.getRequestDispatcher("editCart.jsp").forward(request, response);
    }
}
