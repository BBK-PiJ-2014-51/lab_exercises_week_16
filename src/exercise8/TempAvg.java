package exercise8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TempAvg {

	public static void main(String[] args) {
		File file = new File("src/exercise8/temps.csv");
		if (file.exists()){
			BufferedReader in = null;
			try {
				in = new BufferedReader(new FileReader(file));
				String nextLine = null;
				nextLine = in.readLine();
				int grandtotal = 0;
				int counttotal = 0;
				while (nextLine != null){
					String[] nums = nextLine.split(", ");
					int count = 0;
					int total = 0;
					for (String num : nums){
						total += Integer.parseInt(num);
						count++;
					}
					int lineAvg = total / count;
					System.out.println(String.valueOf( lineAvg));
					grandtotal += lineAvg;
					counttotal++;
					nextLine = in.readLine();
				}
				System.out.println("total: " + String.valueOf(grandtotal / counttotal));
				in.close();
			} catch (IOException e) {
					e.printStackTrace();
			}
			} else {
			try {
				System.out.println(file.getCanonicalPath() + " does not exist.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
