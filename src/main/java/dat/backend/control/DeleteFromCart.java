package dat.backend.control;

import dat.backend.model.entities.ShoppingCart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteFromCart", value = "/deletefromcart")
public class DeleteFromCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();


        int cakeIndex = Integer.parseInt(request.getParameter("cakeIndex"));
        request.setAttribute("cakeIndex", cakeIndex);
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");

        shoppingCart.deleteCakeByIndex(cakeIndex);

        request.getRequestDispatcher("WEB-INF/kurv.jsp").forward(request, response);

    }
}
