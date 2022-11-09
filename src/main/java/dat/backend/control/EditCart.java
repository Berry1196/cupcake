package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Cake;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditCart", value = "/editcart")
public class EditCart extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String bottomName = request.getParameter("bottomName");
        String toppingName = request.getParameter("toppingName");
        int cakeIndex = Integer.parseInt(request.getParameter("cakeIndex"));

        request.setAttribute("quantity", quantity);
        request.setAttribute("bottomName", bottomName);
        request.setAttribute("toppingName", toppingName);
        request.setAttribute("cakeIndex", cakeIndex);

        //request.setAttribute("shoppingCart", shoppingCart.getCakesInCart().);

        request.getRequestDispatcher("editCart.jsp").forward(request, response);
    }
}
