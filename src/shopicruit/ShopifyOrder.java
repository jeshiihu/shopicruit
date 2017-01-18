package shopicruit;

import org.json.simple.JSONObject;

public class ShopifyOrder {
	JSONObject jsonOrder;
	
	public ShopifyOrder(JSONObject obj) {
		jsonOrder = obj;
	}
	
	public double getTotalPrice() {
		String price = jsonOrder.get("total_price").toString();
		return Double.parseDouble(price);
	}
}
