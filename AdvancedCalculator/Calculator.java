package AdvancedCalculator;

import dataStructures.ArrayList;
import dataStructures.LinkedStack;
import dataStructures.PriorityQueue;
import dataStructures.Stack;
import dataStructures.UnsortedPriorityQueue;

public class Calculator {
	
	public static final String opening = "({["; // opening delimiters
	public static final String closing = ")}]"; // respective closing delimiters
	public static final String operations = "+-*/^√";
	public static final String undecidedYet = "";
	
	//** Public Methods **//
	// computes exp.
	public double compute(String exp) throws IllegalArgumentException, CloneNotSupportedException {
		PriorityQueue<Integer, String> operationPQ = new UnsortedPriorityQueue<>();
		ArrayList<String> expList = convertProper(exp, operationPQ);
		while (!operationPQ.isEmpty()) { // while there are operations 
			int n = expList.size(); 
			String operation = operationPQ.removeMin().getValue();
			for (int i=0;i<n;i++) { // find operation in expList
				if (expList.get(i).equals(operation)) {
					expList = computeMinor(expList, i); // and compute the adjacent values of the operation found.
					break;
				}
			}
		}	
		return Double.parseDouble(expList.get(0)); // return the result.
	}
	// Solves eqation if possible.
	public double[] findX(String equation) throws CloneNotSupportedException {
		String beforeEqualSign = equation.substring(0, equation.indexOf("=")); 
		String afterEqualSign = equation.substring(equation.indexOf("=") + 1, equation.length());
		ArrayList<String> sideA = convertEquationToProper(beforeEqualSign);
		ArrayList<String> sideB = convertEquationToProper(afterEqualSign);
//		ArrayList<String> sideAclone = sideA.clone();
//		ArrayList<String> sideBclone = sideB.clone();
//		ArrayList<Double> answerList = new ArrayList<>();

		sideA = simplify(sideA);
		sideB = simplify(sideB);
		
		ArrayList<String> expression = moveSide(sideB, sideA);	
		expression = simplify(expression);
		
		double[] results = solve(expression);
//		for(double result : results) {
//			if(isResultValid(result, sideAclone, sideBclone))
//				answerList.add(result);
//		}
//		
//		double[] answers = new double[answerList.size()];
//		for(int i=0;i<answerList.size();i++) {
//			answers[i] = answerList.get(i);
//		}
		
		return results;
	}

