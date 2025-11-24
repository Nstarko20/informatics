class MainApp:
    def __init__(self, initial_balance):
        if initial_balance < 0:
            raise ValueError("Начальный баланс не может быть отрицательным")
        self.balance = initial_balance

    def deposit(self, amount):
        if amount <= 0:
            raise ValueError("Сумма депозита должна быть положительной")
        self.balance += amount

    def withdraw(self, amount):
        if amount <= 0:
            raise ValueError("Сумма снятия должна быть положительной")
        if amount > self.balance:
            raise ValueError("Недостаточно средств")
        self.balance -= amount

    def get_balance(self):
        return self.balance

    def calculate_interest(self, days):
        if days <= 0:
            raise ValueError("Количество дней должно быть положительным")
        annual_rate = 0.05
        return self.balance * annual_rate * days / 365

    def calculate_loan_payment(self, loan_amount, months):
        if loan_amount <= 0 or months <= 0:
            raise ValueError("Параметры кредита должны быть положительными")
        annual_rate = 0.12
        monthly_rate = annual_rate / 12
        return (loan_amount * monthly_rate) / (1 - (1 + monthly_rate) ** -months)