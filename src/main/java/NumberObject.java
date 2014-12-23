public class NumberObject {

	public static String DIGIT_SEPARATOR = " ";
	
	private String number;
	private Integer base;
	
	public NumberObject(Integer number, Integer base) {
		if (null != number) {
			
			this.number = "";
			String rawNumberStr = number.toString();
			int rawLength = rawNumberStr.length();
			
			for (int i=0; i<rawLength; i++) {
				char digit = rawNumberStr.charAt(i);
				this.number += digit;
				if (i < rawLength-1 && digit != '-') {
					this.number += DIGIT_SEPARATOR;
				}
			}
		}
		
		if (null != base && base > 1) {
			this.base = base;
		}
	}
	
	public NumberObject(String number, Integer base) {
		this.number = number;
		if (null != base && base > 1) {
			this.base = base;
		}
	}
	
	public String getNumber() {
		return number;
	}
	
	public Integer getBase() {
		return base;
	}
	
	public Integer getLength() {
		Integer length = null;
		if (null != number) {
			
			String[] digits = number.split(DIGIT_SEPARATOR);
			return digits.length;
		}
		
		return length;
	}
	
	public Integer getDigit(int index) {
		Integer digit = null;
		if (null != number) {
			
			int length = getLength();
			if (index >= 0 && index < length) {
				
				String[] digits = number.split(DIGIT_SEPARATOR);
				String digitStr = digits[length-1-index];
				digit = Integer.parseInt(digitStr);
			}
		}
		
		return digit;
	}
	
	public Integer getValue() {
		Integer value = null;
		if (null != number && null != base) {
			
			value = 0;
			int length = getLength();
			for (int i=0; i<length; i++) {
				
				double baseValue = Math.pow(base, i);
				double digitValue = baseValue * getDigit(i);
				value += (int) Math.abs(digitValue);
				if (digitValue < 0) {
					value *= -1;
				}
			}
		}
		
		return value;
	}
	
	public NumberObject convertToBase(Integer newBase) {
		if (null != number && null != base && null != newBase && newBase > 1) {
			
			String newNumber = "";
			double valueRemaining = Math.abs(getValue());
			int i = 0;
			double baseValue;
			double quotient;
			
			do {
				baseValue = Math.pow(newBase, i++);
				quotient = valueRemaining / baseValue;
				
			} while (quotient >= 1);
			
			for (i-=2; i>=0; i--) {
				baseValue = Math.pow(newBase, i);
				quotient = valueRemaining / baseValue;
				
				Integer digit = (int) quotient;
				double digitValue = digit * baseValue;
				
				valueRemaining -= digitValue;
				newNumber += digit.toString();
				if (i > 0) {
					newNumber += DIGIT_SEPARATOR;
				} else if (0 == i && getValue() < 0) {
					newNumber = "-" + newNumber;
				} 
			}
			
			NumberObject newNumberObj = new NumberObject(newNumber, newBase);
			
			return newNumberObj;
		}
		
		return null;
	}
	
	public static Boolean isPalindrome(String value) {
		if (null != value) { 
			
			if (value.length() < 2) {
				return true;
				
			} else {
				char firstChar = value.charAt(0);
				char lastChar = value.charAt(value.length()-1);
				
				if (firstChar == lastChar) {
					String middleChars = value.substring(1, value.length()-1);
					return isPalindrome(middleChars);
				}
			}
		}
		
		return false;
	}
	
	public String getValueString() {
		String valueStr = null;
		if (null != number && null != base) {
			
			valueStr = "";
			int length = getLength();
			for (int i=0; i<length; i++) {
				
				Integer digit = getDigit(i);
				String digitStr = digit + "*(" + base + "^" + i + ")";
				if (i > 0) {
					digitStr += " + ";
				}
				
				valueStr = digitStr + valueStr;
			}
		}
		
		return valueStr;
	}
}
