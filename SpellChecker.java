import java.util.*;
import java.io.*;
public class SpellChecker{
	private HashSet<String> hashSet;
	
	public SpellChecker(String filename){
		try{
			hashSet = new HashSet<String>();
			File file = new File(filename);
			Scanner scanner = new Scanner(file);
			//Convert every word to lowercase and remove all punctuation 
			//before inserting it into the HashSet
			
			//check each word
			while(scanner.hasNext()){
				String word = scanner.next();
				word = removePunctuation(word).toLowerCase();
				hashSet.add(word);
			}
			
		}
		
		catch (FileNotFoundException e){
			System.out.println(e);
		}
		
	}
	
	public List<String> getIncorrectWords(String filename){
		ArrayList<String> list = new ArrayList<String>();
		try{
			File file = new File(filename);
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()){
				String word = scanner.next();
				word = removePunctuation(word).toLowerCase();
				if (!hashSet.contains(word)){
					list.add(word);
				}
			}
			

		}
		
		catch (FileNotFoundException e){
			System.out.println(e);
		}
		
		return list;
	}

	private String removePunctuation(String word){
		if(word.length()==1){
			if(Character.isLetter(word.charAt(0))||Character.isDigit(word.charAt(0))){
				return word;
			}
			else{
				return "";
			}
		}
		
		else{
			if(!Character.isLetter(word.charAt(0)) && !Character.isDigit(word.charAt(0))){
				return removePunctuation(word.substring(1, word.length()));
			}
			
			if(!Character.isLetter(word.charAt(word.length()-1)) && !Character.isDigit(word.charAt(word.length()-1))){
				return removePunctuation(word.substring(0, word.length()-1));
			}
			
			else{
				for(int i = 0; i < word.length()-1; i++){
					if(!Character.isLetter(word.charAt(i)) && !Character.isDigit(word.charAt(i))){
						return removePunctuation(word.substring(0, i) + word.substring(i+1, word.length()));
					}
				}
			}
		}
		
		return word;
	}
	public Set<String> getSuggestions(String word){
		HashSet<String> suggestions = new HashSet<String>();
		
		if(hashSet.contains(word)){
			System.out.println("spelled correctly");
			suggestions.add(word);
			return suggestions;
		}
		
		for(int i = 0; i <= word.length(); i++){
			for(char character = 'a'; character <= 'z'; character++){
				//insert all letters of the alphabet into word
				String suggested = word.substring(0,i) + character + word.substring(i, word.length());
				if(hashSet.contains(suggested)){
					suggestions.add(suggested);
				}
			}
		}
		
		for(int i = 0; i < word.length(); i++){
			//remove each character
			String suggested = word.substring(0,i) + word.substring(i+1, word.length());
			if(hashSet.contains(suggested)){
				suggestions.add(suggested);
			}
		}
		
		for(int i = 0; i < word.length() - 1; i++){
// 			for(int j = i+1; j < word.length()-1; j++){
				int j = i+1;
				String suggested = word.substring(0,i) + word.charAt(j) + word.charAt(i) + word.substring(j+1);
				if(hashSet.contains(suggested)){
					suggestions.add(suggested);
				}
// 			}
			
		}
		
		return suggestions;
	}
}