	//** Private Utility **//
	// Converts exp to proper expList that can be solved by the algorithm.
	private ArrayList<String> convertProper(String exp, PriorityQueue<Integer, String> operationQueue) throws IllegalArgumentException, CloneNotSupportedException {
		int n = exp.length();
		int j = 0;
		Stack<Character> buffer = new LinkedStack<>();
		ArrayList<String> expList = new ArrayList<String>();
		StringBuilder part = new StringBuilder();
		StringBuilder newExp = new StringBuilder();
		boolean inDelimiter = false;
		if (operations.indexOf(exp.charAt(0)) == 1) { // If char at 0 is '-'
			if (opening.indexOf(exp.charAt(1)) != -1) { // If char at 1 is a delimiter
				// add -1* before the delimiter
				expList.add("-1");
				expList.add("*");
				operationQueue.insert(8, "*");
			} 
			else if (operations.indexOf(exp.charAt(1)) == -1) { // If char 1 isn't a delimiter.
				part.append(exp.charAt(0)); 
			}
			j++;
		}
		for(int i=j;i<n;i++) {
			char c = exp.charAt(i);
			// checks for error
			if (operations.indexOf(c) != -1) // If an operation
				if (!inDelimiter) { // and not in a delimiter
					if (part.length() > 0) { // and there is part of the expression ready to be added to expList
						expList.add(part.toString()); 
						part.delete(0, part.length());
					}
					if (i>0 && c == '√' && operations.indexOf(exp.charAt(i-1)) == -1) { // or of case: op√
						expList.add("*");
						operationQueue.insert(8, "*");
					}
					operationQueue.insert(priority(c), Character.toString(c));
					expList.add(Character.toString(c));
				}	
				else // if in delimiter
					newExp.append(c);
			else if ((opening.indexOf(c)) != -1) { // this is a left delimiter
				inDelimiter = true;
				if (i>0 && operations.indexOf(exp.charAt(i-1)) == -1) { // character before delimiter isn't an operation
					if (part.length() > 0) {
						expList.add(part.toString());
						part.delete(0, part.length());
					}
					expList.add("*");
					operationQueue.insert(8, "*");	
				}
				buffer.push(c);
			}
			else if ((closing.indexOf(c)) != -1) { // this is a right delimiter
				if (buffer.isEmpty()) // nothing to match with
					throw new IllegalArgumentException();
				if (closing.indexOf(c) != opening.indexOf(buffer.pop()))
					throw new IllegalArgumentException(); // mismatched delimiter
				else if (buffer.isEmpty()) {
					// solve the expression inside the delimiters
					expList.add(Double.toString(compute(newExp.toString())));
					newExp.delete(0, newExp.length()); 	
				}
				inDelimiter = false;
			}
			else if (!inDelimiter)
				part.append(c);
			else 
				newExp.append(c);
		}
		expList.add(part.toString());
		return expList;
	}
	// Converts strings that represent equations to something the code can process and compute. 
	public ArrayList<String> convertEquationToProper(String equation) throws IllegalArgumentException {
		equation = equation.toUpperCase();
		int n = equation.length();
		int j = 0;
		ArrayList<String> expList = new ArrayList<String>();
		StringBuilder part = new StringBuilder();
		
		if (operations.indexOf(equation.charAt(0)) == 1) { // If char at 0 is '-'
			if (opening.indexOf(equation.charAt(1)) != -1) { // If char at 1 is a delimiter
				// add -1* before the delimiter
				expList.add("-1");
				expList.add("*");
			} 
			else if (operations.indexOf(equation.charAt(1)) == -1) { // If char 1 isn't a delimiter.
				part.append(equation.charAt(0)); 
			}
			j++;
		}
		
		for(int i=j;i<n;i++) {
			Character c = equation.charAt(i);
			if(c == 'X') {
				if(i==0) { // first character is X
					expList.add("1");
					expList.add("*");
				}
				else if(i>0 && equation.charAt(i-1)!='*') { // case: nX
					if(part.length() == 0) // case: X
						expList.add("1");
					addPart(part, expList);
					expList.add("*");
				}
				expList.add(c.toString());
			}
			// not a number nor a variable
			else if(operations.indexOf(c) != -1 || opening.indexOf(c) != -1 || closing.indexOf(c) != -1) {
				if (validate(equation, i))
					throw new IllegalArgumentException();
				addPart(part, expList);
				if (i>0 && c == '√' && operations.indexOf(equation.charAt(i-1)) == -1) {
					expList.add("*");
				}
				expList.add(c.toString());
			}
			else 
				part.append(c);
		}	
		// add leftovers if any tp expList.
		if(part.length() > 0)
			expList.add(part.toString());
		
		return expList;
		
	}
	// Checks if result causes an error.
	private boolean isResultValid(double result, ArrayList<String> sideA, ArrayList<String> sideB) throws IllegalArgumentException, CloneNotSupportedException {
		sideA = replaceXwith(sideA, result);
		sideB = replaceXwith(sideB, result);
		double result1 = this.compute(stringify(sideA));
		double result2 = this.compute(stringify(sideB));
		
		if(Double.isInfinite(result1) || Double.isInfinite(result2)) 
			return false;
		
		return true;
	}
	// Converts ArrayList<String> to String.
	private String stringify(ArrayList<String> exp) {
		StringBuilder sb = new StringBuilder();
		
		for(String s : exp) {
			if(sb.length()>0 && sb.charAt(sb.length()-1) == '+' && s.contains("-")) {
				sb.setCharAt(sb.length()-1, '-');
				if(s.length() > 1)
					sb.append(s.substring(1));
			} else 
				sb.append(s);
		}
		
		return sb.toString();
	}
	// Replaces all X with result.
	private ArrayList<String> replaceXwith(ArrayList<String> exp, double result) {
		for(int i=0;i<exp.size();i++) {
			String s = exp.get(i);
			
			if(s.equals("X")) {
				exp.set(i, Double.toString(result));
			}
		}
		
		return exp;
	}
	// Adds part to expList as a string if part contains anything and then resets part back to empty.
	private void addPart(StringBuilder part, ArrayList<String> expList) {
		if (part.length() > 0) {
			expList.add(part.toString());
			part.delete(0, part.length());
		}	
	}
	// Checks if s is a number
	private boolean isNumber(String s) {
		String numbers = "0123456789";
		for(char c : s.toCharArray()) {
			if(numbers.indexOf(c) == -1) {
				if(s.length() > 1 && (c == '-' || c=='.'))
					continue;
				else
					return false;
			}
		}
		return true;
	}
	private ArrayList<String> computeEquation(ArrayList<String> expList) throws CloneNotSupportedException {
		ArrayList<String> newExp = new ArrayList<>();
		ArrayList<String> expPart = new ArrayList<>();
		ArrayList<String> inDelimiterExp = new ArrayList<>();
		boolean inDelimiter = false;
		int n = expList.size();
		
		for(int i=0;i<n;i++) {
			String s = expList.get(i);
			
			if(s.equals("+") || s.equals("-") || s.equals("/")) { // if its a seperating operation
				if(!inDelimiter) {
					if(!expPart.isEmpty()) {
						newExp.add(minorSimplify(expPart)); // add a simplified version of expPart
						expPart.removeAll();
					}
					newExp.add(s); // Add the operation
				}
				else {
					inDelimiterExp = minorSimplify(inDelimiterExp);
					inDelimiterExp.add(s);
				}	
			} 
			else if(opening.contains(s)) {
				inDelimiter = true;
			} 
			else if(closing.contains(s)) {
				inDelimiter = false;
				if(i+2 <= n && expList.get(i+1).equals("^")) { // if delimiter of type (exp)^n
					inDelimiterExp = computeDelimiterWithSS(inDelimiterExp, Double.parseDouble(expList.get(i+1)));
				}
				if((i>0 && expList.get(i-1).equals("*")) || expPart.size() > 0) { // if its of case exp*(exp)
					newExp.add(multiplyWithDelimiters(expPart, inDelimiterExp));
					expPart.removeAll();
				}
				// if its of case (exp)*(exp)
				else if(i+3 <= n && !expList.get(i+1).equals("/") && opening.contains(expList.get(i+2))) 
					expPart = inDelimiterExp.clone();
				else
					newExp.add(inDelimiterExp);
				inDelimiterExp.removeAll();
			} else if (inDelimiter) {
				inDelimiterExp.add(s);
			} else 
				expPart.add(s);
		}
		// Add leftovers if any to newExp. 
		if(!expPart.isEmpty())
			newExp.add(expPart);
		
		newExp = addParameters(newExp);
		
		if(!newExp.isEmpty() && newExp.get(newExp.size()-1).equals("0.0")) // Delete useless parts from newExp if any.
			newExp.remove(newExp.size()-1);
		
		if(!newExp.isEmpty() && newExp.get(newExp.size()-1).equals("+")) // Delete useless parts from newExp if any.
			newExp.remove(newExp.size()-1);
		
		return newExp;
	}
	// multiplies delimiter by itself for superScriptValue times.
	private ArrayList<String> computeDelimiterWithSS(ArrayList<String> exp, double superScriptValue) {
		for(int i=1;i<superScriptValue;i++) {
			exp = multiplyWithDelimiters(exp, exp);
		}
		return exp;
	}
	// Adds all the parts in newExp
	private ArrayList<String> addParameters(ArrayList<String> newExp) {
		int div = 0;
		int n = newExp.size();
		double current = 0;
		double currentValue = 0;
		ArrayList<String> newestExp = new ArrayList<>();
		ArrayList<String> subExp = new ArrayList<>();
		// Finds the biggest Super Script 
		for(int i=0;i<n;i++) {
			double ssOfs = 0;
			if(isParameter(newExp, i))
				ssOfs = superScriptOf(newExp, i);
			if(ssOfs > current)
				current = ssOfs;
		}
		// While the superscript belongs to a parameter add all all parameters with the smae superscript.
		while(current > 0) {
			boolean added = false;
			for(int i=div;i<n;i++) {	
				String s = newExp.get(i);
				if(s.equals("/")) { // if iteration finds "/" 
					div = i+1; // continue search after this index next time
					newestExp.add(addParameters(subExp)); // and addParameters on everything before this index.
					if(newestExp.get(newestExp.size()-1).equals("0.0")) { // Delete useless parts from newExp if any.
						newestExp.remove(newestExp.size()-1);
						newestExp.remove(newestExp.size()-1);
					}
					added = true;
				}
				
				subExp.add(s);
				// Matching parameter and superscript.
				if(i>1 && isParameter(newExp, i) && superScriptOf(newExp, i) == current) {
					if(i>2 && newExp.get(i-3).equals("-"))
						currentValue -= Double.parseDouble(newExp.get(i-2));
					else
						currentValue += Double.parseDouble(newExp.get(i-2));
				}
			}
			
			subExp.removeAll();
			
			if(currentValue != 0 && !added) {
				newestExp.add(Double.toString(currentValue));
				addParameter(newestExp, current);
				newestExp.add("+");
			}
			
			currentValue = 0;
			current--;
		}
		
		for(int i=div;i<n;i++) { // Repeat the scheme above but for numbers only.
			String s = newExp.get(i);
			
			subExp.add(s);
			
			if(n == 1) 
				currentValue += Double.parseDouble(newExp.get(0));
			else if((i+2 <= n && !newExp.get(i+1).equals("*") || i==n-1) && isNumber(s))
				if(i==0)
					currentValue += Double.parseDouble(s);
				else if(i>0 && !newExp.get(i-1).equals("^") && !newExp.get(i-1).equals("/")) {
					if(newExp.get(i-1).equals("-"))
						currentValue -= Double.parseDouble(s);
					else
						currentValue += Double.parseDouble(s);
				}
		}
		
		subExp.removeAll();
		
//		for(int i=div;i<newExp.size();i++) {
//			String s = newExp.get(i);
//			subExp.add(s);
//					
//		}
//		
//		if(div>0 && (Double.parseDouble(newExp.get(div))!=1 && subExp.size()>1 || Double.parseDouble(newExp.get(div))!=1)) {
//			newestExp.add("/");
//			newestExp.add(addParameters(subExp));
//		}
		
		// add operation if last part isn't one.
		if(!newestExp.isEmpty() && !operations.contains(newestExp.get(newestExp.size()-1))) 
			newestExp.add("+");
		newestExp.add(Double.toString(currentValue)); 
		
		return newestExp;
	}
	// Adds parameter with superscript to an expression
	private void addParameter(ArrayList<String> expression, double superscript) {
		expression.add("*");
		expression.add("X");
		if(superscript > 1) {
			expression.add("^");
			expression.add(Double.toString(superscript));
		}
		
	}
	// Multiplies expressions exp*(exp)
	private ArrayList<String> multiplyWithDelimiters(ArrayList<String> expPart, ArrayList<String> inDelimiterExp) {
		for(int i=0;i<expPart.size();i++) { // for every part in expPart multiply it with inDelimiterExp
			String s = expPart.get(i);
			if(operations.contains(s)) {
				continue;
			}
			if(isParameter(expPart, i))
				inDelimiterExp = multiplyWithParameters(s, superScriptOf(expPart, i), inDelimiterExp);
			else 
				inDelimiterExp = multiplyWithParameters(s, 0, inDelimiterExp);
		}
		
		return inDelimiterExp;
	}
	// Multiplies expression with s and includes parameters
	private ArrayList<String> multiplyWithParameters(String s, double superScriptOfs, ArrayList<String> exp) {
		ArrayList<String> newExp = new ArrayList<>();
		
		for(int i=0;i<exp.size();i++) {
			String st = exp.get(i);
			
			if (i>2 && st.equals("^")) // don't multiply superscripts
				i++;
			else if (operations.contains(st)) // can't multiply operations.
				continue;
			else if (isParameter(exp, i) && s.equals("X")) { // case: parameter*parameter
				double superScriptOfst = superScriptOf(exp, i);
				if (superScriptOfst < 2) {
					newExp.add("^");
					newExp.add(Double.toString(superScriptOfst + superScriptOfs));	
				}
			}
			else if (isParameter(exp, i) && !s.equals("X")) { // case: parameter*number
				double superScriptOfst = superScriptOf(exp, i);
				addParameter(newExp, superScriptOfst);
			}
			else if (i==0) {
				double result = Double.parseDouble(st) * Double.parseDouble(s);
				newExp.add(Double.toString(result));
			}
			else {
				double result = Double.parseDouble(st) * Double.parseDouble(s);
				newExp.add("+");
				newExp.add(Double.toString(result));
			}
		}
		
		return newExp;
	}
	// Simplifies an expPart by multiplying all content in it together.
	private ArrayList<String> minorSimplify(ArrayList<String> expPart) {
		double numericResult = 1;
		double superScriptResult = 0;
		ArrayList<String> newExp = new ArrayList<>();
		
		for(int i=0;i<expPart.size();i++) {
			String st = expPart.get(i);
			if (st.equals("^")) // can't multiply superscripts.
				i++;
			else if (operations.contains(st)) // can't multiply operations.
				continue;
			else if (isParameter(expPart, i) && st.equals("X")) { // case: parameter*parameter
				superScriptResult += superScriptOf(expPart, i);	
			}
			else // case: number*number
				numericResult *= Double.parseDouble(st);
		}
		
		newExp.add(Double.toString(numericResult));	
		if (superScriptResult > 0) 
			addParameter(newExp, superScriptResult);
		
		return newExp;
	}
	// Determines the priority of the operation. 
	private int priority(char charAt) throws IllegalArgumentException {
		if(operations.indexOf(charAt) != -1)
			if (charAt == '+' || charAt == '-')
				return 9;
			else if (charAt == '*' || charAt == '/')
				return 8;
			else if (charAt == '^' || charAt == '√')
				return 7;
		throw new IllegalArgumentException();
	}
	// Checks whether the operation in index i is legal.
	private boolean validate(String exp, int i) {
		if(exp.length() > i+1)
			return operations.indexOf(exp.charAt(i)) != -1 && operations.indexOf(exp.charAt(i+1)) != -1;
		return false;
	}  
	// computes adjacent values with operator at index i of expList.
	private ArrayList<String> computeMinor(ArrayList<String> expList, int i) {
		String operation = expList.get(i);
		double answer = 0;
		double right = expList.size()>i ? Double.parseDouble(expList.get(i+1)) : 0;
		if (operation.equals("√")) {
			expList.set(i, Double.toString(Math.sqrt(right)));
			expList.remove(i+1);
			return expList;
		}
		double left = Double.parseDouble(expList.get(i-1));	 	
		if (operation.equals("+"))
			answer = left + right;
		else if (operation.equals("-"))
			answer = left - right;
		else if (operation.equals("*"))
			answer = left * right;
		else if (operation.equals("/"))
			answer = left / right;
		else if (operation.equals("^"))
			answer = CalculatorUtil.power(left, (int)(right));
		expList.set(i-1, Double.toString(answer));
		// removing index i+1 first because of the space filling after remove.
		expList.remove(i+1);
		expList.remove(i);
		return expList;
	}
	// Checks if sideA is solvable if it is returns solutions.
	private double[] solve(ArrayList<String> sideA) throws ArithmeticException {
		double[] solutions = null;
		int size = sideA.size();
		try {
			if(size < 3) return solutions;
			double a = Double.parseDouble(sideA.get(0));
			if (size == 3) { // a*x=0
				solutions = new double[1];
				solutions[0] = 0;
			}
			if (size < 5) return solutions;
			double b = Double.parseDouble(sideA.get(4));
			if (size == 5) { 
				solutions = new double[1];
				if (sideA.get(3).equals("+") && isParameter(sideA, 2)) // a*x+b=0
					solutions[0] = -b / a;
				else if (sideA.get(3).equals("-") && isParameter(sideA, 2)) // a*x-b=0
					solutions[0] = b / a;
			}
			if (size < 7) return solutions;
			double c = Double.parseDouble(sideA.get(6));
			if (size == 7) {
				solutions = new double[2];
				if (isParameter(sideA, 2) && sideA.get(3) == "^" && Double.parseDouble(sideA.get(4)) == 2) {  // a*x^2-c=0
						solutions[0] = Math.sqrt(Math.abs(c) / Math.abs(a));
						solutions[1] = -Math.sqrt(Math.abs(c) / Math.abs(a));
				}
			}
			if (size < 11) return solutions;
			double n = Double.parseDouble(sideA.get(10));
			if (size == 11) {
				if (!isParameter(sideA, 10) && isParameter(sideA, 2) && sideA.get(3) == "^" &&
						Double.parseDouble(sideA.get(4)) == 2 && isParameter(sideA, 8))
					solutions = solveQuadraticEquation(sideA); // a*x^2+b*x+c=0	
				else if (sideA.get(3).equals("^"))
					if (b == n+2) { //a*x^b-c*x^(b-2), (n=b+2)
						if(sideA.get(5) == "+") throw new ArithmeticException();//a*x^b+c*x^(b-2)
						else if (sideA.get(5) == "-") {
							solutions = new double[3];
							solutions[0] = Math.sqrt(Math.abs(c) / Math.abs(a));
							solutions[1] = -Math.sqrt(Math.abs(c) / Math.abs(a));
							solutions[2] = 0;
						}
					}
					else if (b == n+1) { 
						solutions = new double[2];
						if (sideA.get(5) == "+") { // ax^b+cx^(b-1), (n=b+1)
							solutions[0] = -c / a;
							solutions[1] = 0;
						}
						else if (sideA.get(5) == "-") { // ax^b-cx^(b-1)
							solutions[0] = c / a;
							solutions[1] = 0;
						}
					}
			}
		} catch(Exception e) {
			
		}
		return solutions;
	}
	// solves quadratic equation.
	private double[] solveQuadraticEquation(ArrayList<String> sideA){
		double a = Double.parseDouble(sideA.get(0));
		double b = Double.parseDouble(sideA.get(6));
		if (sideA.get(5) == "-") b *= -1;
		
		double c = Double.parseDouble(sideA.get(10));
		if (sideA.get(9) == "-") c *= -1;
		
		double delta = Math.pow(b, 2)-4*a*c;
		double[] solutions = new double[2];
		
		if (delta < 0) return solutions;		
		else if (delta == 0) solutions[0] = -b / (2*a);
		else {
			solutions[0] = (-b + Math.sqrt(delta)) / (2*a);
			solutions[1] = (-b - Math.sqrt(delta)) / (2*a); 
		}
		
		return solutions;
	}
	// Checks if String at index i is a parameter 
	private boolean isParameter(ArrayList<String> side, int i) {
		String s = side.get(i);
		if (hasValue(s)) {
			try {
				Double.parseDouble(side.get(i));
			} catch (Exception e) {
				return true;
			}
		}
		return false;
	}

