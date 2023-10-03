package seminars.first.model;

import java.util.Scanner;

public class Calculator {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        int firstOperand = getOperand();
//        int secondOperand = getOperand();
//        char operator = getOperator();
//        int result = calculation(firstOperand, secondOperand, operator);
//        System.out.println("Operation result is: " + result);

//        System.out.println(calculatingDiscount(-100, 25));

    }

    public static char getOperator() {
        System.out.println("Enter operation: ");
        char operation = scanner.next().charAt(0);
        return operation;
    }

    public static int getOperand() {
        System.out.println("Enter operand: ");
        int operand;
        if (scanner.hasNextInt()) {
            operand = scanner.nextInt();
        } else {
            System.out.println("You have mistaken, try again");
            if (scanner.hasNext()) {
                scanner.next();
                operand = getOperand();
            } else {
                throw new IllegalStateException("Input error");
            }
        }
        return operand;
    }

    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    public static double squareRootExtraction(double number) {
        //  0
        //  Отрицательные числа
        //  Дробные значения корней
        //  Целые
        if (number == 0) {
            throw new ArithmeticException("It is not possible to extract the root from 0");
        }
        if (number < 0) {
            throw new ArithmeticException("It is impossible to extract the root from negative numbers");
        }

        double t;
        double squareRoot = number / 2;
        do {
            t = squareRoot;
            squareRoot = (t + (number / t)) / 2;
        }
        while ((t - squareRoot) != 0);
        return squareRoot;

        // или просто return Math.sqrt(number);
    }

    /**
     * @param purchaseAmount сумма покупки
     * @param discountAmount размер скидки
     * @return возвращает сумму покупки с учетом скидки
     */
    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        if (purchaseAmount >= 0.0 && discountAmount >= 0) {
            double discount = purchaseAmount * discountAmount / 100.0;
            double total = purchaseAmount - discount;
            return total > 0 ? total : 0;
        } else {
            throw new ArithmeticException("Недопустимые аргументы");
        }

    }

    /**
     * Заадние 2 лекциию Добавьте функции возведения в степень в калькулятор и протестируйте
     */
    public static int pow(int value, int powwValue) {
        int result = 1;
        for (int a = 1; a <= powwValue; a++) {
            if (a == 0) return 1;
            result = result * value;
        }
        return result;
        //Math.pow(value, powValue); //можно было и так
    }
}