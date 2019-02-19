/* 
* Helper class that contains different hashing functions
*/
public class HashFunctions {

	public static int simpleFunction(String name, int sizeOfTable) {
		int hashIndex = 0;
		int key = Math.abs(name.hashCode());
		
		hashIndex = key % sizeOfTable;

		return hashIndex;
	}

	/**
	 * We floor the logarithm so that we will only be handling integers and not float 
	 */
	public static int logFunction(String name, int sizeOfTable) {
		int hashIndex = 0;
		int key = Math.abs(name.hashCode());
				
		hashIndex = (int) Math.floor(Math.log(key)) % sizeOfTable;

		return hashIndex;
	}

	public static int saltFunction(String name, int sizeOfTable) {
		int hashIndex = 0;
		int key = Math.abs(name.hashCode());
		
		int salt = 999;
		hashIndex = (key - salt) % sizeOfTable;

		return hashIndex;
	}

	public static int alternatingFunction(String name, int sizeOfTable) {
		int hashIndex = 0;
		int key = Math.abs(name.hashCode());
		
		key = key % 1100050001;

		hashIndex = ( key * key ) % sizeOfTable;
		
		return hashIndex;
	}

}