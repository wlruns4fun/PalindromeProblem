public class Main {

	public static void main(String[] args) {
		String n = args[0];
		NumberObject numberObj = new NumberObject(n, 10);
		
		if (numberObj.getValue() < 0) {
			System.out.println("F(" + n + "): n must be > 0");
			
		} else {
		
			String numberStr;
			int b = 2;
			do {
				numberObj = numberObj.convertToBase(b++);
				numberStr = numberObj.getNumber();
				System.out.println(numberObj.getValue() + " = " + numberObj.getValueString());
				
			} while (!NumberObject.isPalindrome(numberStr));
			
			System.out.println("F(" + n + ") = " + --b);
		}
	}
}