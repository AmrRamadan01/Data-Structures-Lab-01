/**
[By Amr Ramadan, 7/10/22, 03:59]

*GitHub repo:
https://github.com/AmrRamadan01/Data-Structures-Lab-01

*All FRs staified.
*Items to be added:
	1- A try-catch block to handle all invaild inputs such as "2+3+5" (done)
**/


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface ICalculator {
	/**
	* Adds given two numbers
	* @param x first number
	* @param y second number
	* @return the sum of the two numbers
	*/

	int add(String exp);
	/**
	* Divides two numbers.
	* @param exp is the input expression.
	* @return the addition result.
	*/
	float divide(String exp) throws RuntimeException;
	/**
	* Divides two numbers using integer division.
	* @param exp is the input expression.
	* @return the division result.
	**/
}


public class Calculator implements ICalculator{

	public static void main( String[] args){

		/**
		creating an instance of the calculator class to access the non-static
		methods of the ICalculator's Interface.
		**/
		Calculator calculator = new Calculator();

		//reading the input from the user.
		String expression = Calculator.getInput();


		/**
		This conditional block is to identify the type
		of the operator.
		**/

		if(Calculator.isAdd(expression)){
			int result = calculator.add(expression);
			System.out.println(result);
		}


		else if(Calculator.isDiv(expression)){

			/**
			The try-catch block is to avoid
			unhandled exeptions.
			**/
			try{
				float result = calculator.divide(expression);
				System.out.println(result);
			}

			/**
			* The catch block is reponsible for
			handeling illegal devision by zero.
			* It catches the ArithmaticException throwable.
			**/
			catch(ArithmeticException e){

				System.out.println("Error");
			}

		}

		else {
			System.out.println("Error");

		}

	}


	// User input reading method.
	public static String getInput(){

		// Instanciating a scanner object to scan the user input.
		Scanner sc = new Scanner(System.in);

		//System.out.println("Please Enter the expression to be evaluated: ");

		// reading the user input.
		String expStr = sc.nextLine();

		return (expStr);

	}


	// Addition operator detiction method implementation.
	public static boolean isAdd(String exp){

		/**
		This block uses the regular expression "/" to
		search for the division operator within the
		input string. Note: "//+" uses the escape
		character as "+" has a reserved meaning
		in regular expressions.
		**/

		Pattern operator = Pattern.compile("\\+");
		Matcher matcher = operator.matcher(exp);

		if(matcher.find()){

			return(true);
		}

		else {
			return(false);

		}

	}


	//Division operator detiction method implementation.
	public static boolean isDiv(String exp){

		/**
		This block uses the regular expression "/" to
		search for the division operator within the
		input string.
		**/

		Pattern operator = Pattern.compile("/");
		Matcher matcher = operator.matcher(exp);

		if(matcher.find()){

			return(true);
		}

		else {
			return(false);
		}
	}


	// Addition method implementation.
	public int add(String exp){

		/**
		This block splits the input string arround
		the addition operator, replaces the white
		spaces with empty strings, and converts
		the string operands to integers to
		be used in the result calculation. Again,
		the escape character in "//+" is used
		because "+" has reserved meaning in re.
		**/

		String [] strArr = exp.split("\\+",2);

		int operand1 = 0;
		int operand2 = 0;

		strArr[0] = strArr[0].replaceAll(" ", "");
		strArr[1] = strArr[1].replaceAll(" ", "");

		try{

		operand1 = Integer.parseInt(strArr[0]);
		operand2 = Integer.parseInt(strArr[1]);

		return(operand1 + operand2);

		}

		catch(Exception e){

			System.out.println("Error");
			return(000);
		}

	}


	//Division method implementation
	public float divide(String exp){

		/**
		This block splits the input string arround
		the division operator, replaces the white
		spaces with empty strings, and converts
		the string operands to integers to
		be used in the result calculation.

		The	try-catch block checks for INFINITY
		and NaN values returned by the float
		division. It throws an exception to be
		detected by the try-catch block enclosing
		the method call in the main method.
		**/

		String [] strArr = exp.split("/",2);

		int operand1 = 0;
		int operand2 = 0;

		strArr[0] = strArr[0].replaceAll(" ", "");
		strArr[1] = strArr[1].replaceAll(" ", "");



		operand1 = Integer.parseInt(strArr[0]);
		operand2 = Integer.parseInt(strArr[1]);


			if(operand2 == 0){
				throw  new ArithmeticException("Can't div by zero");
			}

			else{

				return((float) operand1 / operand2);
			}

	}

}
