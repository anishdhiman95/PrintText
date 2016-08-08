package File.File1;

import java.util.*;

public class RandomSentenceGeneratorFromDictionary {
	Map<String,Integer> dictionary = null;
	
	public RandomSentenceGeneratorFromDictionary(Map<String,Integer> dict){
		this.dictionary=dict;
	}
	
	public ArrayList<String> mapToList(Map<String,Integer> dict){
		ArrayList<String> ListOfWords = new ArrayList<String>();
		Set keys = dict.keySet();
		   for (Iterator i = keys.iterator(); i.hasNext(); ) {
		       ListOfWords.add((String) i.next());
		   }
		   return ListOfWords;
	}
	
	public int randomKey(){
		int Max = this.dictionary.size();
		int Min = 0;
		return Min + (int)(Math.random() * ((Max - Min) + 1));
	}
	
	public String generateWord (ArrayList<String> ListOfWords) {
		return ListOfWords.get(randomKey());
	}
	
	public String generateSentence(ArrayList<String> ListOfWords){
		int wordsPerSent = 9;
		String sent = "";
		while(wordsPerSent>0){
			sent += generateWord(ListOfWords) + " ";
			wordsPerSent--;
		}
		return sent;
	}
}


