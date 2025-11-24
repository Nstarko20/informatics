import pytest
from main.main_app import MainApp


class TestMainApp:
    @pytest.fixture
    def bank(self):
        return MainApp(1000.0)

    # 1. Тест пополнения счета
    @pytest.mark.operations
    @pytest.mark.positive
    def test_deposit(self, bank):
        bank.deposit(500.0)
        assert bank.get_balance() == 1500.0

    # 2. Тест снятия средств
    @pytest.mark.operations
    @pytest.mark.positive
    def test_withdraw(self, bank):
        bank.withdraw(300.0)
        assert bank.get_balance() == 700.0

    # 3. Тест получения баланса
    @pytest.mark.operations
    @pytest.mark.positive
    def test_get_balance(self, bank):
        assert bank.get_balance() == 1000.0

    # 4. Тест исключения при отрицательном депозите
    @pytest.mark.exceptions
    def test_deposit_negative_amount(self, bank):
        with pytest.raises(ValueError, match="Сумма депозита должна быть положительной"):
            bank.deposit(-100.0)

    # 5. Тест исключения при недостатке средств
    @pytest.mark.exceptions
    def test_withdraw_insufficient_funds(self, bank):
        with pytest.raises(ValueError, match="Недостаточно средств"):
            bank.withdraw(2000.0)

    # 6. Тест расчета процентов
    @pytest.mark.calculations
    @pytest.mark.positive
    def test_calculate_interest(self, bank):
        interest = bank.calculate_interest(30)
        assert interest == pytest.approx(4.11, 0.01)

    # 7. Тест расчета платежа по кредиту
    @pytest.mark.calculations
    @pytest.mark.positive
    def test_calculate_loan_payment(self, bank):
        payment = bank.calculate_loan_payment(10000.0, 12)
        assert payment == pytest.approx(888.49, 0.01)