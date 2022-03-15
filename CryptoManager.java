/**
 * Class: CMSC203 
 *  Program: Assignment #3
 *  Instructor: Dr. Grinberg
 * Description: WiFi Diagnose
   A program that requires you to use functions to calculate the volume of a box and the    volume of a Sphere.
 * Due: 03/14/2022 
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Shengquan Yang
*/
public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) 
	{
		boolean boundary = true; //Declare a Boolean called boundary to true
		for (int i = 0; i < plainText.length(); i++)
		{
			/*
			 If plainText.charAt(i) is equal to or larger than LOWER_BOUND and plainText.charAt(i) is equal to     
	         or less than UPPER_BOUND are not true, execute the following code
			*/
			if (!(plainText.charAt(i) >= LOWER_BOUND && plainText.charAt(i) <= UPPER_BOUND))
				boundary = false; //Assign boundary to false
		}
		return boundary; //Return boundary
	}


	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) 
	{
		String encryptedText = ""; //Declare a String called encryptedText to blank
		if (stringInBounds(plainText)) //If stringInBounds(plainText) is true, execute the following code
		{
			for (int i = 0; i < plainText.length(); i++)
		    {
				char character = plainText.charAt(i); //Declare a character character to the character at different positions of the plainText
		        int j = (int)character + key; //Declare an integer j to character+key 
		        int encrypted = j; //Declare integer encrypted to integer j
		        if (encrypted > UPPER_BOUND) //If encrypted is larger than the UPPER_BOUND, execute the following code
		        {
		        	do
		        	{
		        		encrypted -= RANGE; //To make the integer encrypted inside the range		        		
		        	}while (encrypted > UPPER_BOUND);
		        }
		        encryptedText += (char)encrypted; //Assign encryptedText the characters which are converted from integer encrypted
		    }
		}
		return encryptedText; //Return encryptedText

	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) 
	{
		String encryptedText = ""; //Declare a String called encryptedText to blank
		int bellasoStr_Length = bellasoStr.length();
		for (int i = 0; i < plainText.length(); i++)
		{
			char character = plainText.charAt(i); //Declare an character character to the character at different positions of the plainText
		    int j = (int)character; //Declare an integer j and assign it to integer converted from character
		    int k = (int)bellasoStr.charAt(i % bellasoStr_Length); //Declare an integer k to bellasoStr.charAt(i % bellasoStr_Length) and convert it to integer
		    int encrypted = j + k; //Declare integer encrypted to the sum of j and k
		    if (encrypted > (int)UPPER_BOUND) //If encrypted is larger than the UPPER_BOUND, execute the following code
		    {
		    	do
		    	{
		    		encrypted -= RANGE; //To make the integer encrypted inside the range
		    	}while (encrypted > (int)UPPER_BOUND);
		    }
		    encryptedText += (char)encrypted; //Assign encryptedText the characters which are converted from integer encrypted
		}
		return encryptedText; //Return encryptedText
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) 
	{
		String decryptedText = ""; //Declare a String called decryptedText to blank
		for (int i =0; i < encryptedText.length(); i++)
		{
			char character = encryptedText.charAt(i); //Declare a character character to the character at different positions of the encryptedText
			int j = (int)character - key; //Declare an integer j to character-key
		    int decrypted = j; //Declare integer decrypted to integer j
		    if (decrypted < LOWER_BOUND) //If decrypted is smaller than the LOWER_BOUND, execute the following code
		    {
		    	do
		    	{
		    		decrypted += RANGE;	//Add decrypted by RANGE
		    	}while (decrypted < LOWER_BOUND);
		    }
		    decryptedText += (char)decrypted; //Assign decryptedText the characters which are converted from integer decrypted
		}
		return decryptedText; //Return decryptedText
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) 
	{
		String decryptedText = ""; //Declare a String called decryptedText to blank
		int bellasoStr_Length = bellasoStr.length();
		for (int i = 0; i < encryptedText.length(); i++)
		{
			char character = encryptedText.charAt(i); //Declare an character character to the character at different positions of the encryptedText
			int j = (int)character; //Declare an integer j and assign it to integer converted from character
			int k = (int)bellasoStr.charAt(i % bellasoStr_Length); //Declare an integer k to bellasoStr.charAt(i % bellasoStr_Length) and convert it to integer
		    int decrypted = j - k; //Declare integer decrypted to the difference of j and k
		    if (decrypted < (int)LOWER_BOUND) //If decrypted is smaller than the LOWER_BOUND, execute the following code
		    {
		    	do
		    	{
		    		decrypted += RANGE; //Add decrypted by RANGE
		    	}while (decrypted < (int)LOWER_BOUND); 
		    }
		    decryptedText += (char)decrypted; //Assign decryptedText the characters which are converted from integer decrypted
		}
		return decryptedText; //Return decryptedText
	}
}

