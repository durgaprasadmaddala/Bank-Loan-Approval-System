package dao;

import java.util.List;

import model.Admin;
import model.Loan;
import model.User;

public interface UserInterface {
	boolean registerUser(User user);

    User loginUser(String email, String password);
    
    boolean applyLoan(Loan loan);

    List<Loan> getLoansByUserId(int userId);

    List<Loan> getAllLoans();

    boolean updateLoanStatus(int loanId, String status);
    
    Admin loginAdmin(String username, String password);

}
