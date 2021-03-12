package controller;

import model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private static List<Customer> CustomerList;

    @Override
    public void init() throws ServletException {
        CustomerList = new ArrayList<>();
        CustomerList.add(new Customer("Trần Quốc Hoàng", "17/10/1995", "Quảng Nam", "img/avatar_1.jpg"));
        CustomerList.add(new Customer("Trần Quốc Hoàng", "17/10/1995", "Quảng Nam", "img/avatar_1.jpg"));
        CustomerList.add(new Customer("Trần Quốc Hoàng", "17/10/1995", "Quảng Nam", "img/avatar.png"));
        CustomerList.add(new Customer("Trần Quốc Hoàng", "17/10/1995", "Quảng Nam", "img/avatar_3.jpg"));
        CustomerList.add(new Customer("Trần Quốc Hoàng", "17/10/1995", "Quảng Nam", "img/avatar_4.jpg"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("CustomerList",CustomerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request,response);
    }
}
