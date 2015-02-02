package exercise3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CatB {
	public static void main(String[] args) throws IOException{
		for (String filename : args){
			File file = new File(filename);
			if (file.exists()){
				BufferedReader in = new BufferedReader(new FileReader(file));
				String nextLine = in.readLine();
				while (nextLine != null){
					System.out.println(nextLine);
					nextLine = in.readLine();
				}
				in.close();
			} else {
				System.out.println(filename + " does not exist.");
			}
		}
	}
}
