package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Cake;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.entities.User;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;
import dat.backend.model.persistence.OrderMapper;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Payment", value = "/payment")
public class Payment extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cakeIndex = Integer.parseInt(request.getParameter("cakeIndex"));
        request.setAttribute("cakeIndex", cakeIndex);
        response.sendRedirect("WEB-INF/ordre.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");

        User user = (User) session.getAttribute("user");
        int userBalance = user.getBalance();
        int totalCartPrice = shoppingCart.getTotalCartPrice();
        int newBalance = userBalance - totalCartPrice;
        //int cakeIndex = (int) request.getAttribute("cakeIndex");

        if(userBalance > totalCartPrice) {
            user.setBalance(newBalance);
            UserFacade.updateBalance(user.getUsername(), newBalance, connectionPool);

            OrderFacade.saveOrder(user.getUsername(), connectionPool);
            Order order = OrderFacade.getOrderByUsername(user.getUsername(), connectionPool);

            int cakeSize = shoppingCart.getCakesInCart().size();
            request.setAttribute("cakeSize", cakeSize);
           // OrderFacade.saveOrderToOrdernline(order.getOrder_id(), shoppingCart.getCakeByIndex(cakeIndex), connectionPool);

            session.setAttribute("order",order);

        } else {
            request.setAttribute("besked", "Du har ikke nok penge på kontoen. Tryk her for at tanke op:  ");

            request.getRequestDispatcher("WEB-INF/betaling.jsp").forward(request, response);
        }

        request.setAttribute("newBalance", newBalance);

        request.getRequestDispatcher("WEB-INF/kvittering.jsp").forward(request, response);
    }






}
