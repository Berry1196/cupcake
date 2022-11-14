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
import java.util.*;

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

        Map<Integer, Order> getMalene = OrderFacade.getMalene(connectionPool);
        request.setAttribute("getMalene", getMalene);

        Map<Integer, List<Cake>> theCakeListBaby = new TreeMap<>();


        int totalCost = 0;

        Map<Order, List<Cake>> getOrderListForAdminByOrderId = OrderFacade.getOrderListForAdminByOrderId(malene, connectionPool);

        for (List<Cake> cakeLists : getOrderListForAdminByOrderId.values()) {
            theCakeListBaby.put(malene, cakeLists);

            for (int i = 0; i < cakeLists.size(); i++) {
                totalCost = cakeLists.get(i).getTotalCakePrice() + totalCost;
            }
            int newPrice = totalCost / 3;
            request.setAttribute("newPrice", newPrice);
        }

        request.setAttribute("theCakeListBaby", theCakeListBaby);

        request.getRequestDispatcher("WEB-INF/kunder.jsp").forward(request, response);
    }

}
