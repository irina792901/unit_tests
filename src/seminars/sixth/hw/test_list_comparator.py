import pytest

from list_comparator import ListComparator


@pytest.fixture
def init():
    return ListComparator()


def test_compare_lists_with_different_averages(init):
    list1 = [1, 2, 3, 4, 5]
    list2 = [6, 7, 8, 9, 10]
    assert init.compare_lists(list1, list2) == "Второй список имеет большее среднее значение"


def test_compare_lists_with_different_averages2(init):
    list1 = [6, 7, 8, 9, 10, 11]
    list2 = [1, 2, 3, 4, 5]
    assert init.compare_lists(list1, list2) == "Первый список имеет большее среднее значение"


def test_compare_lists_with_invalid_argument(init):
    with pytest.raises(TypeError):
        init.compare_lists(10, [1, 2, 3, 4, 5])


def test_compare_lists_with_equal_averages(init):
    list1 = [10, 2, 10, 10, 8]
    list2 = [6, 7, 8, 9, 10]
    assert init.compare_lists(list1, list2) == "Средние значения равны"