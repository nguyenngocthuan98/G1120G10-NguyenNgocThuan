package controller;

import model.User;
import service.UserService;
import service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserManagerServlet", urlPatterns = {"", "/users"})
public class UserManagerServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionName = request.getParameter("action");

        if (actionName == null) {
            actionName = "";
        }
        switch (actionName) {
            case "create":
                createNewUser(request, response);
                break;
            case "findById":
                //findUser(request, response);
                break;
            case "update":
                //updateUser(request, response);
                break;
            case "delete":
                //deleteUser(request, response);
                break;
            default:
                listUser(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionName = request.getParameter("action");

        if (actionName == null) {
            actionName = "";
        }
        switch (actionName) {
            case "update":
                //formUpdateUser(request, response);
                break;
            default:
                listUser(request, response);
                break;
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("userList", userService.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createNewUser(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User user = new User(name, email, country);
        userService.create(user);

        listUser(request, response);
    }
}
