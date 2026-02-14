import dao.ProductDAO;
import entity.Product;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAO();

        while (true) {
            System.out.println("\n===== PRODUCT MANAGEMENT =====");
            System.out.println("1. Add Product");
            System.out.println("2. Get Product By ID");
            System.out.println("3. Get All Products");
            System.out.println("4. Update Product Price");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Description: ");
                    String desc = sc.nextLine();

                    System.out.print("Category: ");
                    String category = sc.nextLine();

                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    sc.nextLine();
                    System.out.print("SKU: ");
                    String sku = sc.nextLine();

                    System.out.print("Active (true/false): ");
                    boolean active = sc.nextBoolean();

                    Product p = new Product(name, desc, category, qty, price, sku, active);
                    dao.save(p);
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    Long id = sc.nextLong();
                    Product product = dao.getById(id);
                    if (product != null) {
                        System.out.println(product.getName() + " | " + product.getPrice());
                    }
                    break;

                case 3:
                    List<Product> list = dao.getAll();
                    for (Product pr : list) {
                        System.out.println(pr.getId() + " | " + pr.getName() + " | " + pr.getPrice());
                    }
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    Long uid = sc.nextLong();

                    Product up = dao.getById(uid);
                    if (up != null) {
                        System.out.print("New price: ");
                        double newPrice = sc.nextDouble();
                        up.setPrice(newPrice);
                        dao.update(up);
                    }
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    Long did = sc.nextLong();
                    dao.delete(did);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
