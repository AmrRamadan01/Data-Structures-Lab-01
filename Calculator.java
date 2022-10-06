/**
[By Amr Ramadan, 6/10/22, 05:04]
*All FRs staified
*Items to be added:
	1- A try-catch block to handle all invaild inputs such as "2+3+5"
	2- A restriction to keep the operands between -220 < x ≤ 220 and -220 < y ≤ 220
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

		System.out.println("[Instruction Pointer]: Inside main()");

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
				System.out.println("[Error]: Devision by zero");
			}

		}

		else {
			System.out.println("\n[Error]: Invalid input expression.\n");

		}

	}


	// User input reading method.
	public static String getInput(){

		// Instanciating a scanner object to scan the user input.
		Scanner sc = new Scanner(System.in);

		System.out.println("Please Enter the expression to be evaluated: ");

		// reading the user input.
		String expStr = sc.nextLine();

		return (expStr);

	}


	// Addition operator detiction method implementation.
	public static boolean isAdd(String exp){

		System.out.println("Inside isAdd?");

		Pattern operator = Pattern.compile("\\+");
		Matcher matcher = operator.matcher(exp);

		if(matcher.find()){
			System.out.println("Addition operator detected!");
			return(true);
		}

		else {
			return(false);

		}

	}


	//Division operator detiction method implementation.
	public static boolean isDiv(String exp){

		System.out.println("Inside isDiv?");

		Pattern operator = Pattern.compile("/");
		Matcher matcher = operator.matcher(exp);

		if(matcher.find()){
			System.out.println("Division operator detected!");
			return(true);
		}

		else {
			return(false);
		}
	}


	// Addition method implementation.
	public int add(String exp){

		System.out.println("[Instruction Pointer]: Inside add()");

		String [] strArr = exp.split("\\+",2);

		int operand1 = 0;
		int operand2 = 0;

		strArr[0] = strArr[0].replaceAll(" ", "");
		operand1 = Integer.parseInt(strArr[0]);

		strArr[1] = strArr[1].replaceAll(" ", "");
		operand2 = Integer.parseInt(strArr[1]);

		return(operand1 + operand2);

	}


	//Division method implementation
	public float divide(String exp){

		System.out.println("[Instruction Pointer]: Inside devide()");

		String [] strArr = exp.split("/",2);

		int operand1 = 0;
		int operand2 = 0;

		strArr[0] = strArr[0].replaceAll(" ", "");
		strArr[1] = strArr[1].replaceAll(" ", "");

		try{
			operand1 = Integer.parseInt(strArr[0]);
			operand2 = Integer.parseInt(strArr[1]);
		}

		catch{
			System.out.println("[Error]: Non-integer input value");
		}
		return((float) operand1 / operand2);

	}

}
