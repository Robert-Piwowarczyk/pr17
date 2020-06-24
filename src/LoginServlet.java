import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        if ("admin".equals(login) && "admin".equals(password)) {
            response.getWriter().println("Zalogowano pomyślnie");
        } else {
            response.getWriter().println("Niepoprawne dane logowania");
        }
    }
}