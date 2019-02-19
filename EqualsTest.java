public class EqualsTest {
	public static void main(String args[]) {

		String name1 = "Okkar Min";

		String name2 = "Okkar Min";

		String name3 = "Jia Wei";
		String name4 = "Jia Wei";

		System.out.println(name1.equals(name2));
		System.out.println(Math.abs(name1.hashCode()));
		System.out.println(Math.abs(name2.hashCode()));
		System.out.println(Math.abs(name3.hashCode()));
		System.out.println(name4.hashCode());
	}
}