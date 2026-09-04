package servlets;

import java.io.IOException;

import dao.UserDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Loan;

@WebServlet("/applyLoan")
public class ApplyLoanServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int userId = (Integer) session.getAttribute("userId");

        double income = Double.parseDouble(request.getParameter("income"));
        double expenses = Double.parseDouble(request.getParameter("expenses"));
        double loanAmount = Double.parseDouble(request.getParameter("loanAmount"));
        int duration = Integer.parseInt(request.getParameter("duration"));
        double emi = Double.parseDouble(request.getParameter("emi"));

        Loan loan = new Loan();

        loan.setUserId(userId);
        loan.setIncome(income);
        loan.setExpenses(expenses);
        loan.setLoanAmount(loanAmount);
        loan.setDuration(duration);
        loan.setEmi(emi);
        loan.setStatus("Pending");

        UserDAOImpl dao = new UserDAOImpl();

        boolean status = dao.applyLoan(loan);

        System.out.println("Loan Applied = " + status);

        if (status) {
            response.sendRedirect("loanStatus");
        } else {
            response.getWriter().println("Loan Application Failed");
        }
    }
}