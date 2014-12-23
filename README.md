# Palindrome Problem

F(n) = b:
* *n* is a positive integer 
* *b* is the smallest integer base >= 2 such that *n* can be represented as a [palindrome](http://en.wikipedia.org/wiki/Palindrome) 

## Examples:

F(0) = 2:	
* (b = 2) => '0 (base 10)' = 0*(2^0) => '0 (base 2)'

F(42) = 4:	
* (b = 2) => '42 (base 10)' = 1*(2^5) + 0*(2^4) + 1*(2^3) + 0*(2^2) + 1*(2^1) + 0*(2^0) => '101010 (base 2)'  
* (b = 3) => '42 (base 10)' = 1*(3^3) + 1*(3^2) + 2*(3^1) + 0*(3^0) => '1120 (base 3)'
* (b = 4) => '42 (base 10)' = 2*(4^2) + 2*(4^1) + 2*(4^0) => '222 (base 4)'