# Kata : Calculator 
_Simply create a calculator as you used at school_

## Handle unique simple operations
- Create a simple String calculator with a method `int calc(String)`. The method can take two numbers separated by "+", and return their sum.
- Allow the method to handle any amount of number and "+" operations
- Allow the method to handle the "subtract" operation.
- Allow the method to handle the "multiply" operation.
- Allow the method to compose the different kind of operation. Keep in mind the priority of the different operations.

## Handle a new operation 
- Allow the method to handle the "^" operation, witch returns "first power second".

## The "x" operation
- Allow the method to handle the "x" operation, witch does the "multiply" operation.

## Random everywhere
- Allow the method to support dice rolling
  - 1d4 returns a integer number between 1 and 4
  - 1d6 returns a integer number between 1 and 6
  - one may roll more than one dice.

## Support parenthesis
- Allow the method to handle "(" and ")" to change operation priorities.

## Support Roman numerals
- Allow the method to handle roman numerals.
  - Ex : "1+I" should return 2, and "2*V" should return 10.
- Allow the method to handle little roman numerals (i.e "i", "v", etc.).