	private boolean sideIs0(ArrayList<String> side) {
		// problem with side == null
		return (side.size() == 1 && Double.parseDouble(side.get(0)) == 0); // || side == null;
	}
	// Simplifies the expression.
	private ArrayList<String> simplify(ArrayList<String> side) throws CloneNotSupportedException { 
		for (int i=0; i<side.size();i++) {
			if (side.get(i).equals("/")) 
				side = diminish(side, i);
		}
		side = computeEquation(side);
		
		return side;
	}
	// Moves one side of the equation to the other.
	private ArrayList<String> moveSide(ArrayList<String> sideFrom, ArrayList<String> sideTo) {
		if(!sideIs0(sideFrom)) {
			sideTo.add("+");
			sideTo.add("-1");
			sideTo.add("(");
			for(String s : sideFrom) {
				sideTo.add(s);
			}
			sideTo.add(")");
		}
		
		return sideTo;
	}

	// Divides every value in the expression by its biggest common dividor
	private ArrayList<String> extractBCD(ArrayList<String> side, ArrayList<String> BCD) {
		if (BCD.get(0) == "1" && BCD.size() == 1) return null;
		// Iterate over every value in divide 
		for (int i=0;i<BCD.size();i++) {
			String st = BCD.get(i);
			if (hasValue(st)) { // If st is either a parameter or a number
				if (i > 0 && BCD.get(i-1).equals("^")) continue;
				for (int j=0;j<side.size();j++) {
					String s = side.get(j);
					// If s is either a parameter or a number
					if (hasValue(s)) {
						// If both s and st are parameters
						if (isParameter(side, j) && isParameter(BCD, i)) { 
							double dividerSS = superScriptOf(BCD, i);
							double dividedSS = superScriptOf(side, j);
							double result = dividedSS - dividerSS; 
							if (result == 0) { // If both parameters are from the same power
								if (dividedSS == 1) { // Remove *X from side.
									side.remove(j);
									side.remove(j-1);
								}
								else { // Remove *X^n from side.
									side.remove(j+2);
									side.remove(j+1);
									side.remove(j);
									side.remove(j-1);
								}
							}
							else if (result > 0) { // Decrease the power of the divided.
								if (result == 1) { // Remove *X^n from side.
									side.remove(j+2);
									side.remove(j+1);
								}
								else side.set(j+2, Double.toString(result));
							}
						}
						// If both st and s are numbers
						else if (!isParameter(side, j) && !isParameter(BCD, i)) {
							if (j>1 && side.get(j-1).equals("^")) continue;
							double divided = Double.parseDouble(s);
							double divider = Double.parseDouble(st);
							double newnum = divided / divider;
							side.set(j, Double.toString(newnum)); // Set s as newnum.
						}
					}
				}
			}
		}
		// Put the expression in parentheses and add before them the BCD.
		side.add(0, "(");
		side.add(0, "*");
		side.add(")");
		for (int i=0;i<BCD.size();i++) side.add(i, BCD.get(i));		
		return side;
	}
	// checks if s has value. 
	private boolean hasValue(String s) {
		return Calculator.opening.indexOf(s) == -1 && Calculator.closing.indexOf(s) == -1 &&
				Calculator.operations.indexOf(s) == -1;
	}

