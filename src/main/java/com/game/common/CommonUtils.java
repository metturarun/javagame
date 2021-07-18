package com.game.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.game.character.Character;

public final class CommonUtils {

	public static String filepath = "/fighters/";

	public static void printLine() {
		System.out.println("--------------------------------------------------------------------------");
	}

	public static void printTextInline(String value) {
		System.out.println("\t" + value);
	}

	public static void printText(String value) {
		System.out.println(value);
	}

	public static void WriteObjectToFile(Object serObj, String fileName) {

		try {

			FileOutputStream fileOut = new FileOutputStream(fileName + ".txt");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(serObj);
			objectOut.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Character readObjectFromFile(String fileName) {
		Character person = new Character();
		try {
			FileInputStream fi = new FileInputStream(new File(fileName + ".txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);
			person = (Character) oi.readObject();
		} catch (Exception e) {
			person = null;
		}
		return person;
	}

}
