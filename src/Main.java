import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("_____ Mortgage Calculator _____");

        int principle = (int)readNumber("Enter principle: ", 1000, 1_000_000);
        float annualInterestRate = (float) readNumber("Enter Annual Intrest Rate: ", 1, 30);
        byte years = (byte)readNumber("Enter Period in Years: ",1, 30);

        double mortgage = calculateMortgage(principle, annualInterestRate, years);
        String mortgageFormatted =  NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
    public static double readNumber(String prompt, double min, double max){
        Scanner input = new Scanner(System.in);
        float value;
        while(true) {
            System.out.println(prompt);
            value = input.nextFloat();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " and " + max);
        }
        return value;
    }
    public static double calculateMortgage(
            int principle,
            float annualInterestRate,
            byte years) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        short numberOfPayments = (short)(years * MONTHS_IN_YEAR);
        float monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / PERCENT;
        double mortgage = principle * (monthlyInterestRate * Math.pow(1+monthlyInterestRate, numberOfPayments))
                / ((Math.pow(1+monthlyInterestRate, numberOfPayments)-1)) ;
        return mortgage;
    }
}
