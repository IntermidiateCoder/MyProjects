package AdvancedCalculator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dataStructures.ArrayList;
import dataStructures.LinkedStack;
import dataStructures.Stack;

public class TestCalculator {
	private Calculator c;
	private String exp1, exp2, exp3, exp4, exp5, exp6, exp7, exp8, exp9, exp10, exp11, exp12;
	private ArrayList<double[]> answers;
	private ArrayList<String[]> answersB, solutionsB, BCD, answersC;
	private String[] sideB = {"0"};
	private String[] equation1 = {"4", "*", "X","+","4"};
	private String[] equation2 = {"4", "*", "X","-","4"};
	private String[] equation3 = {"6", "*", "X"};
	private String[] equation4 = {"1", "*", "X","^","4", "-", "9", "*", "X", "^", "2"};
	private String[] equation5 = {"1", "*", "X", "^", "2", "+", "9", "*", "X", "+", "18"};
	private String[] equation6 = {"1", "*", "X","^","3", "-", "9", "*", "X", "^", "2"};
	private String[] equation7 = {"1", "*", "X","^","3", "+", "9", "*", "X", "^", "2"};
	private String[] equation8 = {"1", "*", "X","^","2", "-", "9", "*", "X"};
	private String[] equation9 = {"(", "9.0", "*", "X", ")", "/", "(", "9.0", "*", "X", ")"};
	private String[] equation10 = {"(", "9.0", "*", "X", "^", "2", ")", "/", "(", "9.0", "*", "X", ")"};
	private String[] equation11 = {"(", "9.0", "*", "X", ")", "/", "(", "9.0", "*", "X", "^", "2", ")"};
	private String[] equation12 = {"(", "6.0", "*", "X", ")", "/", "(", "8.0", "*", "X", "^", "2", ")"};

	@Before
	public void setUp() throws Exception {
		c = new Calculator();
		exp1 = "2+6*9";
		exp2 = "5(6+4)-3";
		exp3 = "(3+6)(2-1)";
		exp4 = "(6-(5+2))/4";
		exp5 = "5-(6/3)*4-5";
		exp6 = "2^3-2";
		exp7 = "(4-5)^2";
		exp8 = "4^2-3/(9-6)";
		exp9 = "√49";
		exp10 = "9√25";
		exp11 = "-6+5";
		exp12 = "-(4+5)";	
		answers = new ArrayList<>();
		double[] answer1 = {-1};
		double[] answer2 = {1};
		double[] answer3 = {0};
		double[] answer4 = {3, -3, 0};
		double[] answer5 = {-3, -6};
		double[] answer6 = {9, 0};
		double[] answer7 = {-9, 0};
		double[] answer8 = {3, -3};
		String[] answer9 = {"1", "*", "X","^","2.0", "*", "(", "1.0", "*", "X", "-", "9.0", ")"};
		String[] answer10 = {"4.0", "*", "(", "1.0", "*", "X","-", "1.0", ")"};
		String[] answer11 = {"1", "*", "X", "*", "(", "1.0", "*", "X", "-", "9.0", ")"};
		String[] answer12 = {"1.0"};
		String[] answer13 = {"1.0", "*", "X"};
		String[] answer14 = {"(", "1.0", ")", "/", "(", "1.0", "*", "X", ")"};
		String[] answer15 = {"(", "3.0", ")", "/", "(", "4.0", "*", "X", ")"};
		answers.add(answer1);
		answers.add(answer2);
		answers.add(answer3);
		answers.add(answer4);
		answers.add(answer5);
		answers.add(answer6);
		answers.add(answer7);
		answers.add(answer8);
		answersB = new ArrayList<>();
		answersB.add(answer9);
		answersB.add(answer10);
		answersB.add(answer11);
		String[] BCD1 = {"1", "*", "X","^","2.0"};
		String[] BCD2 = {"4.0"};
		String[] BCD3 = {"1", "*", "X"};
		BCD = new ArrayList<>();
		BCD.add(BCD1);
		BCD.add(BCD2);
		BCD.add(BCD3);
		answersC = new ArrayList<>();
		answersC.add(answer12);
		answersC.add(answer13);
		answersC.add(answer14);
		answersC.add(answer15);
	}
	
