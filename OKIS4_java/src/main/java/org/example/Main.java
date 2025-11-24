package org.example;

public class Main {
    private double balance;

    public Main(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Начальный баланс не может быть отрицательным");
        }
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма депозита должна быть положительной");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма снятия должна быть положительной");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Недостаточно средств");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public double calculateInterest(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Количество дней должно быть положительным");
        }
        double annualRate = 0.05;
        return balance * annualRate * days / 365;
    }

    public double calculateLoanPayment(double loanAmount, int months) {
        if (loanAmount <= 0 || months <= 0) {
            throw new IllegalArgumentException("Параметры кредита должны быть положительными");
        }
        double annualRate = 0.12;
        double monthlyRate = annualRate / 12;
        return (loanAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -months));
    }
}