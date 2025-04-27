# Online Bank Account Management System

## Project Overview
This is a simple Java console-based application that allows users to manage a bank account.  
Users can create an account, deposit money, withdraw money, and check their account balance.  
The program focuses on strong exception handling practices.

## Features
- Create a new bank account
- Deposit money
- Withdraw money
- View current balance
- Handles errors and invalid inputs

## Exception Handling
- **InvalidAmountException**: Thrown when depositing or withdrawing a non-positive amount.
- **InsufficientFundsException**: Thrown when withdrawing more than the available balance.
- **InputMismatchException**: Catches non-numeric inputs.
- **General Exception Handling**: For unexpected errors.
- **try-catch-finally**: Used for safe execution and closing resources.
- **throw** and **throws**: Used for custom error handling.

## Project Structure
- `BankSystem.java` — contains all classes including:
  - `BankAccount`
  - `InvalidAmountException`
  - `InsufficientFundsException`
  - Main method
