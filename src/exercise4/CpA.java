package exercise4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CpA {
	public static void main(String[] args) {
		
		File src = new File(args[0]);
		File dest = new File(args[1]);
		boolean overwrite = true;
		
		if (!src.exists()){
			System.out.println("Source file does not exist!");
		} else if (dest.exists()){
			System.out.println("Destination file already exists. Overwrite? Y/n");
			Scanner in = new Scanner(System.in);
			if (!in.nextLine().toUpperCase().equals("Y")) overwrite = false;
		}
		
		if (src.exists() && overwrite == true){
			try {
				PrintWriter out = new PrintWriter(dest);
				BufferedReader in = new BufferedReader(new FileReader(src));
				String nextLine = in.readLine();
				while (nextLine != null){
					out.write(nextLine);
					nextLine = in.readLine();
				}
				in.close();
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}