package util;


import java.nio.charset.Charset;

public class Validation {
	
	
	public static boolean isValidString(String input) {
		return Charset.forName("ASCII").newEncoder().canEncode(input) && !input.isEmpty();
	}
	
	public static void main(String[] args) {
		String s = "fjk";
		System.out.println(isValidString(s));
	}
}
