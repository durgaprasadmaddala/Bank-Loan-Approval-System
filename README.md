# Bank-Loan-Approval-System
🏦 Bank Loan Approval Management System — A Java-based application designed to manage users, loan applications, income, expenses, loan amounts, duration, EMI, and approval status. Built with MySQL database integration and admin management, this project demonstrates practical Java, SQL, and database development skills.
# 🏦 Bank Loan Approval Management System

The **Bank Loan Approval Management System** is an advanced Java-based application designed to simplify and manage the loan approval process digitally. The system provides separate functionality for users and administrators, making it easier to manage customer information, loan applications, financial details, and loan approval status.

## 🚀 Project Overview

This application allows users to register and maintain their personal information, including name, email, phone number, Aadhaar, PAN, and address. Users can submit loan-related information such as income, expenses, requested loan amount, loan duration, and EMI.

Administrators can manage user and loan information and monitor the status of loan applications.

## ✨ Key Features

### 👤 User Management

* User registration and login
* Store customer personal details
* Email uniqueness
* Manage phone, Aadhaar, PAN, and address information

### 💰 Loan Management

* Submit loan applications
* Store income and expenses
* Enter requested loan amount
* Specify loan duration
* Store EMI details
* Track loan approval status

### 👨‍💼 Admin Management

* Admin login
* Manage user information
* View loan applications
* Monitor loan status

## 🗄️ Database

The project uses a **MySQL database** named `loanapproval`.

Main tables:

* `users`
* `loans`
* `admin`

The `users` table stores customer details, while the `loans` table stores financial and loan application information. The `admin` table manages administrator credentials.

## 🛠️ Technologies

* Java
* MySQL
* SQL
* Git & GitHub
* GitHub Pages workflow

## 🎯 Objective

The main objective of this project is to create a structured digital system for managing bank loan applications and reducing manual effort in handling customer and loan information.

## 📂 Project Structure

```text
Bank-Loan-Approval-Management-System/
│
├── README.md
├── Database.sql
├── static.yml
└── project source files
```

The repository also includes a GitHub Actions workflow configured to deploy static content to GitHub Pages.

## 🔮 Future Enhancements

* Automatic loan eligibility calculation
* Secure password encryption
* Online document verification
* EMI calculator
* Loan application tracking
* Email/SMS notifications
* Improved admin dashboard
* Role-based authentication

## 👨‍💻 Conclusion

This project demonstrates how Java, SQL, and database concepts can be combined to build a practical **Bank Loan Approval Management System**. It provides a foundation for developing a more complete banking and financial management application.
