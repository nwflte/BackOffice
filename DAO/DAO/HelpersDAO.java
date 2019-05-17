package DAO;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import Business.Document;
import Business.Etape;

public class HelpersDAO {
	
	/**
	 * Fonction qui découpe une String en un tableau de string separées par "-"
	 * Exemple "1-5-7" donne ["1","5","7"]
	 * @param s
	 * @return
	 */
	public static String[] stringSplit(String s) {
		String[] stringArray;
		String delimiter = "-";
		stringArray = s.split(delimiter);
		return stringArray;
	}
	
	/**
	 * Convertit un tableau de string qui contient des nombres en un tableau des int
	 * exemple : ["1","5","7"] devient [1,5,7]
	 * @param stringArray
	 * @return
	 */
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
	
	public static Date localDateTimeToDate(LocalDateTime date) {
		return Date.from(date.atZone(ZoneId.systemDefault()).toInstant());
	}
	
	
	/**
	 * Dans la BD, la liste des documents est representé par un champ VARCHAR de la forme "1-5-4"
	 * Cette fonction convertit une liste des documents en cette format representable dans la BD
	 * @param list
	 * @return
	 */
	public static String documentsListToString(ArrayList<Document> list) {
		String string = "";
		for(int i = 0; i < list.size(); i++) {
			if(i==0) string += list.get(i).getDocument_id();
			else string += "-" + list.get(i).getDocument_id();
		}
		return string;
	}
	
	public static String etapesListToString(ArrayList<Etape> list) {
		String string = "";
		for(int i = 0; i < list.size(); i++) {
			if(i==0) string += list.get(i).getEtape_id();
			else string += "-" + list.get(i).getEtape_id();
		}
		return string;
	}
}
