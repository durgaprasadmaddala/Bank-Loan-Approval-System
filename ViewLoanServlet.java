package servlets;

import java.io.IOException;
import java.util.List;

import dao.UserDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Loan;

@WebServlet("/viewLoans")
public class ViewLoanServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        UserDAOImpl dao = new UserDAOImpl();

        List<Loan> loans = dao.getAllLoans();

        request.setAttribute("loanList", loans);

        request.getRequestDispatcher("admindashboard.jsp")
               .forward(request, response);
    }
}