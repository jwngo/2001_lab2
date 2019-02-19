import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Search {
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		HashMapping hashMap = new HashMapping();
		long startTime, endTime, executionTime;

		generateData(hashMap); // Generate data and add the data into the hash table

		System.out.print("Enter item key: "); // Prompt user to input a key for searching
		String searchName = sc.nextLine();


		while (!searchName.equals("quit")) {

			startTime = System.nanoTime(); // Get the start time of the search
			int phoneNumber = hashMap.get(searchName); // Search the phonenumber inside the hash table
			endTime = System.nanoTime(); // Get the end time of the search
			executionTime = endTime - startTime; // Get the execution time (i.e. endTime - startTime)

			// Successful search
			if (phoneNumber != -1) { // If the search is successful
				/* prints output of the search */
				System.out.println("Search Successful");
				System.out.println("Your item key is = " + searchName);
				System.out.println("Phone number is = " + phoneNumber);
				System.out.println("Number of Comparisons = " + HashMapping.comparisonCounter + " comparisons.");
				System.out.println("Execution time = " + executionTime + " ns");
			} else { // If the search is unsuccessful
				/* prints the output of the search */
				System.out.println("Search Unsuccessful");
				System.out.println("Phone number is = " + phoneNumber);
				System.out.println("Number of Comparisons = " + HashMapping.comparisonCounter + " comparisons.");
				System.out.println("Execution time = " + executionTime + " ns");
			}

			System.out.print("\nEnter name: "); // Prompt user to input a key for searching
			searchName = sc.nextLine();
		}
		System.out.println("terminating");

	} // End Main

	public static void generateData(HashMapping hashMap, double loadFactors, int functionNumber) throws IOException {
		FileReader fr = new FileReader("names.txt");
		BufferedReader br = new BufferedReader(fr);
		Random rand = new Random();
		int dataSize = TABLE_SIZE * loadFactors;
		int dataCounter = 0;

		while (dataCounter < dataSize) { // Generate data as much as DATA_SIZE
			// Get name from the file
			String name = br.readLine();
			// Generate 8-digit phone number starting with 8 or 9
			int number = rand.nextInt(20000000) + 80000000;
			
			System.out.println(name + "\t : " + number);

			// Add the data into the hash table
			if (hashMap.addItem(name, number) == 1) {
				dataCounter++;
			}
		}
	}
}