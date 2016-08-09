
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Dictionary {

	private static ArrayList<String> dict = new ArrayList<String>();

	public static void instantiate() throws FileNotFoundException {
		scanFile("C:\\Users\\subhargava\\Downloads\\Hamlet.txt");
		scanFile("C:\\Users\\subhargava\\Downloads\\Julius Caesar.txt");
		scanFile("C:\\Users\\subhargava\\Downloads\\Macbeth.txt");
	}

	public static void scanFile(String fileName) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		File file = new File(fileName);
		Scanner s = new Scanner(file);
		while (s.hasNext()) {
			String token = s.next();
			String word = getToken(token).toLowerCase();
			dict.add(word);
		}
		s.close();
	}

	public static String getToken(String token) {
		return token.replaceAll("[;.“:‘,—\"(?)!'-]", "");
	}

	public static ArrayList<String> getDict() {
		return dict;
	}
}