	// Returns the superscript of the parameter at i (used because its stored as ["X","^","n"]).
	private double superScriptOf(ArrayList<String> exp, int i) {
		if (exp.size() > i+2 && exp.get(i+1).equals("^")) return Double.parseDouble(exp.get(i+2));
		else return 1;
	}

	// Returns the biggest common divider of the given expression. 
	private ArrayList<String> biggestCommonDivider(ArrayList<String> exp) {
		ArrayList<String> BCD = new ArrayList<>();
		double smallestX = Integer.MAX_VALUE;
		double smallestN = Integer.MAX_VALUE;
		
		for (int i=0; i<exp.size();i++) {
			String s = exp.get(i);
			
			if (isParameter(exp, i)) { // If its a parameter
				double parameter = superScriptOf(exp, i);
				// Change smallestX value to parameter's value if parameter is smaller.
				smallestX = parameter < smallestX ? parameter : smallestX; 
			}
			else if (hasValue(s)) { // If its a number
				if (i>0 && exp.get(i-1).equals("^")) continue;
				else if (i+2 >= exp.size() || !exp.get(i+2).equals("X"))
					smallestX = 0;
				double num = Double.parseDouble(s);
				// Change smallestN value to num's value if num is smaller.
				smallestN = num < smallestN ? num : smallestN;
			}
		}
		
		boolean pflag = false; // parameter flag.
		for (int i=0, j=0;i<exp.size();i++) {
			String s = exp.get(i);		
			
			// If its a parameter and valid
			if (j < exp.size() && smallestX > 0 && isParameter(exp, j)) { 
				double parameter = superScriptOf(exp, j);
				double result = parameter - smallestX;
				if (result < 0) smallestX = 0;
				pflag = true;
			}
			else if (hasValue(s) && smallestN > 1 && !isParameter(exp, i)) { // If its a number and valid
				if (i>1 && exp.get(i-1).equals("^")) {
					continue;
				}
				
				double num = Double.parseDouble(s);
				// If smallestN isn't 1,0,-1 and isn't dividable
				if (smallestN != 0 && smallestN != 1 && smallestN != -1 && num % smallestN != 0) {
				// Increase or decrease smallestN depends on the sign(+ or -) of smallestN
					if (smallestN > 0) 
						smallestN--;
					else 
						smallestN++;
						
					i = 0;
				}
			}
			
			if (s.equals("+") || s.equals("-") || s.equals("/")) { // If its a new part of the expression
				if (!pflag) smallestX = 0; // Check if the previous part had a parameter
				pflag = false;
			}
			j++;
		}
		
		if (smallestN != 1 && smallestN != 0 && smallestN != -1) // If smallestN isn't 1,0,-1
			BCD.add(Double.toString(smallestN));
		
		if (smallestX > 0) { 
			if (BCD.isEmpty()) BCD.add("1"); 
			addParameter(BCD, smallestX);
		}
		
		if (BCD.isEmpty()) return null; // no BCD found.
		else return BCD;
	}
	// Dimminishes the expression if possible.
	private ArrayList<String> diminish(ArrayList<String> side, int i) throws CloneNotSupportedException {
		ArrayList<String> left = new ArrayList<>();
		left.add(side.get(i-1));
		ArrayList<String> right = new ArrayList<>();
		right.add(side.get(i+1));
		Stack<String> buffer = new LinkedStack<>();
		ArrayList<String> expression = null;
		int endOfDiv = side.size() + 1;
		ArrayList<String> subExp = new ArrayList<>();
		
		// Iterate over the left of the "/" and define the expression. IT GOES BACKWARDS!!!
		for (int j=i-1;j>=0;j--) {
			String s = side.get(j);
			
			if (!buffer.isEmpty()) {
				if (opening.indexOf(s) != -1) buffer.pop(); // if s is an opening delimiter
				left.add(s);
			}
			
			if (closing.indexOf(s) != -1) buffer.push(s); // if closing delimiter
		}
		left.reverse();
		
		// Iterate over the right of the "/" and define the expression.
		for (int j=i+1;j<side.size();j++) {
			String s = side.get(j);
			
			if (!buffer.isEmpty()) {
				if (closing.indexOf(s) != -1) { // if closing delimiter
					buffer.pop();
					endOfDiv = j+1; // end of division index
				}
				right.add(s);
			}
			
			if (opening.indexOf(s) != -1) buffer.push(s); // if s is an opening delimiter
		}
		subExp.add(left);
		subExp.add("/");
		subExp.add(right);
		
		ArrayList<String> BCD;
		if ((BCD = biggestCommonDivider(side)) != null) {
			ArrayList<String> rightLike = right.clone();
			rightLike.remove(0);
			rightLike.remove(rightLike.size()-1);
			
			if (BCD.equals(rightLike)) { // if BCD/rightLike=1
				for (int j=i+right.size();j>=i;j--) // delete everything after '/' and delimiters.
					side.remove(j);
				side.remove(0);
				side.remove(side.size()-1);
			}
			
			expression = extractBCD(subExp, BCD); 
			
			for (int k=BCD.size();k>=0;k--) { // delete BCD from extracted expression and delimiters.
				expression.remove(k);
			}
			expression.remove(0);
			expression.remove(expression.size()-1);
		}
		
//		else {
//			ArrayList<String> leftBCD = biggestCommonDivider(left);
//			ArrayList<String> rightBCD = biggestCommonDivider(right);
//			leftBCD.add("/");
//			for (int k=0;k<rightBCD.size();k++) {
//				leftBCD.add(rightBCD.get(k));
//			}
//			if ((BCD = biggestCommonDivider(leftBCD)) != null) { // If there is a common divider for leftBCD
//				expression = extractBCD(subExp, BCD); // extract it and put in and put extracted expression in expression
//			}
//		}
		
		for (int k=endOfDiv;k<side.size();k++) { // Add leftovers of the expression.
			expression.add(side.get(k));
		}
		
		if (expression != null) return expression;
		return side;
	}
}
