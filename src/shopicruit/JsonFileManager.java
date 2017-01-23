package shopicruit;

import java.io.File;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonFileManager {
	private File file;
	
	public JsonFileManager(String fname) {
		setFile(fname);
	}
	
	public void setFile(String fname) {
		file = new File(fname);
	}
	
	public String getFilename() {
		return file.getName();
	}
	
	// this does not return the period '.' preceding the extension
	public String getExtension() {
	    String name = file.getName();
	    
	    try {
	        return name.substring(name.lastIndexOf(".") + 1);
	    } catch (Exception e) {
	    	System.out.println("Error: file is invalid, unable to get extension");
	        return "";
	    }
	}
	
	public boolean isValid() {
		return file.exists() & getExtension().equals("json");
	}

	public JSONArray getJsonObjArray() {
		JSONParser parser = new JSONParser();
		
		JSONArray arr;
		try {
			FileReader reader = new FileReader(getFilename());
			JSONObject jsonObj = (JSONObject) parser.parse(reader);
			
			arr = (JSONArray)jsonObj.get("orders");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return arr;
	}
	
	
}
