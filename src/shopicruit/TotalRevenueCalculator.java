package shopicruit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class TotalRevenueCalculator {
	
	private static JsonFileManager fileManager;
	private static ArrayList<ShopifyOrder> orders = new ArrayList<ShopifyOrder>();
	
	private static String getUserInput(String prompt) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(prompt);
		String userInput = scanner.next();
		scanner.close();
		
		return userInput;
	}
	
	private static double getTotalRevenue() {
		double rev = 0;
		for(ShopifyOrder order : orders)
			rev += order.getTotalPrice();
		
		return rev;
	}
	
	private static double getTotalRevenueUSD() {
		double revUSD = 0;
		for(ShopifyOrder order : orders)
			revUSD += order.getTotalPriceUSD();
		
		return revUSD;
	}
	
	private static Set<String> getSetOfCurrencies() {
		Set<String> currencies = new HashSet<String>();
		
		for(ShopifyOrder order : orders)
			currencies.add(order.getCurrency());
		
		return currencies;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the Total Revenue Calculator");
		
		while(true) {
			String filename = getUserInput("Please enter the filename/file path containing the list of orders: ");
			fileManager = new JsonFileManager(filename);
			
			if(fileManager.isValid())
				break;
			else
				System.out.println("Filename/file path is invalid please try again");
		}
		
		
		JSONArray jsonObjs = fileManager.getJsonObjArray();
		for(Object obj : jsonObjs)
		{
			JSONObject jsonObj = (JSONObject) obj;
			orders.add(new ShopifyOrder(jsonObj));
		}
		
		double totalRev = getTotalRevenue();
		for(String curr : getSetOfCurrencies())
			System.out.println(curr);
		
		System.out.print("The total revenue is: $");
		System.out.println(Double.toString(totalRev) + " in CAD");
		
		double totalRevUSD = getTotalRevenueUSD();
		System.out.print("The total revenue is: $");
		System.out.println(Double.toString(totalRevUSD) + " in USD");
	}
}
