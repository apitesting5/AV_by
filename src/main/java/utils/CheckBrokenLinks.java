package utils;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CheckBrokenLinks {
	
	public static List<String> brokenLinks = new ArrayList<>();
	
	public static void checkBrokenLinks(String urlLink) {
		
		try {
			URL url = new URL(urlLink);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setConnectTimeout(5000);
			httpURLConnection.connect();
			
			if(httpURLConnection.getResponseCode() >= 400) {
				System.out.println(urlLink + "---->" + httpURLConnection.getResponseMessage() + " is a broken link");
				brokenLinks.add(urlLink);
				
			}
		
		}
		catch(Exception e) {
			
		}
		
	}

}