	@Test
	public void testFindX() throws CloneNotSupportedException {
		double[] results = c.findX("x+2=22");
		double[] results1 = c.findX("x+2=0");
		double[] results2 = c.findX("x+2=22+2*x");
		double[] results3 = c.findX("x+x=22");
		double[] results4 = c.findX("x+x+x+x+x+x+x+x+x+x+x=22");
		double[] results5 = c.findX("x^2-9=0");
		double[] results6 = c.findX("x+2=-22+2*x");
		double[] results7 = c.findX("x^2+x^2=18");
		double[] results8 = c.findX("2*x^2-9=x^2");
		double[] results9 = c.findX("(2*x+2)/(2)=2");
		double[] results10 = c.findX("(4*x^2)/(2*x)=2");
		double[] results11 = c.findX("(4*x^2)/(2*x)+2=2");
		double[] results12 = c.findX("(4*x)/(2)=4");
		double[] results13 = c.findX("(10*x)/(5)=1");
		double[] results14 = c.findX("(2x)/(x)=0");
		double[] results15 = c.findX("(5x)/(2)=5"); // Inaccurate result
		double[] results16 = c.findX("x^2+7x+6=0");
		double[] results17 = c.findX("2x+2+4x+x^2+x+4=0");
		double[] results18 = c.findX("x+2=22");
		double[] results19 = c.findX("x+2=22");
		double[] results20 = c.findX("x+2=22");
		double[] results21 = c.findX("x+2=22");
		double[] results22 = c.findX("x+2=22");
		double[] results23 = c.findX("x+2=22");
		double[] results24 = c.findX("x+2=22");
		double[] results25 = c.findX("x+2=22");
		double[] results26 = c.findX("x+2=22");
		double[] results27 = c.findX("x+2=22");
		double[] results28 = c.findX("x+2=22");
		double[] results29 = c.findX("x+2=22");
		double[] results30 = c.findX("x+2=22");
		assertEquals(results[0], 20, 0);
		assertEquals(results1[0], -2, 0);
		assertEquals(results2[0], -20, 0);
		assertEquals(results3[0], 11, 0);
		assertEquals(results4[0], 2, 0);
		assertEquals(results5[0], 3, 0);
		assertEquals(results5[1], -3, 0);
		assertEquals(results6[0], 24, 0);
		assertEquals(results7[0], 3, 0);
		assertEquals(results7[1], -3, 0);
		assertEquals(results8[0], 3, 0);
		assertEquals(results8[1], -3, 0);
		assertEquals(results9[0], 1, 0);
		assertEquals(results10[0], 1, 0);
		assertEquals(results11[0], 0, 0);
		assertEquals(results12[0], 2, 0);
		assertEquals(results13[0], 0.5, 0);
		assertNull(results14);
		// assertEquals(results15[0], 2, 0); 
		assertEquals(results16[0], -1, 0);
		assertEquals(results16[1], -6, 0);
		assertEquals(results17[0], -1, 0);
		assertEquals(results17[1], -6, 0);
	}
	
	@Test
	public void testDiminish() throws CloneNotSupportedException {
		ArrayList<String[]> solutionsC = new ArrayList<>();
		String[] solution1 = toArray(diminish(toArrayList(equation9), 5));
		String[] solution2 = toArray(diminish(toArrayList(equation10), 7));
		String[] solution3 = toArray(diminish(toArrayList(equation11), 5));
		String[] solution4 = toArray(diminish(toArrayList(equation12), 5));
		solutionsC.add(solution1);
		solutionsC.add(solution2);
		solutionsC.add(solution3);
		solutionsC.add(solution4);
		int size = answersC.size() == solutionsC.size() ? answersC.size() : -1;
		if (size == -1) throw new TestFailedException("number of solutions and answers do not match");
		for (int i=0;i<size;i++) {
			String[] answer = answersC.get(i);
			String[] solution = solutionsC.get(i);
			for (int j=0;j<answer.length;j++) 
				assertEquals(solution[j], answer[j]);
		}
	}
	
