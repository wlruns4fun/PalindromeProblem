import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumberObjectTest {

	private NumberObject numberObj;
	
	@Before
	public void setup() {
		numberObj = null;
	}
	
	@Test
	public void newNumberObject_returnsNullIfNumberIsNull() {
		// Given:
		String numberExpected = null;
		
		// When:
		NumberObject numberObjActual = new NumberObject(numberExpected, 2);
		String numberActual = numberObjActual.getNumber();
		
		// Then:
		Assert.assertEquals("getNumber() if null", numberExpected, numberActual);
	}
	
	@Test
	public void newNumberObject_returnsNumberWithSeparatorDigitsIfNumberIsInteger() {
		// Given:
		String numberExpected = "1" + NumberObject.DIGIT_SEPARATOR + "2" + NumberObject.DIGIT_SEPARATOR + "3";
		
		// When:
		NumberObject numberObjActual = new NumberObject(123, 2);
		String numberActual = numberObjActual.getNumber();
		
		// Then:
		Assert.assertEquals("getNumber() if number is integer", numberExpected, numberActual);
	}
	
	@Test
	public void getBase_returnsNullIfBaseIsLessThan2() {
		// Given:
		Integer baseExpected = null;
		
		// When:
		NumberObject numberObjActual = new NumberObject(1, 1);
		Integer baseActual = numberObjActual.getBase();
		
		// Then:
		Assert.assertEquals("getBase() if less than 2", baseExpected, baseActual);
	}
	
	@Test
	public void getNumber_returnsNullIfNumberIsNull() {
		// Given:
		Integer numberStringExpected = null;
		numberObj = new NumberObject(numberStringExpected, 2);
		
		// When:
		String numberStringActual = numberObj.getNumber();
		
		// Then:
		Assert.assertEquals("getNumber() if number is null", numberStringExpected, numberStringActual);
	}
	
	@Test
	public void getNumber_returnsPositiveIntegerString() {
		// Given:
		numberObj = new NumberObject(1, 2);
		String numberStringExpected = "1";
		
		// When:
		String numberStringActual = numberObj.getNumber();
		
		// Then:
		Assert.assertEquals("getNumber() if positive integer", numberStringExpected, numberStringActual);
	}
	
	@Test
	public void getNumber_returnsZeroString() {
		// Given:
		numberObj = new NumberObject(0, 2);
		String numberStringExpected = "0";
		
		// When:
		String numberStringActual = numberObj.getNumber();
		
		// Then:
		Assert.assertEquals("getNumber() if zero", numberStringExpected, numberStringActual);
	}
	
	@Test
	public void getNumber_returnsNegativeIntegerString() {
		// Given:
		numberObj = new NumberObject(-1, 2);
		String numberStringExpected = "-1";
		
		// When:
		String numberStringActual = numberObj.getNumber();
		
		// Then:
		Assert.assertEquals("getNumber() if negative integer", numberStringExpected, numberStringActual);
	}
	
	@Test
	public void getLength_returnsNullIfNumberIsNull() {
		// Given:
		Integer numberExpected = null;
		numberObj = new NumberObject(numberExpected, 2);
		Integer lengthExpected = null;
		
		// When:
		Integer lengthActual = numberObj.getLength();
		
		// Then:
		Assert.assertEquals("getLength() if number is null", lengthExpected, lengthActual);
	}
	
	@Test
	public void getLength_returnsLengthIfNumberIsPositive() {
		// Given:
		numberObj = new NumberObject(1, 2);
		Integer lengthExpected = 1;
		
		// When:
		Integer lengthActual = numberObj.getLength();
		
		// Then:
		Assert.assertEquals("getLength() if number is positive", lengthExpected, lengthActual);
	}
	
	@Test
	public void getLength_returnsLengthIfNumberIsNegative() {
		// Given:
		numberObj = new NumberObject(-1, 2);
		Integer lengthExpected = 1;
		
		// When:
		Integer lengthActual = numberObj.getLength();
		
		// Then:
		Assert.assertEquals("getLength() if number is negative", lengthExpected, lengthActual);
	}
	
	@Test
	public void getDigit_returnsNullIfNumberIsNull() {
		// Given:
		Integer numberExpected = null;
		numberObj = new NumberObject(numberExpected, 2);
		Integer digitExpected = null;
		
		// When:
		Integer digitActual = numberObj.getDigit(0);
		
		// Then:
		Assert.assertEquals("getDigit() if number is null", digitExpected, digitActual);
	}
	
	@Test
	public void getDigit_returnsNullIfIndexIsLessThanZero() {
		// Given:
		numberObj = new NumberObject(1, 2);
		Integer digitExpected = null;
		
		// When:
		Integer digitActual = numberObj.getDigit(-1);
		
		// Then:
		Assert.assertEquals("getDigit() if index is negative", digitExpected, digitActual);
	}
	
	@Test
	public void getDigit_returnsNullIfIndexIsGreaterThanLength() {
		// Given:
		numberObj = new NumberObject(1, 2);
		Integer digitExpected = null;
		
		// When:
		Integer digitActual = numberObj.getDigit(1);
		
		// Then:
		Assert.assertEquals("getDigit() if index is greater than length", digitExpected, digitActual);
	}
	
	@Test
	public void getDigit_returnsDigitIfIndexIs0() {
		// Given:
		numberObj = new NumberObject(123, 4);
		Integer digitExpected = 3;
		
		// When:
		Integer digitActual = numberObj.getDigit(0);
		
		// Then:
		Assert.assertEquals("getDigit() if index is 0", digitExpected, digitActual);
	}
	
	@Test
	public void getDigit_returnsDigitIfIndexIs1() {
		// Given:
		numberObj = new NumberObject(123, 4);
		Integer digitExpected = 2;
		
		// When:
		Integer digitActual = numberObj.getDigit(1);
		
		// Then:
		Assert.assertEquals("getDigit() if index is 1", digitExpected, digitActual);
	}
	
	@Test
	public void getDigit_returnsDigitIfIndexIs2() {
		// Given:
		numberObj = new NumberObject(123, 4);
		Integer digitExpected = 1;
		
		// When:
		Integer digitActual = numberObj.getDigit(2);
		
		// Then:
		Assert.assertEquals("getDigit() if index is 2", digitExpected, digitActual);
	}
	
	@Test
	public void getDigit_IfNumberIsNegative() {
		// Given:
		numberObj = new NumberObject(-123, 10);
		Integer digitExpected = -1;
		
		// When:
		Integer digitActual = numberObj.getDigit(2);
		
		// Then:
		Assert.assertEquals("getDigit() if number is negative", digitExpected, digitActual);
	}
	
	@Test
	public void getValue_returnsNullIfNumberisNull() {
		// Given:
		Integer numberExpected = null;
		numberObj = new NumberObject(numberExpected, 2);
		Integer valueExpected = null;
		
		// When:
		Integer valueActual = numberObj.getValue();
		
		// Then:
		Assert.assertEquals("getValue() if number is null", valueExpected, valueActual);
	}
	
	@Test
	public void getValue_returnsNullIfBaseIsNull() {
		// Given:
		numberObj = new NumberObject(1, null);
		Integer valueExpected = null;
		
		// When:
		Integer valueActual = numberObj.getValue();
		
		// Then:
		Assert.assertEquals("getValue() if base is null", valueExpected, valueActual);
	}
	
	@Test
	public void getValue_returnsValueOf0Base10() {
		// Given:
		numberObj = new NumberObject(0, 10);
		Integer valueExpected = 0;
		
		// When:
		Integer valueActual = numberObj.getValue();
		
		// Then:
		Assert.assertEquals("getValue() of 0 base 10", valueExpected, valueActual);
	}
	
	@Test
	public void getValue_returnsValueOf1Base10() {
		// Given:
		numberObj = new NumberObject(1, 10);
		Integer valueExpected = 1;
		
		// When:
		Integer valueActual = numberObj.getValue();
		
		// Then:
		Assert.assertEquals("getValue() of 1 base 10", valueExpected, valueActual);
	}
	
	@Test
	public void getValue_returnsValueOf10Base10() {
		// Given:
		numberObj = new NumberObject(10, 10);
		Integer valueExpected = 10;
		
		// When:
		Integer valueActual = numberObj.getValue();
		
		// Then:
		Assert.assertEquals("getValue() of 10 base 10", valueExpected, valueActual);
	}
	
	@Test
	public void getValue_returnsValueOf1Base2() {
		// Given:
		numberObj = new NumberObject(1, 2);
		Integer valueExpected = 1;
		
		// When:
		Integer valueActual = numberObj.getValue();
		
		// Then:
		Assert.assertEquals("getValue() of 1 base 2", valueExpected, valueActual);
	}
	
	@Test
	public void getValue_returnsValueOf10Base2() {
		// Given:
		numberObj = new NumberObject(10, 2);
		Integer valueExpected = 2;
		
		// When:
		Integer valueActual = numberObj.getValue();
		
		// Then:
		Assert.assertEquals("getValue() of 10 base 2", valueExpected, valueActual);
	}
	
	@Test
	public void getValue_IfNumberIsNegative() {
		// Given:
		numberObj = new NumberObject(-123, 10);
		Integer valueExpected = -123;
		
		// When:
		Integer valueActual = numberObj.getValue();
		
		// Then:
		Assert.assertEquals("getValue() of -123 base 10", valueExpected, valueActual);
	}
	
	@Test
	public void convertToBase_returnsNullIfTheNumberIsNull() {
		// Given:
		Integer numberExpected = null;
		numberObj = new NumberObject(numberExpected, 2);
		NumberObject numberObjExpected = null;
		
		// When:
		NumberObject numberObjActual = numberObj.convertToBase(10);
		
		// Then:
		Assert.assertEquals("convertToBase() if number is null", numberObjExpected, numberObjActual);
	}
	
	@Test
	public void convertToBase_returnsNullIfTheBaseIsNull() {
		// Given:
		numberObj = new NumberObject(1, null);
		NumberObject numberObjExpected = null;
		
		// When:
		NumberObject numberObjActual = numberObj.convertToBase(10);
		
		// Then:
		Assert.assertEquals("convertToBase() if base is null", numberObjExpected, numberObjActual);
	}
	
	@Test
	public void convertToBase_returnsNullIfTheNewBaseIsNull() {
		// Given:
		numberObj = new NumberObject(1, 2);
		NumberObject numberObjExpected = null;
		
		// When:
		NumberObject numberObjActual = numberObj.convertToBase(null);
		
		// Then:
		Assert.assertEquals("convertToBase() if new base is null", numberObjExpected, numberObjActual);
	}
	
	@Test
	public void convertToBase_returnsNullIfTheNewBaseIsLessThan2() {
		// Given:
		numberObj = new NumberObject(1, 2);
		NumberObject numberObjExpected = null;
		
		// When:
		NumberObject numberObjActual = numberObj.convertToBase(1);
		
		// Then:
		Assert.assertEquals("convertToBase() if new base is less than 2", numberObjExpected, numberObjActual);
	}
	
	@Test
	public void convertToBase_returnsANewNumberObjectWithADifferentNumber() {
		// Given:
		String numberExpected = "1 0";
		Integer baseExpected = 10;
		numberObj = new NumberObject(numberExpected, baseExpected);
		
		// When:
		NumberObject numberObjActual = numberObj.convertToBase(2);
		String numberActual = numberObjActual.getNumber();
		
		// Then:
		Assert.assertNotEquals("convertToBase() should be a different number", numberExpected, numberActual);
	}
	
	@Test
	public void convertToBase_returnsANewNumberObjectWithANegativeValue() {
		// Given:
		Integer numberExpected = -10;
		Integer baseExpected = 10;
		numberObj = new NumberObject(numberExpected, baseExpected);
		
		// When:
		NumberObject numberObjActual = numberObj.convertToBase(2);
		Integer valueActual = numberObjActual.getValue();
		
		// Then:
		Assert.assertTrue("convertToBase() should still be negative", valueActual < 0);
	}
	
	@Test
	public void convertToBase_returnsANewNumberObjectWithADifferentBase() {
		// Given:
		Integer numberExpected = 10;
		Integer baseExpected = 10;
		numberObj = new NumberObject(numberExpected, baseExpected);
		
		// When:
		NumberObject numberObjActual = numberObj.convertToBase(2);
		Integer baseActual = numberObjActual.getBase();
		
		// Then:
		Assert.assertNotEquals("convertToBase() should be a different base", baseExpected, baseActual);
	}
	
	@Test
	public void convertToBase_returnsANewNumberObjectWithTheSameValue() {
		// Given:
		Integer numberExpected = 10;
		Integer baseExpected = 10;
		Integer valueExpected = 10;
		numberObj = new NumberObject(numberExpected, baseExpected);
		
		// When:
		NumberObject numberObjActual = numberObj.convertToBase(2);
		Integer valueActual = numberObjActual.getValue();
		
		// Then:
		Assert.assertEquals("convertToBase() should keep the same value", valueExpected, valueActual);
	}
	
	@Test
	public void convertToBase_returnsANewNumberObjectWithABaseMoreThan10() {
		// Given:
		Integer numberExpected = 47;
		Integer baseExpected = 10;
		Integer valueExpected = 47;
		numberObj = new NumberObject(numberExpected, baseExpected);
		
		// When:
		NumberObject numberObjActual = numberObj.convertToBase(12);
		Integer valueActual = numberObjActual.getValue();
		
		// Then:
		Assert.assertEquals("convertToBase() with a base more than 10", valueExpected, valueActual);
	}
	
	@Test
	public void isPalindrome_returnsFalseIfNull() {
		// Given:
		String value = null;
		Boolean resultExpected = false;
		
		// When:
		Boolean resultActual = NumberObject.isPalindrome(value);
		
		// Then:
		Assert.assertEquals("isPalindrome() if null", resultExpected, resultActual);
	}
	
	@Test
	public void isPalindrome_returnsTrueIfEmptyString() {
		// Given:
		String value = "";
		Boolean resultExpected = true;
		
		// When:
		Boolean resultActual = NumberObject.isPalindrome(value);
		
		// Then:
		Assert.assertEquals("isPalindrome() if empty string", resultExpected, resultActual);
	}
	
	@Test
	public void isPalindrome_returnsTrueIfSingleCharacter() {
		// Given:
		String value = "a";
		Boolean resultExpected = true;
		
		// When:
		Boolean resultActual = NumberObject.isPalindrome(value);
		
		// Then:
		Assert.assertEquals("isPalindrome() if single character", resultExpected, resultActual);
	}
	
	@Test
	public void isPalindrome_returnsFalseIfFirstAndLastCharactersAreDifferent() {
		// Given:
		String value = "ab";
		Boolean resultExpected = false;
		
		// When:
		Boolean resultActual = NumberObject.isPalindrome(value);
		
		// Then:
		Assert.assertEquals("isPalindrome() if first & last character are different", resultExpected, resultActual);
	}
	
	@Test
	public void isPalindrome_returnsTrueIfFirstAndLastCharactersAreTheSame() {
		// Given:
		String value = "aa";
		Boolean resultExpected = true;
		
		// When:
		Boolean resultActual = NumberObject.isPalindrome(value);
		
		// Then:
		Assert.assertEquals("isPalindrome() if first & last character are the same", resultExpected, resultActual);
	}
	
	@Test
	public void isPalindrome_returnsTrueIf3CharacterPalindrome() {
		// Given:
		String value = "aba";
		Boolean resultExpected = true;
		
		// When:
		Boolean resultActual = NumberObject.isPalindrome(value);
		
		// Then:
		Assert.assertEquals("isPalindrome() if 3 character palindrome", resultExpected, resultActual);
	}
	
	@Test
	public void isPalindrome_returnsFalseIf4CharacterNonPalindrome() {
		// Given:
		String value = "abca";
		Boolean resultExpected = false;
		
		// When:
		Boolean resultActual = NumberObject.isPalindrome(value);
		
		// Then:
		Assert.assertEquals("isPalindrome() if 4 character non-palindrome", resultExpected, resultActual);
	}
	
	@Test
	public void isPalindrome_returnsTrueIf4CharacterPalindrome() {
		// Given:
		String value = "abba";
		Boolean resultExpected = true;
		
		// When:
		Boolean resultActual = NumberObject.isPalindrome(value);
		
		// Then:
		Assert.assertEquals("isPalindrome() if 4 character palindrome", resultExpected, resultActual);
	}
	
	@Test
	public void getValueString_returnsNullIfNumberIsNull() {
		// Given:
		Integer numberExpected = null;
		numberObj = new NumberObject(numberExpected, 2);
		String stringExpected = null;
		
		// When:
		String stringActual = numberObj.getValueString();
		
		// Then:
		Assert.assertEquals("getValueString() if number is null", stringExpected, stringActual);
	}
	
	@Test
	public void getValueString_returnsNullIfBaseIsNull() {
		// Given:
		numberObj = new NumberObject(1, null);
		String stringExpected = null;
		
		// When:
		String stringActual = numberObj.getValueString();
		
		// Then:
		Assert.assertEquals("getValueString() if base is null", stringExpected, stringActual);
	}
	
	@Test
	public void getValueString_returnsValueStringEquation() {
		// Given:
		numberObj = new NumberObject(123, 10);
		String stringExpected = "1*(10^2) + 2*(10^1) + 3*(10^0)";
		
		// When:
		String stringActual = numberObj.getValueString();
		
		// Then:
		Assert.assertEquals("getValueString() returns value string equation", stringExpected, stringActual);
	}
}
