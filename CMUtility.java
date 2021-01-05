package com.project02;
/*CMUtility tool class
 * 
 * 
 */
import java.util.*;

public class CMUtility {
private static Scanner scanner = new Scanner(System.in);
	/*Used to select 1-5
	 * 
	 */
	public static char readMenuSelection() {
		char c;
		for(;;) {
			String str = readKeyBoard(1,false);
			c = str.charAt(0);
			if(c !='1'&&c!='2'&&c!='3'&&c!='4'&&c!='5') {
				System.out.println("the wrong selection,enter again:");
			}else break;
		}
		return c;
	}
	/*Read characters from the keyboard and return
	 * If the user does not input, it will be returned as the default value
	 */
	public static char readChar() {
		String str = readKeyBoard(1,false);
		return str.charAt(0);
	}
	public static char readChar(char defaultValue) {
		String str = readKeyBoard(1,true);
		return (str.length()==0) ? defaultValue:str.charAt(0);
	}
	/*
	 * Read an integer not exceeding two digits from the keyboard and return it.
	 * If there is no input, the default Value is returned.
	 */
	public static int readInt() {
		int n;
		for(;;) {
			String str = readKeyBoard(2,false);
			try {
				n = Integer.parseInt(str);
				break;
			}catch(NumberFormatException e) {
				System.out.println("the wrong number input,enter again:");
			}
		} return n;
	}
	public static int readInt(int defaultValue) {
		int n;
		for(;;) {
			String str = readKeyBoard(2,true);
			if(str.equals("")) {
				return defaultValue;
			}
			try {
				n = Integer.parseInt(str);
				break;
			}catch(NumberFormatException e) {
				System.out.println("the wrong number input,enter again:");
			}
		} return n;
	}
	/*
	 * Read the input string, such as: name, phone number, etc.
	 * If there is no input, return the default Value
	 */
	public static String readString(int limit) {
		String str = readKeyBoard(limit,false);
		return str;
	}
	public static String readString(int limit,String defaultValue) {
		String str = readKeyBoard(limit,true);
		return str.equals("") ? defaultValue : str;
	}
	/*
	 * Used to read ‘Y’ or ‘N’ from the keyboard and return
	 * 
	 */
	public static char readConfirmSelection() {
		char c;
		for(;;) {
			String str = readKeyBoard(1,false).toUpperCase();
			c = str.charAt(0);
			if(c=='Y'||c=='N') {
				break;
			}else {
				System.out.println("the wrong selection,enter again:");
			}
		}
		return c;
	}
	/*
	 * Read data from keyboard
	 * 
	 */
	public static String readKeyBoard(int limit,boolean blankReturn) {
		String line = "";
		while(scanner.hasNext()) {
			line = scanner.nextLine();
			if(line.length()==0) {
				if(blankReturn) return line;
				else continue;
			}
		
			if(line.length()<1||line.length()>limit) {
				System.out.print("Input length (not greater than"+limit+") Error, please re-enter:");
				continue;
			}
			break;
		}
		return line;
	}
	

}
