package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DetailsDAO;
import MODEL.UserBean;

@WebServlet("/userDetails")
public class UserDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

	
	 
	 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long accountNumber = Long.parseLong(request.getParameter("accountNumber"));
        
       DetailsDAO accountDetailsDAO = new DetailsDAO();
        DetailsDAO accountDetails = DetailsDAO.getUserDetails(accountNumber);

        UserBean ub=new UserBean();
        
        if (ub != null) {
            HttpSession session = request.getSession();
            session.setAttribute("userDetails", ub);
            response.sendRedirect("View.jsp");
        } else {
            response.sendRedirect("page.html");
        }
    }
}
