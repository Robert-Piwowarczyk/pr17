import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculator")
public class Calculator extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String operation = request.getParameter("operation");

        int parsedNumber1;
        int parsedNumber2;

        try {
            parsedNumber1 = Integer.valueOf(number1);
            parsedNumber2 = Integer.valueOf(number2);
        } catch (NumberFormatException exception) {
            System.err.println("To nie jest liczba");
            return;
        }

        int result = 0;
        String mappedOperation = "";
        boolean wrongOperation = false;

        switch (operation) {
            case "dodaj":
                result = parsedNumber1 + parsedNumber2;
                mappedOperation = "+";
                break;
            case "odejmij":
                result = parsedNumber1 - parsedNumber2;
                mappedOperation = "-";
                break;
            case "pomnoz":
                result = parsedNumber1 * parsedNumber2;
                mappedOperation = "*";
                break;
            case "podziel":
                result = parsedNumber1 / parsedNumber2;
                mappedOperation = "/";
                break;
            default:
                wrongOperation = true;
        }

        if (wrongOperation) {
            System.err.println("Błędna operacja");
        } else {
            System.out.println(number1 + " " + mappedOperation + " " + number2 + " = " + result);
        }
    }
}