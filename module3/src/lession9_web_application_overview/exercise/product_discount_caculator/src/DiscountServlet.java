import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet ", urlPatterns = "/display-discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Trang kết quả sẽ hiển thị các thông tin ngươờ dùng nhập vào, kèm theo kết quả tính toán:
//        Discount Amount: Lượng chiết khấu
//        Discount Price: Giá sau khi đã được chiết khấu
//        Công thức tính chiết khấu là:
//        Discount Amount = List Price * Discount Percent * 0.01
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        float discount_percent = Float.parseFloat(request.getParameter("discount_percent"));
        double discount_amount = price * discount_percent * 0.01;
        double discount_price = price - discount_amount;

        PrintWriter pw = response.getWriter();
        pw.println("<html>");
        pw.println("<h2>Description:" + description + "</h2>");
        pw.println("<h2>Price:" + price + " billion vnd</h2>");
        pw.println("<h2>Discount percent:" + discount_percent + "%</h2>");
        pw.println("<h2>Discount amount:" + discount_amount + " billion vnd</h2>");
        pw.println("<h2>Discount price:" + discount_price + " billion vnd</h2>");
        pw.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
