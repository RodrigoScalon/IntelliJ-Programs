import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class EmployeeTest {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.printf("Enter the number of employees: ");
        int n = input.nextInt();

        for (int i=1; i<=n; i++) {
            System.out.println("Employee #" + i + " data:");
            System.out.print("Outsourced? (y/n) ");
            char ch = input.next().charAt(0);
            System.out.print("Name: ");
            input.nextLine();
            String name = input.nextLine();
            System.out.print("Hours: ");
            int hours = input.nextInt();
            System.out.print("Value per hour: ");
            double valuePerHour = input.nextDouble();

            if (ch == 'y') {
                System.out.print("Additional charge: ");
                double additionalCharge = input.nextDouble();

               // Employee emp = new OutsurcedEmployee(name, hours, valuePerHour,additionalCharge);
                list.add(new OutsurcedEmployee(name, hours, valuePerHour, additionalCharge));
            }
            else {
                //Employee emp = new Employee(name, hours, valuePerHour);
                list.add(new Employee(name, hours, valuePerHour));
            }
        }

        System.out.println();
        System.out.println("-PAYMENTS-");
        for (Employee emp : list) {
            System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
        }









        input.close();
    }



}
