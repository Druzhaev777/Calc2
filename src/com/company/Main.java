package com.company;
import java.io.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        String main = "\\d+\\s[+,\\-, *, %, /, ^]\\s\\d+"; //класс для чтения регулярного выражения
        double result = 0;
        String inputString;
        try (BufferedReader dep = new BufferedReader(new FileReader("D://input.txt"));
             BufferedWriter tu = new BufferedWriter(new FileWriter("D://output.txt"))) {

            while ((inputString = dep.readLine()) != null) {
                //System.out.println(inputString);
                if ((inputString.trim().matches(main))) {
                    result = calculate(inputString.split(" "), result);
                    tu.write(result + "\n");
                    System.out.println(result);
                } else {tu.write("Введите, пожуй лыста правильно" + "\n");
                    System.out.println("Непральна дядя Фёдор!");
                }
            }
        }
    }

    private static double calculate(String[] split, double previousResult) throws Exception {
        double result;
        String operand;
        double number1;
        double number2;
        if (split.length == 3) {
            number1 = Double.parseDouble(split[0]);
            operand = split[1];
            number2 = Double.parseDouble(split[2]);
        } else if (split.length == 2) {
            number1 = previousResult;
            operand = split[0];
            number2 = Double.parseDouble(split[1]);
        } else {
            throw new Exception("Всё фигня, давай по новой !");
        }
        switch (operand) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
                break;
            case "^":
                result = Math.pow(number1, number2);
                break;
            case "%":
                result = number1 % number2;
                break;
            default:
                throw new Exception("Ну будь человеком!");
        }
        return result;
    }
}


/*
 *метод возвращает  результат математического выражения обработанного блоке switch case, в котором находится одно
 * значение, с которым сравнивается значение переменной,и инструкция в виде программного кода
 *
 * @param split делит строку на подстроки с помощью регулярного выражения
 * @param previousResult предыдущий результат
 * @return результат математичеких выражений
 * @throws Exception предупреждяет об исключении
 * Метод parse используется для извлечения из строки числового значения необходимого типа
 * switch case-это блок, в котором находится одно значение, с которым сравнивается значение переменной
 */

