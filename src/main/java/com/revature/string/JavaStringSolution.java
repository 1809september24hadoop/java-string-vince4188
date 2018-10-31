package com.revature.string;

import java.util.Arrays;

public class JavaStringSolution implements JavaString{

	@Override
	public int parseInteger(String number) throws IllegalArgumentException {
		if (number == null)
			throw new IllegalArgumentException("Can't have null String!");
		boolean isNeg = false;
		int returnVal = 0;
		for(int i = 0; i < number.length(); i++) {
			if(Character.isDigit(number.charAt(i))) {
				String temp = Integer.toString(returnVal) + number.charAt(i);
				returnVal = Integer.parseInt(temp);
			}
			else if(number.charAt(i) == '-' && i == 0) {
				isNeg = true;
			}
			else {
				throw new IllegalArgumentException("Can't have nondigit value!");
			}
		}
		if (isNeg == true) {
			returnVal *= -1;
		}
		return returnVal;
	}

	@Override
	public String reverse(String string) throws IllegalArgumentException {
		if (string == null)
			throw new IllegalArgumentException("Can't have null String!");
		String returnStr = "";
		for(int i = string.length() - 1; i > -1; i--) {
			returnStr += string.charAt(i);
		}
		return returnStr;
	}

	@Override
	public void time(StringBuilder builder, StringBuffer buffer) throws IllegalArgumentException {
		if (builder == null || buffer == null)
			throw new IllegalArgumentException("Can't have null builder or buffer!");
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < 10_000_000; i++) {
			builder.append("A");
		}
		long total = System.currentTimeMillis() - start;
		System.out.println("Builder Append Time: " + total + " ms.");
		
		start = System.currentTimeMillis();
		for(int i = 0; i < 10_000_000; i++) {
			buffer.append("A");
		}
		total = System.currentTimeMillis() - start;
		System.out.println("Buffer Append Time: " + total + " ms.");
		
	}

	@Override
	public boolean itContains(String string, String contains) throws IllegalArgumentException {
		if (string == null)
			throw new IllegalArgumentException("Can't have null String!");
		string = string.toLowerCase();
		contains = contains.toLowerCase();
		for(int i = 0; i < string.length() - contains.length() + 1; i++) {
			String compareVal = string.substring(i, i+contains.length());
			if(compareVal.equals(contains)) {
				return true;
			}
		}		
		return false;
	}

	@Override
	public String sort(String string) throws IllegalArgumentException {
		if (string == null)
			throw new IllegalArgumentException("Can't have null String!");
		
		char[] arr = string.toCharArray();
		Arrays.sort(arr);		
		return Arrays.toString(arr);
	}

	@Override
	public String delete(String string, char c) throws IllegalArgumentException {
		if (string == null)
			throw new IllegalArgumentException("Can't have null String!");
		String returnStr = "";
		for(char ch : string.toLowerCase().toCharArray()) {
			if (ch != c) {
				returnStr += ch;
			}
		}
		return returnStr;
	}

	@Override
	public String upperLower(String string) throws IllegalArgumentException {
		if (string == null)
			throw new IllegalArgumentException("Can't have null String!");
		else if(string.length()%2 != 0)
			throw new IllegalArgumentException("String length is not even!");
		
		return string.substring(0, string.length()/2).toUpperCase().concat(string.substring(string.length()/2).toLowerCase());
	}
	
	public static void main(String[] args) {
		JavaStringSolution demo = new JavaStringSolution();
		
		System.out.println(demo.reverse("firetruck"));
		System.out.println(demo.parseInteger("-25"));
		System.out.println(demo.itContains("firetruck", "truck"));
		StringBuilder builder = new StringBuilder();
		StringBuffer buffer = new StringBuffer();
		demo.time(builder, buffer);
		System.out.println(demo.sort("ioueay"));
		System.out.println(demo.delete("She sold seashells by the seashore", 's'));
		System.out.println(demo.upperLower("firetruck1"));
	}

}
