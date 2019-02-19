import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LinearProbingDemo {
	// We want average Execution time AND average comparisons for a fixed 100
	// searches (successful AND unsuccessful)

	// We want to do this for 4 load factors
	public static void main(String args[]) {
    // Change this to use other hashing functions
    int functionNumber = 1;
    boolean success = true;
  
		BufferedReader objReader = null;
    
    // Variables for successful
		String successfulSearchName;
		long successStartTime, successEndTime, successXecutionTime;
		long successTotalXecutionTime = 0;
		long successAverageXecutionTime = 0;
		int successTotalComparisons = 0;
		int successAverageComparisons = 0;

		// Defining the load factors
		double[] loadFactors = { 0.25, 0.5, 0.75, 1 };

		// Do for each of 4 load factors
		for (int i = 0; i < 4; i++) {
			// Doing it for successful search
			try {
				objReader = new BufferedReader(new FileReader("names.txt"));

				// Generate data according to loadFactor
				HashMapping hashMap = new HashMapping();
				Data.generateData(hashMap, loadFactors[i], functionNumber);

				while ((successfulSearchName = objReader.readLine()) != null) {
          // for each success search
					successStartTime = System.nanoTime();
					int phoneNumber = success ? hashMap.get(successfulSearchName , functionNumber) : hashMap.get(successfulSearchName + "o" , functionNumber);
					successEndTime = System.nanoTime();
					successXecutionTime = successEndTime - successStartTime;
					successTotalXecutionTime += successXecutionTime;
					successTotalComparisons += HashMapping.comparisonCounter;

				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				System.out.println("LoadFactor: " + loadFactors[i] + "\nResults: ");

				successAverageXecutionTime = successTotalXecutionTime / (int)(HashMapping.TABLE_SIZE * loadFactors[i]);
				successAverageComparisons = successTotalComparisons / (int)(HashMapping.TABLE_SIZE * loadFactors[i]);

				System.out.println("The average execution time is: " + successAverageXecutionTime + "ns");
				System.out.println("The average number of comparisons are: " + successAverageComparisons + "\n\n");


				try {
					if (objReader != null)
						objReader.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}

				successTotalComparisons = 0;
				successTotalXecutionTime = 0;
			}
		}
	}
}