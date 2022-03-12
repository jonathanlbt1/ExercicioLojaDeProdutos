package Application;

import Entities.ImportedProduct;
import Entities.Product;
import Entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scan = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        List<Product> list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter the number of products: ");
        int n = scan.nextInt();

        for(int i=1; i <= n; i++) {
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char x = scan.next().charAt(0);

            System.out.print("Name: ");
            scan.nextLine();
            String name = scan.nextLine();

            System.out.print("Price: ");
            double price = scan.nextDouble();

            if (x == 'c') {
                list.add(new Product(name, price));
            } else if (x == 'u') {
                System.out.print("Manufacture data (DD/MM/YYYY): ");
                Date manufactureDate = sdf.parse(scan.next());
                list.add(new UsedProduct(name, price, manufactureDate));
            } else if (x == 'i') {
                System.out.print("Customs fee: ");
                double fee = scan.nextDouble();
                list.add(new ImportedProduct(name, price, fee));
            } else {
                System.out.println("Please, enter the right data!");
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS: ");
        for(Product product : list) {
            System.out.println(product.priceTag());
        }

        scan.close();

    }
}
