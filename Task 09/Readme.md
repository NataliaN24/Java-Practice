Devising A Teen Number Checker For Mastery Of Conditional Range Checking
We'll say that a number is "teen" if it is in the range 13 -19 (inclusive).
Write a method named hasTeen with 3 parameters of type int.
The method should return boolean and it needs to return true if one of the parameters is in range 13(inclusive) - 19 (inclusive). Otherwise return false.

EXAMPLES OF INPUT/OUTPUT:
•	hasTeen(9, 99, 19);  should return true since 19 is in range 13 - 19
•	hasTeen(23, 15, 42);  should return true since 15 is in range 13 - 19
•	hasTeen(22, 23, 34);  should return false since numbers 22, 23, 34 are not in range 13-19

Write another method named isTeen with 1 parameter of type int.
The method should return boolean and it needs to return true if the parameter is in range 13(inclusive) - 19 (inclusive). Otherwise return false.
EXAMPLES OF INPUT/OUTPUT:
•	isTeen(9);  should return false since 9 is in not range 13 - 19
•	isTeen(13);  should return true since 13 is in range 13 - 19

NOTE: All methods need to be defined as public static like we have been doing so far in the course.
NOTE: Do not add a  main method to solution code.
…
Constructing A Comprehensive Area Calculator For Circles And Rectangles In Java
Write a method named area with one double parameter named radius.
The method needs to return a double value that represents the area of a circle.

If the parameter radius is negative then return -1.0 to represent an invalid value.

Write another overloaded method with 2 parameters x and y (both doubles), where x and y represent the sides of a rectangle.
The method needs to return an area of a rectangle.

If either or both parameters is/are a negative return -1.0 to indicate an invalid value.

For formulas and PI value please check the tips below.
Examples of input/output:
•	area(5.0); should return 78.53981633974483 or 78.53981
•	area(-1);  should return -1 since the parameter is negative
•	area(5.0, 4.0); should return 20.0 (5 * 4 = 20)
•	area(-1.0, 4.0);  should return -1 since first the parameter is negative

NOTE: All methods need to be defined as public static like we have been doing so far in the course.
NOTE: Do not add a  main method to solution code.
