package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.TransferMoneyDAO;

@WebServlet("/transferMoney")
public class TransferMoneyServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");

        // Retrieve data from the request
        long senderAccountNumber = Long.parseLong(request.getParameter("senderAccountNumber"));
        long receiverAccountNumber = Long.parseLong(request.getParameter("receiverAccountNumber"));
        double amount = Double.parseDouble(request.getParameter("amount"));

        // Perform the money transfer
        TransferMoneyDAO transferMoneyDAO = new TransferMoneyDAO();
        boolean transferSuccessful =false;
		try {
			transferSuccessful = transferMoneyDAO.transferMoney(senderAccountNumber, receiverAccountNumber, amount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Handle the result
        if (transferSuccessful) {
            pw.println("Money transfer successful!");
        } else {
            pw.println("Money transfer failed. Please check your input or try again later.");
        }
    }
}
