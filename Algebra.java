// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(65,2));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
		System.out.println(sqrt(100));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2 >= 0){
			for(int i = 0; i < x2; i++){
				x1 ++;
			}
		}else{
			x1 = minus(x1, -x2);
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if(x2 > 0){
		for(int i = 0; i < x2; i++){
			x1--;
		}
	}else{
		x1 = plus(x1, -x2);
	}

		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		if (x1 ==0 || x2 == 0) {
			return 0;
		}
		int newX = x1;
		if (x2 > 0){
			for(int i = 1; i < x2; i++){
				newX = plus(newX, x1);
			}
		}else{
			for (int j = 0; j<= -x2; j++){
				newX = minus(newX, x1);
			}
		}
		return newX;
	}
	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n < 0){
			return 0;
		}
		if (n == 0){
			return 1;
		}else{
		int newPowX = x;
		for (int i = 1; i < n; i++){
			newPowX = times(newPowX, x);
		}
		return newPowX;
	}
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int counter = 1;
		int minusCounter = 0;
		if (x1 == 0){
			return 0;
		}
		if (x1 < 0){
			x1 = minus(0, x1);
			minusCounter ++;
		}
		if (x2 < 0) {
			x2 = minus(0, x2);
			minusCounter --;
		}
		int newDivX = x2;
		while (newDivX < x1){
			newDivX = plus(newDivX, x2);
			counter ++;
		}
		if (newDivX > x1){
			counter = minus(counter, 1);
		}
		if (minusCounter != 0){
			return minus(0, counter);
		}
		return counter;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int divResult = div(x1, x2);
		return minus(x1, times(divResult, x2));
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int sqrtResult = 0;
		while (pow(sqrtResult, 2) <= x){
			sqrtResult ++;
		}
		sqrtResult = minus(sqrtResult, 1);
		return sqrtResult;
	}	  	  
}