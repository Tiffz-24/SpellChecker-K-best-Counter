import java.util.*;
public class tester2{
	
	public static void main(String[] args){
		
		KBestCounter kBestTester = new KBestCounter(3);
		kBestTester.count(3);
		kBestTester.count(1);
		kBestTester.count(4);
		kBestTester.count(6);
		kBestTester.count(7);
		kBestTester.count(5);
		kBestTester.count(19);
		kBestTester.count(2);
		kBestTester.count(5);
		kBestTester.count(10);
		kBestTester.count(3);
		kBestTester.count(8);
		kBestTester.count(12);
		kBestTester.count(9);
		kBestTester.count(11);
		
		List<Integer> list = new ArrayList<Integer>(10);
		list = kBestTester.kbest();
		System.out.println(list);
		
		List<Integer> list2 = new ArrayList<Integer>(10);
		list2 = kBestTester.kbest();
		System.out.println(list2);
	}
}