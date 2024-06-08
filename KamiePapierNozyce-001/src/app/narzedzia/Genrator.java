package app.narzedzia;

import java.util.Random;

public class Genrator {
	
	private static Random generator = new Random();
	private static String[] wybory = {"K", "P", "N"};
	
	public static String wyboryKomputera() {
		String wynik = "";
		for(int i = 0; i < 5; i++) {
			wynik += wybory[generator.nextInt(wybory.length)];
		}
		return wynik;
	}

}
