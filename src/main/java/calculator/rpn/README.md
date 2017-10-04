# RPN Calculator Kata

A RPN calculator program computes expressions written in RPN (Reverse Polish Notation).
A RPN expression (or a postfix expression) is one of the following:

- a number X, in which case the value of the expression is that of X;
- a sequence of the form E1 E2 O, where E1 and E2 are postfix expressions and O is an  arithmetic operation; in this case, the value of the expression is that of  E1 O E2 

The following are RPN expressions:

- 20 5 / => (20/5) = 4
- 4 2 + 3 - => (4+2)-3 = 3
- 3 5 8 \* 7 + \* => 3\*((5\*8)+7) = 141 
- 7 2 - 3 4 = 5 3 4
- 5 3 + => 5+3 => 8
- 6 2 / => 6/2 => 3
- 5 2 - 7 + => 10
- 7 5 2 - + => 10
- 3 5 8 * 7 + * => 3*((5*8)+7) => 141
- 3 4 2 1 + * + 2 / => (3 + (4 * (2+1)))/2 => 7.5
- 1 2 + 4 * 5 + 3 − => ((1+2) * 4) + 5 - 3 => 14
- 5 4 1 2 + * + => 5 + (4 * (1+2))

Suggested scenarios

- Given a RPN Calculator when a digit is sent it should display the same digit
- Given a RPN Calculator when some digits are sent it should display the number formed by those digits
- Given a RPN Calculator when an operation (* + / -) is sent after two numbers it should display the result of that operation