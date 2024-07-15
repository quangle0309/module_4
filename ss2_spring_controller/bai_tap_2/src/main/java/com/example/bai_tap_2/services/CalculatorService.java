package com.example.bai_tap_2.services;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public double calculate(double firstNumber, double lastNumber, String operator) {
        double result = 0;
        switch (operator){
            case "+":
                result = firstNumber + lastNumber;
                break;
            case "-":
                result = firstNumber - lastNumber;
                break;
            case "*":
                result = firstNumber * lastNumber;
                break;
            case "/":
                if (lastNumber != 0) {
                    result = firstNumber / lastNumber;
                } else {
                    throw new ArithmeticException("Không thể chia một số bất kì cho 0!!!");
                }
                break;

        }
        return result;
    }
}
