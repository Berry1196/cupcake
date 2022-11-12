package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.entities.User;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Orders", value = "/orders")
public class Orders extends HttpServlet {
    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Order> orderIds = new ArrayList<>();
        Map<ShoppingCart, Order> adminOrderList = OrderFacade.getOrderListForAdmin(connectionPool);

        for (Order order: adminOrderList.values())
        {
            orderIds.add(order);
        }
        request.setAttribute("adminOrderList",adminOrderList);
        request.setAttribute("orderIds", orderIds);

        request.getRequestDispatcher("WEB-INF/kunder.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
