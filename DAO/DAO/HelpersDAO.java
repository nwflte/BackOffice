package DAO;

public class HelpersDAO {
	
	public static String[] stringSplit(String s) {
		String[] stringArray;
		String delimiter = "-";
		stringArray = s.split(delimiter);
		return stringArray;
	}
	
	public static int[] stringToInt(String[] stringArray) {
		int size = stringArray.length;
		int [] intArray = new int[size];
		for(int i = 0; i < size ; i++) {
			intArray[i] = Integer.parseInt(stringArray[i]);
		}
		return intArray;
	}
}
