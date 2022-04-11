package com.zhugaru.calculator;

import java.util.Objects;
import java.util.Stack;

public class Calculator {
    public String evaluate(String statement) {
        try {
            double result = Calculator.notationToResult(Objects.requireNonNull(Calculator.inputToNotation(statement)));
            if (Double.isInfinite(result)) {
                return null;
            }
            if (result == Math.round(result)) {
                return "" + (int) result;
            }
            return "" + result;
        } catch (Exception e) {
            return null;
        }
    }

    private static String inputToNotation(String input) {
        StringBuilder current = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int priority;
        int unpairBrace = 0;

        for (int i = 0; i < input.length(); i++) {
            priority = getPriority(input.charAt(i));
            if (priority == 0) {
                current.append(input.charAt(i));
            }
            if (priority == 1) {
                stack.push(input.charAt(i));
                unpairBrace++;
            }
            if (priority > 1) {
                current.append(' ');
                while (!stack.empty()) {
                    if (getPriority(stack.peek()) >= priority) {
                        current.append(stack.pop());
                    } else {
                        break;
                    }
                }
                stack.push(input.charAt(i));
            }
            if (priority == -1) {
                current.append(' ');
                unpairBrace--;
                while (getPriority(stack.peek()) != 1)
                    current.append(stack.pop());
                stack.pop();
            }
        }
        while (!stack.empty())
            current.append(stack.pop());
        if (unpairBrace == 0) {
            return current.toString();
        }
        return null;
    }

    private static double notationToResult(String notation) {
        StringBuilder operand = new StringBuilder();
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < notation.length(); i++) {
            if (notation.charAt(i) == ' ')
                continue;
            if (getPriority(notation.charAt(i)) == 0) {
                while (notation.charAt(i) != ' ' && getPriority(notation.charAt(i)) == 0) {
                    operand.append(notation.charAt(i++));
                    if (i == notation.length()) {
                        break;
                    }
                }
                stack.push(Double.parseDouble(operand.toString()));
                operand = new StringBuilder();
            }
            if (getPriority(notation.charAt(i)) > 1) {
                double a = stack.pop(), b = stack.pop();
                if (notation.charAt(i) == '+') {
                    stack.push(b + a);
                }
                if (notation.charAt(i) == '-') {
                    stack.push(b - a);
                }
                if (notation.charAt(i) == '*') {
                    stack.push(b * a);
                }
                if (notation.charAt(i) == '/') {
                    stack.push(b / a);
                }
            }
        }
        return stack.pop();
    }

    private static int getPriority(char token) {
        if (token == '*' || token == '/') {
            return 3;
        }
        if ((token == '+' || token == '-')) {
            return 2;
        }
        if (token == '(') {
            return 1;
        }
        if (token == ')') {
            return -1;
        }
        return 0;
    }
}