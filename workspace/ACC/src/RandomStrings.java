import java.util.Random;

import hashTable.SeparateChainingHashTable;

public class RandomStrings {
	
	
	public RandomStrings(int stringArraySize, int stringLength) {
		
		this.DEFAULT_ARRAY_SIZE = stringArraySize;
		this.stringLength = stringLength;
		
		randomStrings = new String[DEFAULT_ARRAY_SIZE];
		sampleChar = new StringBuffer();
		iniRandomStrings();
		
	}
	
	/**
	 * initial smapleChar as a string with letters and numbers.
	 */
	private void iniRandomStrings() {
			
		
		    for (char ch = '0'; ch <= '9'; ++ch)
		    	sampleChar.append(ch);
		    for (char ch = 'a'; ch <= 'z'; ++ch)
		    	sampleChar.append(ch);
		    for (char ch = 'A'; ch <= 'Z'; ++ch)
		    	sampleChar.append(ch);
	}
	
	/**
	 * Choose a random character or number from sampleChar.
	 * @param 0
	 * @return A random char
	 */
	private char generateAChar() {
		
		return sampleChar.charAt(r.nextInt(sampleChar.length()));
	}
	
	/**
	 * generate a fixed stringLength long string. 
	 * @param null
	 * @return a random string
	 */
	public String generateAString() {
		
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < stringLength; i++){
			sb.append(generateAChar());
		}
		
		return sb.toString();
	}
	
	/**
	 * generate a full array of random strings. this size is DEFAULT_ARRAY_SIZE
	 * @param null
	 * @return
	 */
	public String[] generateStrings(){
		
		for(int i = 0; i < DEFAULT_ARRAY_SIZE; i++ ) {
			
			randomStrings[i] = generateAString();
		}
		return randomStrings;
	}
	
	/**
	 * 
	 * print all random strings;
	 */
	public void printMe(){
		
		if (randomStrings == null || randomStrings.length == 0) {
				
			System.out.println("No Elements in randomStrings");
			return;
		}
		
		for(String s:randomStrings){
			System.out.println(s);
		}
	}
	
	private int DEFAULT_ARRAY_SIZE = 20;
	Random r = new Random();
	private StringBuffer sampleChar;
	private int stringLength = 20;
	String[] randomStrings;
	

}
