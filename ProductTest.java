import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProductTest {

    public static void main(String[] args) throws ParseException {
    Scanner input = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = input.nextInt();

        for (int i=1; i<=n; i++) {
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char type = input.next().charAt(0);
            System.out.print("Name: ");
            input.nextLine();
            String name = input.nextLine();
            System.out.print("Price: ");
            double price = input.nextDouble();
            if (type == 'c') {
                list.add(new Product(name, price));
            }
            else if (type == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                Date date = sdf.parse(input.next());
                list.add(new UsedProduct(name, price, date));
            }
            else {
                System.out.print("Customs fee: ");
                double customsFee = input.nextDouble();
                list.add(new ImportedProduct(name, price, customsFee));
            }
        }

        for (Product prod : list) {
            System.out.println(prod.priceTag());
        }

    }
}
