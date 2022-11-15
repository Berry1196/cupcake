package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.Cake;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.entities.Topping;
import dat.backend.model.persistence.BottomFacade;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.ToppingFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "EditCake", value = "/editcake")
public class EditCake extends HttpServlet {
    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        Map<String, Topping> toppingMap = ToppingFacade.getToppings(connectionPool);
        request.setAttribute("toppingMap", toppingMap);

        Map<String, Bottom> bottomMap = BottomFacade.getBottoms(connectionPool);
        request.setAttribute("bottomMap", bottomMap);

        String topping = request.getParameter("topping");
        String bottom = request.getParameter("bottom");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int cakeIndex = Integer.parseInt(request.getParameter("cakeIndex"));
        request.setAttribute("cakeIndex", cakeIndex);

        Cake cake = new Cake(bottomMap.get(bottom), toppingMap.get(topping), quantity);
        session.setAttribute("theCake", cake);


        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        shoppingCart.updateCake(cakeIndex, cake);

        request.getRequestDispatcher("WEB-INF/kurv.jsp").forward(request, response);

    }
}
