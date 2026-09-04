package servlets;

import java.io.IOException;

import dao.UserDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/loanApproval")
public class LoanApprovalServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int loanId =
                Integer.parseInt(request.getParameter("loanId"));

            String status =
                request.getParameter("status");

            UserDAOImpl dao = new UserDAOImpl();

            boolean result =
                dao.updateLoanStatus(loanId, status);

            if (result) {

                // Reload loan list after update
                response.sendRedirect("viewLoans");

            } else {

                request.setAttribute("error",
                        "Failed to update loan status");

                request.getRequestDispatcher("admindashboard.jsp")
                       .forward(request, response);
            }

        } catch (Exception e) {

            e.printStackTrace();

            request.setAttribute("error",
                    "Something went wrong");

            request.getRequestDispatcher("admindashboard.jsp")
                   .forward(request, response);
        }
    }
}