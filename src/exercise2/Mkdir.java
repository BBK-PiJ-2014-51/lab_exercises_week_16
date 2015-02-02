package exercise2;

import java.io.File;

public class Mkdir {
	public static void main(String[] args) {
		String path = "";
		for(String dir : args){
			path += dir + "/";
		}
		boolean result = new File(path).mkdir();
		System.out.println("Result");
	}
}
