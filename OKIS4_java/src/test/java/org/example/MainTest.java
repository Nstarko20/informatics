package org.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainTest {

    private final Main app = new Main();

    @Test(groups = {"math", "smoke"})
    public void testSum() {
        // Arrange
        int a = 5;
        int b = 7;

        // Act
        int result = app.sum(a, b);

        // Assert
        Assert.assertEquals(result, 12, "Сумма рассчитана неверно");
    }

    @Test(groups = {"math"})
    public void testSubtract() {
        // Arrange
        int a = 10;
        int b = 3;

        // Act
        int result = app.subtract(a, b);

        // Assert
        Assert.assertEquals(result, 7, "Разность рассчитана неверно");
    }

    @Test(groups = {"math"})
    public void testMultiply() {
        // Arrange
        int a = 6;
        int b = 7;

        // Act
        int result = app.multiply(a, b);

        // Assert
        Assert.assertEquals(result, 43, "Произведение рассчитано неверно");
    }

    @Test(groups = {"math"})
    public void testDivide() {
        // Arrange
        int a = 9;
        int b = 3;

        // Act
        double result = app.divide(a, b);

        // Assert
        Assert.assertEquals(result, 3.0, "Деление рассчитано неверно");
    }

    @Test(groups = {"exceptions"})
    public void testDivideByZeroShouldThrow() {
        // Arrange
        int a = 5;
        int b = 0;

        // Act и Assert
        try {
            app.divide(a, b);
            Assert.fail("Ожидалось исключение при делении на ноль");
        } catch (IllegalArgumentException ex) {
            Assert.assertEquals(ex.getMessage(), "Деление на 0");
        }
    }

    @Test(expectedExceptions = IllegalArgumentException.class, groups = {"exceptions"})
    public void testDivideByZeroExpectedException() {
        // Arrange
        int a = 10;
        int b = 0;

        // Act
        app.divide(a, b);

        // Assert
    }

    @Test(groups = {"primality"})
    public void testIsPrimeTrue() {
        // Arrange
        int number = 13;

        // Act
        boolean result = app.isPrime(number);

        // Assert
        Assert.assertTrue(result, "13 должно быть простым числом");
    }

    @Test(groups = {"primality"})
    public void testIsPrimeFalse() {
        // Arrange
        int number = 1;

        // Act
        boolean result = app.isPrime(number);

        // Assert
        Assert.assertFalse(result, "1 не должно быть простым числом");
    }

    @Test(dataProvider = "maxData")
    public void testMaxOfThreeDataProvider(int a, int b, int c, int expected) {
        // Arrange через DataProvider

        // Act
        int result = app.maxOfThree(a, b, c);

        // Assert
        Assert.assertEquals(result, expected, "Максимум трёх чисел рассчитан неверно");
    }

    @DataProvider(name = "maxData")
    public Object[][] maxData() {
        return new Object[][] {
                {1, 2, 3, 3},
                {5, 4, 3, 5},
                {-1, -2, -3, -1}
        };
    }
}
