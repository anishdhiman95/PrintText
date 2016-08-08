package File.File1;

import java.util.Random;

public class RandomWordGenerator {
	
	public String generateWord(int n)
	{
		final String alphabet = "abcdefghijklmnopqrstuvwxyz";
		final int len= alphabet.length();
		Random rnd = new Random();
		StringBuilder randomString = new StringBuilder();
		String randomWord;
		for (int i = 0; i < n; i++) 
		{
			randomString.append(alphabet.charAt(rnd.nextInt(len)));
		}
			
		randomWord=randomString.toString();
		return randomWord;
	}
	
	public String generateSentence(int wordLength,int senLength)
	{
		StringBuilder randomSentance = new StringBuilder();
		String str;
		Random rnd= new Random();
		int sentanceLen=rnd.nextInt(senLength);
		for(int i=0;i<sentanceLen;i++)
		{
			randomSentance.append(generateWord(rnd.nextInt(wordLength))+" ");
			
		}
		str=randomSentance.toString();
			
		return str;
		
	}
	

}

