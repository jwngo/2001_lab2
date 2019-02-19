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
    
    int hashIndex = 0;
    // Get the hashIndex from the searchName depending on the functionNumber
    switch (functionNumber) {
      case 0:
        hashIndex = HashFunctions.simpleFunction(name, TABLE_SIZE);
        break;
      case 1:
        hashIndex = HashFunctions.logFunction(name, TABLE_SIZE);
        break;
      case 2:
        hashIndex = HashFunctions.saltFunction(name, TABLE_SIZE);
        break;
      case 3:
        hashIndex = HashFunctions.alternatingFunction(name, TABLE_SIZE);
        break;
      default:
        break;
    }

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
    
    int hashIndex = 0;
    // Get the hashIndex from the searchName depending on the functionNumber
    switch (functionNumber) {
      case 0:
        hashIndex = HashFunctions.simpleFunction(searchName, TABLE_SIZE);
        break;
      case 1:
        hashIndex = HashFunctions.logFunction(searchName, TABLE_SIZE);
        break;
      case 2:
        hashIndex = HashFunctions.saltFunction(searchName, TABLE_SIZE);
        break;
      case 3:
        hashIndex = HashFunctions.alternatingFunction(searchName, TABLE_SIZE);
        break;
      default:
        break;
    }   
    // Get the start location of the search
    int startLocation = hashIndex;
    // Init the comparisonCounter 
    comparisonCounter = 0;
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