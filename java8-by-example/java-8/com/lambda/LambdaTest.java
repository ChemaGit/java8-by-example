package com.lambda;

public class LambdaTest {

	public static void main(String[] args) {
		String[] strList = {"tomorrow", "toto", "to", "timbukto", "the", "hello", "heat"};
		String searchStr = "to";
		
		//Create a regular Class
		AnalyzerTool analyzeTool = new AnalyzerTool();
		
		System.out.println("=======CONTAINS========REGULAR CLASS========");
		System.out.println("Searching for: " + searchStr);
		for(String currentStr : strList) {
			if(analyzeTool.arrContains(currentStr, searchStr)) {
				System.out.println("Match: " + currentStr);
			}
		}
		
		System.out.println("=======CONTAINS========INTERFACE========");
		System.out.println("Searching for: " + searchStr);
		//Call concrete class that implements StringAnalyzer
		ContainsAnalyzer contains = new ContainsAnalyzer();
		for(String currentStr : strList) {
			if(contains.analyze(currentStr, searchStr)) {
				System.out.println("Match: " + currentStr);
			}
		}
		
		System.out.println("=======CONTAINS========INTERFACE========WITH HELPER METHOD");
		System.out.println("Searching for: " + searchStr);
		//Call concrete class that implements StringAnalyzer
		ContainsAnalyzer containsA = new ContainsAnalyzer();
		Z03Analyzer.searchArr(strList, searchStr, containsA);
		
		System.out.println("=======CONTAINS========INTERFACE========ANONYMOUS INNER CLASS");
		System.out.println("Searching for: " + searchStr);
		Z03Analyzer.searchArr(strList, searchStr, new StringAnalyzer(){

			@Override
			public boolean analyze(String target, String searchStr) {
				// TODO Auto-generated method stub
				return target.contains(searchStr);
			}			
		});
		
		System.out.println("=======CONTAINS========LAMBDA EXPRESSION========REPLACES INNER CLASS");
		System.out.println("\nSearching for: " + searchStr);
		Z03Analyzer.searchArr(strList, searchStr, (String target, String search) -> target.contains(search));
		
		System.out.println("=======CONTAINS========LAMBDA EXPRESSION========CHANGING LOGIC BECOMES EASY");
		System.out.println("\nStartWith for: " + searchStr);
		Z03Analyzer.searchArr(strList, searchStr, (String target, String search) -> target.startsWith(search));
		
		System.out.println("=======CONTAINS========LAMBDA EXPRESSION========CAN BE TREATED LIKE VARIABLES");
		System.out.println("\nSearching for: " + searchStr);
		StringAnalyzer containsB = (t, s) -> t.contains(s);
		StringAnalyzer startWith = (t, s) -> t.startsWith(s);
		StringAnalyzer endWith = (t, s) -> t.endsWith(s); 
		StringAnalyzer containsC = (t, s) -> t.contains(s) && t.length() > 5;
		StringAnalyzer containsD = (t, s) -> t.contains(s) && t.length() < 5;
		System.out.println("\nSearching for: " + searchStr);
		Z03Analyzer.searchArr(strList, searchStr, containsB);
		System.out.println("\nStartWith for: " + searchStr);
		Z03Analyzer.searchArr(strList, searchStr, startWith);
		System.out.println("\nEndWith for: " + searchStr);
		Z03Analyzer.searchArr(strList, searchStr, endWith);
		System.out.println("\nContains greater than five: " + searchStr);
		Z03Analyzer.searchArr(strList, searchStr, containsC);
		System.out.println("\nContains less than five: " + searchStr);
		Z03Analyzer.searchArr(strList, searchStr, containsD);
	}
}
