package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Cake;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.ShoppingCart;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Vis", value = "/vis")
public class Vis extends HttpServlet {

    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int malene = Integer.parseInt(request.getParameter("malene"));
        request.setAttribute("malene", malene);

        if(malene != 0) {

            request.setAttribute("hej", "hallll'øøøøøøøøjsaaa");

        } else {

        }















        HttpSession session = request.getSession();

        List<Order> orderIds = new ArrayList<>();
        Map<ShoppingCart, Order> adminOrderList = OrderFacade.getOrderListForAdmin(connectionPool);

        Map<Integer, List<Cake>> getOrderListForAdminByOrderId;
        for (Order order : adminOrderList.values()) {
            orderIds.add(order);
            getOrderListForAdminByOrderId = OrderFacade.getOrderListForAdminByOrderId(order.getOrder_id(), connectionPool);

            int cupcakeId = 0;
            Map<Integer, Integer> cupcakeIdList = OrderFacade.getCupcakeIdListByOrderId(order.getOrder_id(), connectionPool);
            Map<Integer, Cake> getCakeByCupcakeId = OrderFacade.getCakeByCupcakeId(order.getOrder_id(), connectionPool);
            String test = "ordre nr 90 har dette cupcake id: " + OrderFacade.getCupcakeIdListByOrderId(90, connectionPool);
            request.setAttribute("test", test);


            request.setAttribute("getCakeByCupcakeId", getCakeByCupcakeId);
            session.setAttribute("getOrderListForAdminByOrderId", getOrderListForAdminByOrderId);
            request.setAttribute("cupcakeIdList", cupcakeIdList);
        }

        request.setAttribute("adminOrderList", adminOrderList);
        request.setAttribute("orderIds", orderIds);


        request.getRequestDispatcher("WEB-INF/kunder.jsp").forward(request, response);
    }

}
