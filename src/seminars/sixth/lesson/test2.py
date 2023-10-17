from unittest import TestCase, main
import pytest
from main2 import main


class Test(TestCase):

    def test_main(self):
        lst = [1, 2, 3, 4, 5, 6, 7, 8, 9]
        mid = main(lst)
        self.assertEquals(mid, 5)

    def test_main_2(self):
        lst = 'sdfsfd'
        with pytest.raises(TypeError):
            main(lst)


if __name__ == "__main__":
    lst = [1, 2, 3, 4, 5]
    main(lst)
