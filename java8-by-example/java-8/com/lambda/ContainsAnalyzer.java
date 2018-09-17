package com.lambda;

public class ContainsAnalyzer implements StringAnalyzer {

	@Override
	public boolean analyze(String target, String searchStr) {
		// TODO Auto-generated method stub
		return target.contains(searchStr);
	}
}
