package File.File1;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Dictionary {

	private static HashMap<String, Integer> map = new HashMap<String, Integer>();


	public static void instantiate(){
		scanFile("C:\\Users\\adhiman\\Downloads\\Hamlet.txt");
		scanFile("C:\\Users\\adhiman\\Downloads\\Julius Caesar.txt");
		scanFile("C:\\Users\\adhiman\\Downloads\\Macbeth.txt");
	}
	
	public static void scanFile(String fileName) {

		try {
			Scanner input = new Scanner(System.in);
			File file = new File(fileName);

			input = new Scanner(file);

			while (input.hasNext()) {
				String token = input.next();
				String word = getToken(token).toLowerCase();
				if (map.get(word) != null)
					map.put(word, map.get(word) + 1);
				else
					map.put(word, 1);
			}
			input.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String getToken(String token) {

		return token.replaceAll("[;.“:‘,—\"(?)!'-]", "");

	}
	
	public static HashMap<String, Integer> getHashMap(){		
		return map;
	}
			

}
