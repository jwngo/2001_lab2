
public class HashMapping {

	private final static int TABLE_SIZE = 1000; // Declare a constant for table size
	public static int counter; // Number of Comparisons counter
	HashItem[] table;

	HashMapping() {
		table = new HashItem[TABLE_SIZE]; // Create a new hash table
		for (int i = 0; i < TABLE_SIZE; i++) {
			table[i] = null; // Set the value in each slot to NULL
		}
	}

	/* addItem method to insert a new item */
	public int addItem(int key, String value) {

		int hashIndex = key % TABLE_SIZE; // get a hash index from the key

		while (table[hashIndex] != null) { // if the slot is not empty
			if (table[hashIndex].getKey() != key) { // if the item in the slot is not the same as the key we want to insert
				hashIndex = (hashIndex + 1) % TABLE_SIZE; // move to the next slot
			} else { // if the item is the same
				return -1; // returns -1
			}
		}

		table[hashIndex] = new HashItem(key, value); // insert the item to the slot
		return 1;
	} // end addItem

	/* get method to search for the value of a key */
	public String get(int searchKey) {

		int hashIndex = searchKey % TABLE_SIZE; // get a hash index from the key
		int startLocation = hashIndex; // get the start location of the search
		counter = 1;
		while (table[hashIndex] != null) { // if the slot is not empty
			if (table[hashIndex].getKey() == searchKey) { // if the key inside the slot is the same as the search key
				return table[hashIndex].getValue(); // return the value of the item
			} else { // if the key inside the slot is not the same as the search key
				hashIndex = (hashIndex + 1) % TABLE_SIZE; // move to the next slot
				counter++; // Number of comparison +1
				if (hashIndex == startLocation) { // If the search is unsuccessful (i.e. returned to the first location)
					break; // break out of the loop
				}
			}
		}
		return null; // Unsuccessful search will return -1
	}
}