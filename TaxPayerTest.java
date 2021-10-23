import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaxPayerTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Enter the number of taxpayers: ");
        int n = input.nextInt();

        for (int i = 1; i <= n; i ++ ) {

            System.out.println("Taxpayer #" + i + " data:");
            System.out.print("Individual or Company? (i/c)");
            char type = input.next().charAt(0);
            System.out.print("Name: ");
            String name = input.next(); // one word no space
            System.out.print("Annual Income: ");
            double annualIncome = input.nextDouble();

            if (type == 'i') {
                System.out.print("Health Expenditures: ");
                double healthExpenditures = input.nextDouble();

                list.add(new Individual(name, annualIncome, healthExpenditures));

            } else {
                System.out.print("Number of employees: ");
                Integer numberOfEmployees = input.nextInt();

                list.add(new Company(name, annualIncome, numberOfEmployees));
            }
        }

        System.out.println();
        System.out.println("TAXES PAID: ");

        for (TaxPayer tp : list) {
            System.out.println(tp.getName() + ": $" +  String.format("%.2f", + tp.tax()));
        }

        double sum = 0.0;
        for(TaxPayer tp : list) {
        sum += tp.tax();
        }

        System.out.println();
        System.out.println("TOTAL TAXES $" + String.format("%.2f", sum));



        input.close();


    }
}
