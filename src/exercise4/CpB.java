package exercise4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CpB {
	public static void main(String[] args) {
		File dest = new File(args[args.length - 1]);
		File[] src = new File[args.length - 1];
		for (int i = 0; i < args.length - 1; i++){
			src[i] = new File(args[i]);
		}
		
		if (!dest.exists()){
			System.out.println("Destination does not exist!");
		}
		if (!dest.isDirectory()){
			System.out.println("Destination is not a directory!");
		}
		
		for (File srcFile : src){
			if (!srcFile.exists()){
				System.out.println("Source file does not exist!");
			} else{
				try {
					Files.copy(srcFile.toPath(), dest.toPath());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}