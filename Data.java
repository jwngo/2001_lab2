import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Data {
	public static void generateData(HashMapping hashMap, double loadFactor, int functionNumber) throws IOException {
		FileReader fr = new FileReader("names.txt");
		BufferedReader br = new BufferedReader(fr);
		Random rand = new Random();
		int dataSize = (int) (HashMapping.TABLE_SIZE * loadFactor);
		System.out.println("DATASIZE: " + dataSize);
		int dataCounter = 0;

		while (dataCounter < dataSize) { // Generate data as much as DATA_SIZE
			// Get name from the file
			String name = br.readLine();
			// Generate 8-digit phone number starting with 8 or 9
			int number = rand.nextInt(20000000) + 80000000;
			// Add the data into the hash table
			if (hashMap.addItem(name, number, functionNumber) == 1) {
				dataCounter++;
			}
		}
	}
}