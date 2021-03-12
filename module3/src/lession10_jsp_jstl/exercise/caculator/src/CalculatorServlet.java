import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float first_number = Float.parseFloat(request.getParameter("f_num"));
        float second_number = Float.parseFloat(request.getParameter("s_num"));
        float result;
        char operator = request.getParameter("operator").charAt(0);
        switch (operator){
            case '+':
                result = first_number + second_number;
                break;
            case '-':
                result = first_number - second_number;
                break;
            case '*':
                result = first_number * second_number;
                break;
            case '/':
                if (second_number != 0) {
                    result = first_number / second_number;
                } else {
                    throw new RuntimeException("không thể chia cho 0");
                }
                break;
            default:
                throw new RuntimeException("Không tồn tại phép tính này");
        }

        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<h1>Result:");
        try {
            pw.println(first_number + " " + operator + " " + second_number + " = " + result);
        } catch (Exception ex){
            pw.println("Error: " + ex.getMessage());
        }
        pw.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
