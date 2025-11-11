import pytest
from main.main_app import Main


@pytest.fixture
def calc():
    return Main()


@pytest.mark.math
def test_add(calc):
    result = calc.sum(2, 3)
    assert result == 5


@pytest.mark.math
def test_subtract(calc):
    result = calc.subtract(10, 4)
    assert result == 7


@pytest.mark.math
def test_multiply(calc):
    result = calc.multiply(3, 4)
    assert result == 12


@pytest.mark.math
def test_divide(calc):
    result = calc.divide(8, 2)
    assert result == 4


@pytest.mark.exceptions
def test_divide_by_zero(calc):
    with pytest.raises(ValueError):
        calc.divide(5, 0)


@pytest.mark.exceptions
def test_negative_number(calc):
    assert calc.is_positive(-5) is False


@pytest.mark.logic
def test_is_positive(calc):
    assert calc.is_positive(5) is True


@pytest.mark.parametrize(
    "a,b,expected",
    [
        (1, 2, 3),
        (5, 5, 10),
        (-1, 1, 0),
    ],
)
@pytest.mark.math
def test_add_parametrized(calc, a, b, expected):
    assert calc.sum(a, b) == expected