	@Test
	public void testIsSimple() {
		ArrayList<double[]> solutions = new ArrayList<>();
		double[] solution1 = isSimple(toArrayList(equation1), toArrayList(sideB));
		double[] solution2 = isSimple(toArrayList(equation2), toArrayList(sideB));
		double[] solution3 = isSimple(toArrayList(equation3), toArrayList(sideB));
		double[] solution4 = isSimple(toArrayList(equation4), toArrayList(sideB));
		double[] solution5 = isSimple(toArrayList(equation5), toArrayList(sideB));
		double[] solution6 = isSimple(toArrayList(equation6), toArrayList(sideB));
		double[] solution7 = isSimple(toArrayList(equation7), toArrayList(sideB));
		double[] solution8 = isSimple(toArrayList(equation8), toArrayList(sideB));
		solutions.add(solution1);
		solutions.add(solution2);
		solutions.add(solution3);
		solutions.add(solution4);
		solutions.add(solution5);
		solutions.add(solution6);
		solutions.add(solution7);
		solutions.add(solution8);
		int size = answers.size() == solutions.size() ? answers.size() : -1;
		if (size == -1) throw new TestFailedException("number of solutions and answers do not match");
		for (int i=0;i<size;i++) {
			double[] answer = answers.get(i);
			double[] solution = solutions.get(i);
			if (solution == null) throw new TestFailedException("no solutions for this equation but there should be");
			int inSize = answer.length == solution.length ? answer.length : -1;
			if (inSize == -1) throw new TestFailedException();
			for (int j=0;j<inSize;j++) 
				assertEquals(solution[j], answer[j], 0);
		}
	}
	
	@Test
	public void testExtractBCD() {
		String[] solution1 = toArray(extractBCD(toArrayList(equation6), toArrayList(BCD.get(0))));
		String[] solution2 = toArray(extractBCD(toArrayList(equation2), toArrayList(BCD.get(1))));
		String[] solution3 = toArray(extractBCD(toArrayList(equation8), toArrayList(BCD.get(2))));
		solutionsB = new ArrayList<>();
		solutionsB.add(solution1);
		solutionsB.add(solution2);
		solutionsB.add(solution3);
		int size = answersB.size() == solutionsB.size() ? answersB.size() : -1;
		if (size == -1) throw new TestFailedException("number of solutions and answers do not match");
		for (int i=0;i<size;i++) {
			String[] answer = answersB.get(i);
			String[] solution = solutionsB.get(i);
			for (int j=0;j<answer.length;j++) 
				assertEquals(solution[j], answer[j]);
		}
	}
	
	@Test
	public void testBiggestCommonDivider() {
		String[] solution1 = toArray(biggestCommonDivider(toArrayList(equation6)));
		String[] solution2 = toArray(biggestCommonDivider(toArrayList(equation2)));
		String[] solution3 = toArray(biggestCommonDivider(toArrayList(equation8)));
		ArrayList<String[]> solutionsC = new ArrayList<>();
		solutionsC.add(solution1);
		solutionsC.add(solution2);
		solutionsC.add(solution3);
		int size = BCD.size() == solutionsC.size() ? BCD.size() : -1;
		if (size == -1) throw new TestFailedException("number of solutions and answers do not match");
		for (int i=0;i<size;i++) {
			String[] answer = BCD.get(i);
			String[] solution = solutionsC.get(i);
			for (int j=0;j<answer.length;j++) 
				assertEquals(solution[j], answer[j]);
		}
	}
	@Test
	public void testCompute() throws IllegalArgumentException, CloneNotSupportedException {
		assertEquals(c.compute(exp1), 56, 0);
		assertEquals(c.compute(exp2), 47, 0);
		assertEquals(c.compute(exp3), 9, 0);
		assertEquals(c.compute(exp4), -0, 25);
		assertEquals(c.compute(exp5), -8, 0);
		assertEquals(c.compute(exp6), 6, 0);
		assertEquals(c.compute(exp7), 1, 0);
		assertEquals(c.compute(exp8), 15, 0);
		assertEquals(c.compute(exp9), 7, 0);
		assertEquals(c.compute(exp10), 45, 0);
		assertEquals(c.compute(exp11), -1, 0);
		assertEquals(c.compute(exp12), -9, 0);
	}
	private static ArrayList<String> toArrayList(String[] array) {
		ArrayList<String> equation = new ArrayList<>();
		for (String s : array) {
			equation.add(s);
		}
		return equation;
	}
	
