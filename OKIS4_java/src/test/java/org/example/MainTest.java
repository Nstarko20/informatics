package org.example;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainTest {
    private Main bank;

    @BeforeMethod
    public void setUp() {
        bank = new Main(1000.0);
    }

    // 1. Тест пополнения счета
    @Test(groups = {"operations", "positive"})
    public void testDeposit() {
        bank.deposit(500.0);
        Assert.assertEquals(bank.getBalance(), 1500.0);
    }

    // 2. Тест снятия средств
    @Test(groups = {"operations", "positive"})
    public void testWithdraw() {
        bank.withdraw(300.0);
        Assert.assertEquals(bank.getBalance(), 700.0);
    }

    // 3. Тест получения баланса
    @Test(groups = {"operations", "positive"})
    public void testGetBalance() {
        Assert.assertEquals(bank.getBalance(), 1000.0);
    }

    // 4. Тест исключения при отрицательном депозите
    @Test(groups = {"exceptions"})
    public void testDepositNegativeAmount() {
        Assert.assertThrows(IllegalArgumentException.class,
                () -> bank.deposit(-100.0));
    }

    // 5. Тест исключения при недостатке средств
    @Test(groups = {"exceptions"})
    public void testWithdrawInsufficientFunds() {
        Assert.assertThrows(IllegalArgumentException.class,
                () -> bank.withdraw(2000.0));
    }

    // 6. Тест расчета процентов
    @Test(groups = {"calculations", "positive"})
    public void testCalculateInterest() {
        double interest = bank.calculateInterest(30);
        Assert.assertEquals(interest, 4.11, 0.01);
    }

    // 7. Тест расчета платежа по кредиту
    @Test(groups = {"calculations", "positive"})
    public void testCalculateLoanPayment() {
        double payment = bank.calculateLoanPayment(10000.0, 12);
        Assert.assertEquals(payment, 888.49, 0.01);
    }
}