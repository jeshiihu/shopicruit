package shopicruit;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ShopifyOrder
{
	private Customer customer;
	private Fulfillment fulfillment;
	private Transaction transaction;
	
	public ShopifyOrder(JSONObject obj)
	{
		int i = 0;
		System.out.println("created shopify object");
	}
	
	private void parser() 
	{
		String filename = "orders.json";
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject obj = (JSONObject)parser.parse(new FileReader(filename));
		}
		catch(Exception e) {
			System.out.print(e.toString());
		}
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Fulfillment getFulfillment() {
		return fulfillment;
	}

	public void setFulfillment(Fulfillment fulfillment) {
		this.fulfillment = fulfillment;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
}
