# Data Structures Lab 01

## latest Release **(1.1)**

## Problem Statement

You are required to create a simple calculator class that performs addition and division of 2 integers x and y.

Your class should implement ICalculator interface and contain a main method to parse the input from stdin and print the output to stdout.

Input Format

-

Constraints

-220 < x ≤ 220 and -220 < y ≤ 220

If an error occurs, your program should print "Error" to stdout in a seprate line.

Output Format

-

### Sample Inputs

Sample Input 0

2 + 3
Sample Output 0

5
Sample Input 1

-3 + -2
Sample Output 1

-5
Sample Input 2

3 / 5
Sample Output 2

0.6

## Notes on Release 1.1

The task required "Error" message to be printed to the stdout stream in case of any errors. The previous release 1.0 did not satisfy this requirement. Instead, it throws an exception with a custom error message.
