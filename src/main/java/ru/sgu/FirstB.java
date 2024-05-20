package main.java.ru.sgu;

import java.math.BigDecimal;
import java.util.Scanner;

public class FirstB {
    public static void solve() {
        System.out.println("Enter the input!");
        Scanner sc = new Scanner(System.in);
        String[] parsedString = sc.nextLine().split("\\s+");
        if (parsedString.length != 3) {
            System.out.println("Wrong number of arguments!");
            System.exit(1);
        }
        try {
            Number result = getResult(parsedString);
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("Wrong format input!");
            System.exit(1);
        } catch (ArithmeticException e) {
            System.out.println("Divide by zero!");
            System.exit(1);
        }

    }

    private static Number getResult(String[] parsedString) {
        BigDecimal first = new BigDecimal(parsedString[0]);
        BigDecimal second = new BigDecimal(parsedString[1]);
        String opCode = parsedString[2];
        BigDecimal result = switch (opCode) {
            case ("ADD") -> first.add(second);
            case ("SUB") -> first.subtract(second);
            case ("MULT") -> first.multiply(second);
            case ("DIV") -> first.divide(second);
            case ("REM") -> first.remainder(second);
            case ("POW") -> first.pow(second.intValue());
            default -> null;
        };
        if (result == null) throw new NumberFormatException();
        return result;
    }
}
