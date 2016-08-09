import java.util.*;

public class RandomSentenceGeneratorFromDictionary {
	ArrayList<String> dictionary = null;

	public RandomSentenceGeneratorFromDictionary(ArrayList<String> dict) {
		this.dictionary = dict;
	}

	public int randomKey(int min, int max) {
		return min + (int) (Math.random() * ((max - min) + 1));
	}

	public String generateRandomWord() {
		return this.dictionary.get(randomKey(0, this.dictionary.size()));
	}

	public String generateSentence() {
		int wordsPerSent = 9;
		String sent = "";
		while (wordsPerSent > 0) {
			sent += generateRandomWord() + " ";
			wordsPerSent--;
		}
		return sent;
	}

	public String getNextWord(String currWord) {
		ArrayList<Integer> occurenceOfCurrentWord = new ArrayList<Integer>();
		for (int i = 0; i < this.dictionary.size(); i++) {
			if (this.dictionary.get(i).equals(currWord))
				occurenceOfCurrentWord.add(i);
		}
		return this.dictionary.get(1 + occurenceOfCurrentWord.get(randomKey(0, occurenceOfCurrentWord.size() - 1)));
	}

	public String getEndWord(String currWord, ArrayList<String> endWords) {
		String next = getNextWord(currWord);
		int len = endWords.size();
		while (len > 0) {
			if (endWords.contains(next))
				return next;
			next = getNextWord(next);
			len--;
		}
		return endWords.get(randomKey(0, endWords.size()));
	}
}
