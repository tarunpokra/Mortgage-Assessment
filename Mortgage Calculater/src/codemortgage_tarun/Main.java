package codemortgage_tarun;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        System.out.println("Hello World, testing setup!");
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        // constant variables

        int principle = 0;

        float monthlyInterest = 0;
        int numberOfPayments = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Principle: ");
            principle = scanner.nextInt();
            if (principle >- 1000 && principle <= 1_000_000)
                break;
            System.out.println("Enter a value between 1000 and 1,000,000");
        }
        while (true) {


            System.out.println("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();
            if (annualInterest >=1 && annualInterest <= 30) {
                 monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
            break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        while (true) {


            System.out.println("Period in (Years): ");

            byte years = scanner.nextByte();
            if (years >=1 && years <= 30){
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }
        double mortgage = principle
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

        String mortgageFormat = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormat);

    }
}
