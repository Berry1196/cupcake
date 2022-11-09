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

@WebServlet(name = "AddCupcakes", value = "/addCupcakes")
public class AddCupcakes extends HttpServlet {

    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();
    ArrayList<Cake> cakesInCart;
    @Override
    public void init() throws ServletException {
        cakesInCart = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        List<Bottom> bottomList = BottomFacade.getBottoms(connectionPool);
        request.setAttribute("bottomList", bottomList);

        String topping = request.getParameter("topping");
        String bottom = request.getParameter("bottom");
        int quantity = Integer.parseInt(request.getParameter("quantity"));


        //HER ER DER BALLADE
        Cake cake = new Cake(new Bottom(), new Topping(topping),quantity);
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");

        request.setAttribute("topping", topping);
        request.setAttribute("bottom", bottom);
        request.setAttribute("quantity", quantity);

        session.setAttribute("cakePrice", cake.getCakePrice());
        session.setAttribute("totalCakePrice", cake.getTotalCakePrice());
        session.setAttribute("totalCartPrice", shoppingCart.getTotalCartPrice());


        ArrayList<Cake> cakesInCart = shoppingCart.insertCake(cake);


        List<Topping> toppingList = ToppingFacade.getToppings(connectionPool);
        request.setAttribute("toppingList", toppingList);

        session.setAttribute("cakesInCart", cakesInCart);

        request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
    }
}
