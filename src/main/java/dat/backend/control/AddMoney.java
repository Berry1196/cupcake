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
import java.util.Map;

@WebServlet(name = "AddMoney", value = "/addMoney")
public class AddMoney extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        int amount = Integer.parseInt(request.getParameter("amount"));
        String username = request.getParameter("username");

        int currentBalance = OrderFacade.getUserBalance(username, connectionPool);
        int newBalance = currentBalance + amount;

        UserFacade.updateBalance(username, newBalance, connectionPool);

        request.setAttribute("besked", "Der er nu blevet tanket op");


        Map<ShoppingCart, Order> adminOrderList = OrderFacade.getOrderListForAdmin(connectionPool);
        request.setAttribute("adminOrderList",adminOrderList);

        request.getRequestDispatcher("WEB-INF/kunder.jsp").forward(request, response);
    }
}
