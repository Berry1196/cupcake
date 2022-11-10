package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Order;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Orders", value = "/orders")
public class Orders extends HttpServlet {
    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Order> orderList = OrderFacade.getOrders(connectionPool);
        request.setAttribute("orderList",orderList);
        request.setAttribute("hej","det virker");
        request.getRequestDispatcher("kunder.jsp").forward(request,response);
        log("Størrelse af orderList" + (orderList.size()));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