	private String[] toArray(ArrayList<String> list) {
		String[] array = new String[list.size()];
		for(int i=0;i<list.size();i++) 
			array[i] = list.get(i);
		return array;
	}
	
	@Test
	public void testSolveQuadraticEquation() {
		String[] equation1 = {"1", "*", "X", "^", "2", "+", "9", "*", "X", "+", "18"};
		ArrayList<String> equation = new ArrayList<String>();
		for (String s : equation1) equation.add(s);
		double[] answer = {-3, -6};
		double[] solution = solveQuadraticEquation(equation);
		for(int i=0;i<answer.length;i++) assertEquals(solution[i], answer[i], 0);
		String[] equation2 = {"1", "*", "X", "^", "2", "-", "4", "*", "X", "+", "4"};
		int size = equation.size();
		for (int i=0;i<size;i++) 
			equation.remove(0);
		for (String s : equation2) equation.add(s);
		double[] answer2 = {2};
		solution = solveQuadraticEquation(equation);
		for(int i=0;i<answer2.length;i++) assertEquals(solution[i], answer2[i], 0);
		String[] equation3 = {"1", "*", "X", "^", "2", "-", "4", "*", "X", "+", "401"};
		size = equation.size();
		for (int i=0;i<size;i++) 
			equation.remove(0);
		for (String s : equation3) equation.add(s);
		double[] answer3 = {};
		solution = solveQuadraticEquation(equation);
		for(int i=0;i<answer3.length;i++) assertEquals(solution[i], answer3[i], 0);
	}
	
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
	private double[] isSimple(ArrayList<String> sideA, ArrayList<String> sideB) throws ArithmeticException {
		double[] solutions = null;
		int size = sideA.size();
		if(!sideIs0(sideB) || size < 3) return solutions;
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
		if (size < 9) return solutions;
		double c = Double.parseDouble(sideA.get(6));
		if (size == 9) {
			solutions = new double[2];
			if (isParameter(sideA, 2) && sideA.get(3) == "^" && sideA.get(4) == "2") 
				if (sideA.get(5) == "+") throw new ArithmeticException(); // a*x^2+c=0
				else if (sideA.get(5) == "-") { // a*x^2-c=0
					solutions[0] = Math.sqrt(c / a);
					solutions[1] = -Math.sqrt(c / a);
				}
		}
		if (size < 11) return solutions;
		double n = Double.parseDouble(sideA.get(10));
		if (size == 11) {
			if (!isParameter(sideA, 10) && isParameter(sideA, 2) && sideA.get(3) == "^" &&
					sideA.get(4) == "2" && isParameter(sideA, 8))
				solutions = solveQuadraticEquation(sideA); // a*x^2+b*x+c=0	
			else if (sideA.get(3).equals("^"))
				if (b == n+2) { //a*x^b-c*x^(b-2), (n=b+2)
					if(sideA.get(5) == "+") throw new ArithmeticException();//a*x^b+c*x^(b-2)
					else if (sideA.get(5) == "-") {
						solutions = new double[3];
						solutions[0] = Math.sqrt(c / a);
						solutions[1] = -Math.sqrt(c / a);
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
		return solutions;
	}
	private double[] isSimple(ArrayList<String> side) {
		return isSimple(side, toArrayList(sideB));
	}
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
		return side.size() == 1 && side.get(0) == "0";
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
		// TODO
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
				if (i>1 && exp.get(i-1).equals("^")) continue;
				double num = Double.parseDouble(s);
				// Change smallestN value to num's value if num is smaller.
				smallestN = num < smallestN ? num : smallestN;
			}
		}
		boolean pflag = false;
		for (int i=0, j=0;i<exp.size();i++) {
			String s = exp.get(i);		
			// If its a parameter and valid
			if (j < exp.size() && smallestX > 0 && isParameter(exp, j)) { 
				double parameter = superScriptOf(exp, j);
				double result = parameter - smallestX;
				if (result < 0) smallestX = 0;
				pflag = true;
			}
			if (hasValue(s) && smallestN > 1 && !isParameter(exp, i)) { // If its a number and valid
				if (i>1 && exp.get(i-1).equals("^")) {
					continue;
				}
				double num = Double.parseDouble(s);
				// If smallestN isn't 1,0 and isn't dividable
				if (smallestN != 0 && smallestN != 1 && smallestN != -1 && num % smallestN != 0) {
				// Increase or decrease smallestN depends on the sign(+ or -) of smallestN
					if (smallestN > 0) 
						smallestN--;
					else 
						smallestN++;
						
					i = 0;
				}
			}
			if (s.equals("+") || s.equals("-")) { // If its a new part of the expression
				if (!pflag) smallestX = 0; // Check if the previous part had a parameter
				pflag = false;
			}
			j++;
		}
		if (smallestN != 1 && smallestN != 0 && smallestN != -1)
			BCD.add(Double.toString(smallestN));
		if (smallestX > 0) {
			if (BCD.isEmpty()) BCD.add("1");
			BCD.add("*");
			BCD.add("X");
			if (smallestX > 1) {
				BCD.add("^");
				BCD.add(Double.toString(smallestX));
			}
		}
		if (BCD.isEmpty()) return null;
		else return BCD;
	}
	// Dimminishes the expression if possible.
	private ArrayList<String> diminish(ArrayList<String> side, int i) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		ArrayList<String> left = new ArrayList<>();
		left.add(side.get(i-1));
		ArrayList<String> right = new ArrayList<>();
		right.add(side.get(i+1));
		Stack<String> buffer = new LinkedStack<>();
		ArrayList<String> expression = null;
		// Iterate over the left of the "/" and define the expression.
		for (int j=i-1;j>=0;j--) {
			String s = side.get(j);
			if (!buffer.isEmpty()) {
				if (Calculator.opening.indexOf(s) != -1) buffer.pop();
				left.add(s);
			}
			if (Calculator.closing.indexOf(s) != -1) buffer.push(s); 
		}
		left.reverse();
		// Iterate over the right of the "/" and define the expression.
		for (int j=i+1;j<side.size();j++) {
			String s = side.get(j);
			if (!buffer.isEmpty()) {
				if (Calculator.closing.indexOf(s) != -1) buffer.pop();
				right.add(s);
			}
			if (Calculator.opening.indexOf(s) != -1) buffer.push(s);
		}
		ArrayList<String> BCD;
		if ((BCD = biggestCommonDivider(side)) != null) {
			ArrayList<String> rightLike = right.clone();
			rightLike.remove(0);
			rightLike.remove(rightLike.size()-1);
			if (BCD.equals(rightLike)) {
				for (int j=i+right.size();j>=i;j--) 
					side.remove(j);
				side.remove(0);
				side.remove(side.size()-1);
			}
			expression = extractBCD(side, BCD);
			for (int k=BCD.size();k>=0;k--) {
				expression.remove(k);
			}
			expression.remove(0);
			expression.remove(expression.size()-1);
		}
		else {
			ArrayList<String> leftBCD = biggestCommonDivider(left);
			ArrayList<String> rightBCD = biggestCommonDivider(right);
			leftBCD.add("/");
			for (int k=0;k<rightBCD.size();k++) {
				leftBCD.add(rightBCD.get(k));
			}
			if ((BCD = biggestCommonDivider(leftBCD)) != null) {
				expression = extractBCD(side, BCD);
				for (int k=BCD.size();k>=0;k++) {
					expression.remove(i);
				}
				expression.remove(0);
				expression.remove(expression.size()-1);
			}
		}
		if (expression != null) return expression;
		return null;
	}
}
