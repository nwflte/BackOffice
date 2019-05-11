package DAO;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class HelpersDAO {
	private int pull;
	private int origin;
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
	
	public static LocalDateTime dateToLocalDateTime(Date date) {
		return LocalDateTime.from(Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.of("UTC")));
	}
}
