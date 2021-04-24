public class tester1{
	
	public static void main(String[] args){
		SpellChecker tester = new SpellChecker("words.txt");
		System.out.println(tester.getIncorrectWords("test.txt"));
		System.out.println(tester.getSuggestions("abb"));
		System.out.println(tester.getSuggestions("abb"));
	}
	
}