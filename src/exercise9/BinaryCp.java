package exercise9;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class BinaryCp {
	public static void main(String[] args) {
		File src = new File("src/exercise9/Tr.class");
		File dest = new File("src/exercise9/test.class");
		boolean overwrite = true;
		
		if (!src.exists()){
			System.out.println("Source file does not exist!");
		} else if (dest.exists()){
			System.out.println("Destination file already exists. Overwrite? Y/n");
			Scanner in = new Scanner(System.in);
			if (!in.nextLine().toUpperCase().equals("Y")) overwrite = false;
			in.close();
		}
		
		if (src.exists() && overwrite == true){
			try {
				FileOutputStream out = new FileOutputStream(dest);
				FileInputStream in = new FileInputStream(src);
				byte[] bytes = new byte[1024];
				int numBytes = in.read(bytes);
				while( numBytes != -1 ){
                      out.write(bytes, 0, numBytes);
                      numBytes = in.read(bytes);
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