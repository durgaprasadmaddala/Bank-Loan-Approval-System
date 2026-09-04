package servlets;

import java.io.IOException;
import java.util.List;

import dao.UserDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Loan;

@WebServlet("/loanStatus")
public class LoanStatusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int userId = (Integer) session.getAttribute("userId");

        UserDAOImpl dao = new UserDAOImpl();

        List<Loan> loans = dao.getLoansByUserId(userId);

        request.setAttribute("loanList", loans);

        request.getRequestDispatcher("loanStatus.jsp")
               .forward(request, response);
    }
}
