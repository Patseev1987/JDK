package org.example.sem3;

public  class Calculator {
    private Calculator() {
    }

    public static <T extends Number, U extends Number> double sum(T num1, U num2 ){
        return num1.doubleValue() + num2.doubleValue();
    }

    public static <T extends Number, U extends Number> double subtract(T num1, U num2 ){
        return num1.doubleValue() - num2.doubleValue();
    }

    public static <T extends Number, U extends Number> double multiply(T num1, U num2 ){
        return num1.doubleValue() * num2.doubleValue();
    }

    public static <T extends Number, U extends Number> double divide(T num1, U num2 ){
        if (num2.doubleValue() != 0) {
            return num1.doubleValue() / num2.doubleValue();
        }else {
            throw new ArithmeticException("You can't divide by 0");
        }

    }

}
