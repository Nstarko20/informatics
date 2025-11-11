class Main:
    def sum(self, a, b):
        return a + b

    def subtract(self, a, b):
        return a - b

    def multiply(self, a, b):
        return a * b

    def divide(self, a, b):
        if b == 0:
            raise ValueError("Деление на 0")
        return a / b

    def is_positive(self, number):
        return number > 0


if __name__ == "__main__":
    calc = Main()
    print("5 + 3 =", calc.sum(5, 3))