public class HashMapping {
  // Declare a constant for table size
  public final static int TABLE_SIZE = 1000;

  // Number of Comparisons counter
  public static int comparisonCounter;

  HashItem[] table;

  HashMapping() {
		table = new HashItem[TABLE_SIZE]; // Create a new hash table
		for (int i = 0; i < TABLE_SIZE; i++) {
			table[i] = null; // Set the value in each slot to NULL
		}
	}

  /**
   * addItem method to insert a new item key : name value : number
   */
  public int addItem(String name, int number, int functionNumber) {
    // Use simpleFunction to hash
    int hashIndex = HashFunctions.powerFunction(name, TABLE_SIZE);

    // Continue till the bucket is not empty
    while (table[hashIndex] != null) {
      if (table[hashIndex].getName() != name) {
        hashIndex = (hashIndex + 1) % TABLE_SIZE;
      } else {
        return -1;
      }
    }
    // Insert the item to the bucket
    table[hashIndex] = new HashItem(name, number);
    return 1;
  }

  /**
   * get method to search for the number given the name
   */
  public int get(String searchName, int functionNumber) {
    // Get the hashIndex from the searchName    
    int hashIndex = HashFunctions.powerFunction(searchName, TABLE_SIZE);
    // Get the start location of the search
    int startLocation = hashIndex;
    System.out.println(hashIndex);
    // Init the comparisonCounter 
    comparisonCounter = 1;
    // Continue till the bucket is not empty
    while (table[hashIndex]!=null) {
      // Name in the bucket is same as searchName, return the phone number
      if (table[hashIndex].getName().equals(searchName)) {
        return table[hashIndex].getNumber();
      }
      // Name is not the same, continue searching down
      // increase comparisonCounter
      else {
        hashIndex = (hashIndex + 1) % TABLE_SIZE ; 
        comparisonCounter++;
        if (hashIndex == startLocation) {
          break;
        }
      }
    }
    return -1;
  }

}