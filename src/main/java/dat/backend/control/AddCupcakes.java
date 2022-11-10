package dat.backend.control;

import com.mysql.cj.protocol.result.AbstractResultsetRow;
import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.*;
import dat.backend.model.persistence.BottomFacade;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.ToppingFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AddCupcakes", value = "/addCupcakes")
public class AddCupcakes extends HttpServlet {

    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Map<String, Topping> toppingMap = ToppingFacade.getToppings(connectionPool);
        request.setAttribute("toppingMap", toppingMap);

        Map<String , Bottom> bottomMap = BottomFacade.getBottoms(connectionPool);
        request.setAttribute("bottomMap", bottomMap);


        String topping = request.getParameter("topping");
        String bottom = request.getParameter("bottom");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        //HER ER DER BALLADE
        Cake cake = new Cake(bottomMap.get(bottom), toppingMap.get(topping),quantity);

        //Cake cake = new Cake(bottomMap.get(bottomId), toppingMap.get(toppingId),quantity);
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");

        request.setAttribute("topping", topping);
        request.setAttribute("bottom", bottom);
        request.setAttribute("quantity", quantity);
        session.setAttribute("totalCartPrice", (toppingMap.get(topping).getTopppingPrice()+bottomMap.get(bottom).getBottomPrice())*quantity);

        session.setAttribute("cakePrice", cake.getCakePrice());
        session.setAttribute("totalCakePrice", cake.getTotalCakePrice());



        ArrayList<Cake> cakesInCart = shoppingCart.insertCake(cake);




        session.setAttribute("cakesInCart", cakesInCart);

        request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
    }
}
