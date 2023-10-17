class ListComparator:
    """
    Класс сравнивает списки
    """

    def calculate_average(self, numbers):
        """
        :param numbers:
        :return:
        """

        if not isinstance(numbers, list):
            raise TypeError("Аргумент должен быть списком")
        if not numbers:
            return 0
        return sum(numbers) / len(numbers)

    def compare_lists(self, list1, list2):
        """
        :param list1:
        :param list2:
        :return:
        """
        avg1 = self.calculate_average(list1)
        avg2 = self.calculate_average(list2)

        if avg1 > avg2:
            return "Первый список имеет большее среднее значение"
        if avg1 < avg2:
            return "Второй список имеет большее среднее значение"
        if avg1 == avg2:
            return "Средние значения равны"
