package org.example;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello and welcome");
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) throw new IllegalArgumentException("Деление на 0");
        return (double) a / b;
    }

    public boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public int maxOfThree(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}