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
//		defines variables that compare precedences
		int expCharPrecedence = -2;
		int peekPrecedence = -1;
//		initializes post fix expression
		String postFix = "";
//		defines arrays that use indices to compare character precedences
		String[] expressionArr = expression.split("");
		String[] precedenceArr = {"+-", "*/", "^"};
//		defines the stack to convert infix to post fix
		Stack<String> stack = new Stack<String>();
		
//		checks if character is operator or number and sends each to the post fix expression in order
		for(String character : expressionArr) {
//			pops operators from stack to post fix expression between open and closed parenthesis
			if(character.matches("()")) {
				// find out what you need to do for this
				// open parenthesis are pushed directly to stack and closed parenthesis pop operators to postFix expression
			}
//			pushes operator to stack if operator is not equal or higher precedence than the top of the stack; otherwise, pushes operator to stack
			else if(character.matches("+-*/^")) {
//				finds the precedences of current and top of the stack operator
				for(int pre=0; pre<precedenceArr.length; pre++) {
//					finds the precedence of the current operator in the infix expression
					if(character.matches(precedenceArr[pre]))
						expCharPrecedence = pre;
//					finds the precedence of the operator at the top of the stack
					if(stack.peek().matches(precedenceArr[pre]))
						peekPrecedence = pre;
				}
				
//				pops operators to post fix expression
				if(expCharPrecedence >= peekPrecedence) {
//					redefines precedence variables to be unequal
					expCharPrecedence = -2;
					peekPrecedence = -1;
//					pops entire stack to post fix expression
					while(!stack.empty())
						postFix += stack.pop();
				}
//				pushes operator to stack
				else
					stack.push(character);
			}
//			sends numbers to post fix expression
			else
				postFix += character;
		}
		
		return postFix;
	}
}
