package exercise5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Tr {
	public static void main(String[] args) {
		File file = new File(args[0]);
		String find = args[1];
		String replace = args[2];
		if (file.exists()){
			BufferedReader in;
			try {
				in = new BufferedReader(new FileReader(file));
				String nextLine = in.readLine();
				while (nextLine != null){
					nextLine = nextLine.replace(find, replace);
					System.out.println(nextLine);
					nextLine = in.readLine();
				}
				in.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(file.toPath() + " does not exist.");
		}
	}
}