
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class Master {

	public static void main(String[] args) throws FileNotFoundException {
		int wordsPerSentence = 10;
		Dictionary.instantiate();
		ArrayList<String> dict = Dictionary.getDict();
		RandomSentenceGeneratorFromDictionary rwDict = new RandomSentenceGeneratorFromDictionary(dict);
		RandomSentenceGeneratorFromLetters rw = new RandomSentenceGeneratorFromLetters();
		System.out.println("Sentence generated using Random letters: " + rw.generateSentence(5, wordsPerSentence));
		System.out.println("Sentence generated using Random words from dictionary: " + rwDict.generateSentence());
		String startWord = Dictionary.startWords.get(rwDict.randomKey(0, Dictionary.startWords.size()));
		String sentence = startWord + " ";
		System.out.println("Start Word :" + startWord);
		while (wordsPerSentence > 1) {
			String newWord = rwDict.getNextWord(startWord);
			// while (Dictionary.endWords.contains(newWord) &&
			// wordsPerSentence==2){
			// newWord = rwDict.getNextWord(startWord);
			// }
			String currWord = newWord;
			sentence += currWord + " ";
			startWord = currWord;
			wordsPerSentence--;
		}
		sentence += rwDict.getEndWord(startWord, Dictionary.endWords);
		System.out.println("Sentence generated by markov principle: " + sentence);
	}
}
