import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        System.out.println("_____ Mortgage Calculator _____");

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Principle: ");
        int principle = input.nextInt();
        System.out.print("Enter Annual Interest Rate: ");
        float annualInterestRate = input.nextFloat();
        float monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / PERCENT;

        System.out.print("Enter Period in Years: ");
        byte years = input.nextByte();
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principle * (monthlyInterestRate * Math.pow(1+monthlyInterestRate, numberOfPayments))
                / ((Math.pow(1+monthlyInterestRate, numberOfPayments)-1)) ;

        String mortgageFormatted =  NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortgage: " + mortgageFormatted);

    }
}