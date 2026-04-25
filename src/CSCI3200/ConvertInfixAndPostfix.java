package CSCI3200;

import java.util.Stack;

public class ConvertInfixAndPostfix {
    //	expression created to convert from infix to post fix and vice-versa
    private String expression;

    //	infix or post fix expression defined
    public ConvertInfixAndPostfix(String infixOrPostfix) {
        expression = infixOrPostfix;
    }
    
    //	converts infix to post fix
    public String convertToPostfix() {
    	// variables to compare future operator precedences
        int expCharPrecedence = -2;
        int peekPrecedence = -1;
        // post fix expression
        String postFix = "";
        // splits operators and defines operator precedence through index
        String[] expressionArr = expression.split(" ");
        String[] precedenceArr = {"+-", "*/", "^"};
        // defines operator and parenthesis stack
        Stack<String> stack = new Stack<String>();
        
        // Cycles through each character in the string array; adds numbers, operators, and parentheses correctly
        for(String character : expressionArr) {
        	// If a character is a parenthesis, an open parenthesis is added to the stack or operators are added
        	// to post fix expression if they are on top of an open parenthesis
            if("()".contains(character)) {
                // open parenthesis are pushed directly to stack and closed parenthesis pop operators to postFix expression
            	if("(".contains(character)) {
            		stack.push(character);
            	}
            	else {
            		// the stack is popped into post fix until it reaches the bottom or an open parenthesis and removes it
        			while(!stack.empty() && !stack.peek().equals("(")) {
        				postFix += stack.pop();
        			}
        			stack.pop();
            	}
            }
            // If there is an operator, it is place into the stack if nothing is in there and if the operator is greater than the
            // operator in the top of the stack, it is added
            else if("+-*/^".contains(character)) {
            	// If the stack is empty, add push operator to it
            	if(stack.empty()) {
            		stack.push(character);
            	} else {
            		// If stack does not have an open parenthesis, compare the operator to the top operator
            		if(!stack.peek().equals("(")) {
            			// finds both operator's precedences via array index
    	                for(int pre=0; pre<precedenceArr.length; pre++) {
    	                    if(precedenceArr[pre].contains(character)) {
    	                        expCharPrecedence = pre;
    	                    }
    	                    if(precedenceArr[pre].contains(stack.peek())) {
    	                        peekPrecedence = pre;
    	                    }
    	                }
    	                // If operator precedence is less than or equal to the operator at the top of the stack,
    	                // then pop everything until it reaches the bottom or open parenthesis, then push operator
    	                if(expCharPrecedence <= peekPrecedence) {
    	                    expCharPrecedence = -2;
    	                    peekPrecedence = -1;
							// Pop everything from the stack to the post fix expression until it reaches a parenthesis or bottom of stack
    	                    while(!stack.empty() && !stack.peek().equals("(")) {
    	                    	
    	                        postFix += stack.pop();
    	                    }
    	                    stack.push(character);
    	                }
    	                else {
    	                    stack.push(character);
    	                }
            		}
            		else {
                		stack.push(character);
                	}
            	}
            }
            else {
                postFix += character;
            }
        }
        // Adds remaining operators to post fix expression
        while(!stack.empty()) {
            postFix += stack.pop();
        }

        return postFix;
    }

    public String convertToInfix() {    //method converts postfix to infix

        Stack<String> stack = new Stack<String>();  //creates a stack to store strings

        String[] expressionArr = expression.split(" "); //split string by spaces

        for (String token : expressionArr) {    //moves through each token in the expression

            if (token.matches("[0-9]+")) {  //if a token is an integer of any size, push it to the top of the stack
                stack.push(token);
            }

            else {

                String operand1 = stack.pop();  //gets the second integer
                String operand2 = stack.pop();  //gets the first integer

                String newExpression = "(" + operand2 + " " + token + " " + operand1 + ")";     //makes an expression using the two integers and the operator

                stack.push(newExpression);
            }
        }

        return stack.pop();     //returns remaining integer
    }
}
