package exercise1;

import java.io.File;

public class Ls {
	public static void main(String[] args){
		File[] f = new File(".").listFiles();
		for (File file : f){
			System.out.println(file.getName());
		}
	}
}
