package shopicruit;

import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class TotalRevenueCalculator {
	
	private static JsonFileManager fileManager;
	private static List<ShopifyOrder> orders;
	
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

	public static void main(String[] args) {
		System.out.println("Welcome to the Total Revenue Calculator");
		
		while(true) {
			String filename = getUserInput("Please enter the filename/filepath containing the list of orders: ");
			fileManager = new JsonFileManager(filename);
			
			if(fileManager.isValid())
				break;
			else
				System.out.println("Filename/filepath is invalid please try again");
		}
		
		
		JSONArray jsonObjs = fileManager.getJsonObjArray();
		for(Object obj : jsonObjs)
		{
			JSONObject jsonObj = (JSONObject) obj;
			orders.add(new ShopifyOrder(jsonObj));
		}
		
		double totalRev = getTotalRevenue();
		
		System.out.print("The total revuenue is: ");
		System.out.println(Double.toString(totalRev));
	}
}
