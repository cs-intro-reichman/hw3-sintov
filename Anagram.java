/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		str1 = noSpaces(str1);
		str2 = noSpaces(str2);
		int substringPlace = 0;
		if (str1.length() != str2.length()){
			return false;
		}
		for (int i = 0; i < str1.length(); i ++){
			boolean isAnagram = false;
			for (int j = 0; j < str2.length(); j ++){
				if(str1.charAt(i) == str2.charAt(j)){
					isAnagram = true;
					substringPlace = j;
				}
			}
			if(isAnagram == false){
				return false;
			}
			str2 = str2.substring(0, substringPlace) + str2.substring(substringPlace + 1);
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String afterProcessstr = "";
		str = str.toLowerCase();
		for (int i =0; i< str.length(); i++){
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z' || str.charAt(i) == 32){
				afterProcessstr += str.charAt(i);
			}
		}
		return afterProcessstr;
	} 

	public static String noSpaces (String str){
		String noSpacesString = "";
		for (int i = 0; i < str.length(); i++){
			if (str.charAt(i) != 32){
				noSpacesString += str.charAt(i);
			}
		}
		return noSpacesString;
	}
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String anagramString = "";
		String strToProcess = str;
		//str = preProcess(str);
		//str = noSpaces(str);
		for (int i = 0; i < str.length(); i++){
			int rnum = (int)((strToProcess.length()) * Math.random());
			anagramString += strToProcess.charAt(rnum);
			strToProcess = strToProcess.substring(0, rnum) + strToProcess.substring(rnum + 1);
		}
		// Replace the following statement with your code
		return anagramString;
	}
}
