package com.zhugaru.calculator;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final String input = sc.nextLine();

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.evaluate(input));
    }
}
