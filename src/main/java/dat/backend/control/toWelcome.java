package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.Topping;
import dat.backend.model.persistence.BottomFacade;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.ToppingFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "toWelcome", value = "/towelcome")
public class toWelcome extends HttpServlet {

    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Map<String, Bottom> bottomMap = BottomFacade.getBottoms(connectionPool);
        request.setAttribute("bottomMap", bottomMap);

        Map<String, Topping> toppingMap = ToppingFacade.getToppings(connectionPool);
        request.setAttribute("toppingMap", toppingMap);
        request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
