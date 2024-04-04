package Controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.RegisterDAO;
import MODEL.UserBean;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Retrieve user registration details from the form
            String userName = request.getParameter("userName");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            long adharNumber = Long.parseLong(request.getParameter("adharNumber"));
            String dob = request.getParameter("dateOfBirth");
            String accountType = request.getParameter("accountType");
            double balance = Double.parseDouble(request.getParameter("balance"));
            String password = request.getParameter("PasswordHash");

            // Generate a random account number
            long accountNumber = generateRandomAccountNumber();

            // Create a UserBean object with the retrieved details
            UserBean user = new UserBean();
            user.setAccountNumber(accountNumber);
            user.setUserName(userName);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setAdharNumber(adharNumber);
            user.setDateOfBirth(dob);
            user.setAccountType(accountType);
            user.setBalance(balance);
            user.setPasswordHash(password);

            // Insert the user into the database
            RegisterDAO userDAO = new RegisterDAO();
            boolean registrationSuccessful = userDAO.insert(user);

            // Forward to a JSP page for rendering the result
            if (registrationSuccessful) {
                request.setAttribute("message", "<h2 style='color: green;'>Welcome to Your Bank</h2>");
                request.getRequestDispatcher("Login.html").forward(request, response);
            } else {
                request.setAttribute("message", "<h2 style='color: rgb(241, 9, 9);'>Registration Failed</h2>");
                request.getRequestDispatcher("Register.html").forward(request, response);
            }
        } catch (NumberFormatException e) {
            // Handle the exceptions (e.g., provide an error message or redirect to an error page)
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }

    private long generateRandomAccountNumber() {
        // This is a simple example; you might want to use a more secure method for generating account numbers
        Random random = new Random();
        return 1000000000L + random.nextInt(900000000); // Generates a 10-digit random number
    }
}
