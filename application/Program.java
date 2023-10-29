package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		//Informações do Cliente;
		System.out.println("Enter Cliente data: ");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.nextLine();
		System.out.print("Birth Data (DD/MM/YYYY): ");
		Date clientBirthData = sdf.parse(sc.next());
		
		Client client = new Client(clientName, clientEmail, clientBirthData);
		
		//Informação do Status;
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus statusString = OrderStatus.valueOf(sc.next());		
		
		//Itens e seus respectivos valores;
		Order order = new Order(new Date(), statusString, client);
		
		System.out.print("How many itens to this order? ");
		
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Enter #" + (i + 1) + " item data: ");
			System.out.print("Product name: ");
			String nameProduct = sc.next();
			System.out.print("Product price: ");
			Double priceProduct = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantityProduct = sc.nextInt();
			
			Product product = new Product(nameProduct, priceProduct);
			
			OrderItem it = new OrderItem(quantityProduct, priceProduct, product);
		
			order.addItem(it);
		}
		
		System.out.println();
		System.out.println(order);
		sc.close();
		
	}

}
