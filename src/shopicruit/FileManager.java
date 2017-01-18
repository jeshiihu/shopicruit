package shopicruit;

import java.util.Scanner;

public class FileManager 
{
	private String filename;
	
	public FileManager(String fname)
	{
		this.filename = fname;
	}
	
	public String getFilename()
	{
		return filename;
	}
	
	public boolean isValid()
	{
		return false;
	}
	
	public static String getinput(String prompt) 
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please enter the filename containing the orders: ");
		scanner.close();
		
		return scanner.next();
	}
}
