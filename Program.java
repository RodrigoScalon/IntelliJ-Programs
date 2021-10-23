package Application;

import Entities.Contract;
import Entities.Installment;
import Services.ContractServices;
import Services.PaypalServices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Scanner input = new Scanner(System.in);

        System.out.println("Enter contract data: ");
        System.out.print("Number: ");
        Integer number = input.nextInt();
        System.out.print("Date (dd/mm/yyyy): ");
        Date date = sdf.parse(input.next());
        System.out.print("Contract Value: ");
        Double totalValue = input.nextDouble();

        Contract contract = new Contract(number, date, totalValue);

        System.out.print("Enter number of installments: ");
        int N = input.nextInt();

        ContractServices cs = new ContractServices(new PaypalServices());

        cs.processContract(contract, N);

        System.out.println("INSTALLMENTS");
        for (Installment it : contract.getInstallments()){
            System.out.println(it);
        }

    input.close();



    }

}
