
 package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LoginDAO;
import MODEL.UserBean;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter pw = res.getWriter();
        res.setContentType("text/html");

        UserBean user = new LoginDAO().loginUser(req);

        if (user == null) {
            pw.println("Invalid username or password. Please try again.");

            RequestDispatcher rd = req.getRequestDispatcher("Login.html");
            rd.include(req, res);
        } else {
        	HttpSession session = req.getSession();
        	session.setAttribute("getUserDetails", user);



            pw.println("Welcome, " + user.getUserName() + "<br>");

            RequestDispatcher rd = req.getRequestDispatcher("Page.html");
            rd.include(req, res);
        }
    }
}
 
