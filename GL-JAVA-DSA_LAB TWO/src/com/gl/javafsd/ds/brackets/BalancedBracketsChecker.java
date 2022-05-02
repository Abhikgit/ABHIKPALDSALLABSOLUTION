package com.gl.javafsd.ds.brackets;
import java.util.Set;
import java.util.Stack;

public class BalancedBracketsChecker {
private String brackets;	
	
	public BalancedBracketsChecker(String brackets) {
		this.brackets = brackets;			
	}
	
	public boolean check() {
		
			
		if (brackets.length() % 2 != 0) {
			return false;
		}
		
		Stack<Character> stack = new Stack<Character>();
		
		Set<Character> openBracketsSet 
			= BracketsDefine.getOpenBrackets();
		Set<Character> closeBracketsSet 
			= BracketsDefine.getCloseBrackets();
		
		
		for (int index = 0; index < brackets.length(); index ++) {
			
			char aChar = brackets.charAt(index);
			
			if (openBracketsSet.contains(aChar)) {

				stack.push(aChar);
				
			}else if (closeBracketsSet.contains(aChar)) {
								
				char closedChar = aChar;

				Character openCharFromStack = stack.pop();
				
				
				Bracket bracketObj 
					= BracketsDefine.getBracket(closedChar);
				
				if (openCharFromStack.equals(
					bracketObj.getOpenBracket())) {
					
				
					continue;
				}
			}else {
				
				System.out.println("Invalid character encountered "
						+ "during traversal.." + aChar);
				return false;
			}			
		}
		
		return stack.isEmpty();
	}	
}

