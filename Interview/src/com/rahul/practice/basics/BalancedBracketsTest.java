package com.rahul.practice.basics;

import java.util.Stack;

class BalancedBrackets {
	public boolean isBalanced(String str) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			}

			if (stack.isEmpty()) {
				return false;
			}

			char check;
			switch (ch) {
			case ')':
				check = stack.pop();
				if (check == '[' || check == '{') {
					return false;
				}
				break;
			case ']':
				check = stack.pop();
				if (check == '(' || check == '{') {
					return false;
				}
				break;
			case '}':
				check = stack.pop();
				if (check == '[' || check == '(') {
					return false;
				}
				break;
			default:
				break;
			}

		}
		return stack.isEmpty();

	}
}

public class BalancedBracketsTest {
	public static void main(String... strings) {
		String str = "[()]{}{[()()]()}";
		BalancedBrackets obj = new BalancedBrackets();
		System.out.println(obj.isBalanced(str));

	}

}
