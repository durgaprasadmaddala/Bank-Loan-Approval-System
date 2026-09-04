package model;

public class Loan {

    private int loanId;
    private int userId;

    // New Fields
    private String userName;
    private String phone;

    private double income;
    private double expenses;
    private double loanAmount;
    private int duration;
    private double emi;
    private String status;

    public Loan() {
    }

    public Loan(int loanId, int userId, String userName, String phone,
                double income, double expenses,
                double loanAmount, int duration,
                double emi, String status) {

        this.loanId = loanId;
        this.userId = userId;
        this.userName = userName;
        this.phone = phone;
        this.income = income;
        this.expenses = expenses;
        this.loanAmount = loanAmount;
        this.duration = duration;
        this.emi = emi;
        this.status = status;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    // User Name
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Phone Number
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getEmi() {
        return emi;
    }

    public void setEmi(double emi) {
        this.emi = emi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}