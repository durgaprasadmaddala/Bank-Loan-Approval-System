package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Admin;
import model.Loan;
import model.User;
import utility.DBconnections;

public class UserDAOImpl implements UserInterface {

	Connection con = null;
	String status = "fail";

	public UserDAOImpl() {
		DBconnections dbc = new DBconnections();
		con = dbc.getConnection();

		System.out.println("Connection = " + con);
	}

	@Override
	public boolean registerUser(User user) {

		try {

			DBconnections dbc = new DBconnections();
			con = dbc.getConnection();

			String query = "INSERT INTO users(name,email,password,phone,aadhar,pan,address) VALUES(?,?,?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getPhone());
			ps.setString(5, user.getAadhaar());
			ps.setString(6, user.getPan());
			ps.setString(7, user.getAddress());

			int rows = ps.executeUpdate();

			return rows > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// User Login
	@Override
	public User loginUser(String email, String password) {

		User user = null;

		try {
			DBconnections dbc = new DBconnections();
			con = dbc.getConnection();
			String query = "SELECT * FROM users WHERE email=? AND password=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user = new User();

				user.setUserId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	// Apply Loan
	@Override
	public boolean applyLoan(Loan loan) {

		try {

			String query = "INSERT INTO loans(user_id,income,expenses,loan_amount,duration,emi,status) VALUES(?,?,?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setInt(1, loan.getUserId());
			ps.setDouble(2, loan.getIncome());
			ps.setDouble(3, loan.getExpenses());
			ps.setDouble(4, loan.getLoanAmount());
			ps.setInt(5, loan.getDuration());
			ps.setDouble(6, loan.getEmi());
			ps.setString(7, loan.getStatus());

			return ps.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// View User Loans
	@Override
	public List<Loan> getLoansByUserId(int userId) {

		List<Loan> list = new ArrayList<>();

		try {

			String query = "SELECT * FROM loans WHERE user_id=?";

			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Loan loan = new Loan();

				loan.setLoanId(rs.getInt("loan_id"));
				loan.setUserId(rs.getInt("user_id"));
				loan.setIncome(rs.getDouble("income"));
				loan.setExpenses(rs.getDouble("expenses"));
				loan.setLoanAmount(rs.getDouble("loan_amount"));
				loan.setDuration(rs.getInt("duration"));
				loan.setEmi(rs.getDouble("emi"));
				loan.setStatus(rs.getString("status"));

				list.add(loan);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// View All Loans
	public List<Loan> getAllLoans() {

	    List<Loan> list = new ArrayList<>();

	    try {

	        String query =
	            "SELECT l.*, u.name, u.phone " +
	            "FROM loans l " +
	            "INNER JOIN users u " +
	            "ON l.user_id = u.user_id";

	        PreparedStatement ps =
	            con.prepareStatement(query);

	        ResultSet rs = ps.executeQuery();

	        while(rs.next()) {

	            Loan loan = new Loan();

	            loan.setLoanId(rs.getInt("loan_id"));
	            loan.setUserId(rs.getInt("user_id"));
	            loan.setUserName(rs.getString("name"));
	            loan.setPhone(rs.getString("phone"));
	            loan.setIncome(rs.getDouble("income"));
	            loan.setExpenses(rs.getDouble("expenses"));
	            loan.setLoanAmount(rs.getDouble("loan_amount"));
	            loan.setDuration(rs.getInt("duration"));
	            loan.setEmi(rs.getDouble("emi"));
	            loan.setStatus(rs.getString("status"));

	            list.add(loan);
	        }

	    } catch(Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}

	// Approve/Reject Loan
	@Override
	public boolean updateLoanStatus(int loanId, String status) {

	    try {

	        System.out.println("Loan ID = " + loanId);
	        System.out.println("Status = " + status);

	        String query =
	                "UPDATE loans SET status=? WHERE loan_id=?";

	        PreparedStatement ps =
	                con.prepareStatement(query);

	        ps.setString(1, status);
	        ps.setInt(2, loanId);

	        int rows = ps.executeUpdate();

	        System.out.println("Rows Updated = " + rows);

	        return rows > 0;

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return false;
	}

	// Admin Login
	@Override
	public Admin loginAdmin(String username, String password) {

		Admin admin = null;

		try {

			String query = "SELECT * FROM admin WHERE username=? AND password=?";

			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				admin = new Admin();

				admin.setAdminId(rs.getInt("admin_id"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return admin;
	}
}
