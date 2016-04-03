package com.lanx.utils;

import java.util.Scanner;

public class CLIUtils {
	public static char pause(){
		System.out.println("Press Any Char...");
		Scanner reader = new Scanner(System.in);
		char c = reader.next().charAt(0);
		return c; 
	}
}
