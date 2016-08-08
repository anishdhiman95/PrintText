package File.File1;

import java.util.HashMap;

public class Master {
	
	public static void main(String[] args) {
		
		Dictionary.instantiate();
		HashMap<String, Integer> map = Dictionary.getHashMap();
		RandomSentenceGeneratorFromDictionary rwDict= new RandomSentenceGeneratorFromDictionary(map);
		RandomWordGenerator rw= new RandomWordGenerator();

		System.out.println(rwDict.generateSentence(rwDict.mapToList(map)));
		System.out.println(rw.generateSentence(10,10));
	
		

	}

}
