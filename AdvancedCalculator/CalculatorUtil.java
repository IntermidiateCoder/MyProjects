package AdvancedCalculator;

public class CalculatorUtil {
	public static double power(double x, int y)
	{
	    double temp;
	    if (y == 0)
	       return 1;
	    temp = power(x, y/2);       
	    if (y%2 == 0)
	        return temp*temp;
	    else
	    {
	        if(y > 0)
	            return x*temp*temp;
	        else
	            return (temp*temp)/x;
	    }
	}
	static class SequenceSeries {
	    public static int factorial(int inputN) {
	         int n = inputN;
	         if (n == 0) {
	              return 1;
	         } else {
	              return n * factorial(n - 1);
	         }
	    }
	}
	class Binomial {
	    private int n;
	    private int k;
	    public Binomial() {
	    }
	    public int calcCoef(int inputN, int inputK) {
	         n = inputN;
	         k = inputK;
	         int coefficient = (SequenceSeries.factorial(n)) / ((SequenceSeries.factorial(n - k))* SequenceSeries.factorial(k));
	         return coefficient;
	    }
	    public int binomialCoef(int inputN, int inputIndex) {
	         n = inputN;
	         int numberOfTerms = n + 1;
	         int[] coefArr = new int[numberOfTerms];
	         for (int i = 0; i <= n; i++) {
	              k = i;
	              coefArr[i] = this.calcCoef(n, k);
	         }
	         return coefArr[inputIndex];
	    }
	    public int aExponent(int inputN, int inputIndex) {
	         n = inputN;
	         int numberOfTerms = n + 1;
	         int[] aExpArr = new int[numberOfTerms];
	         for (int i = 0; i <= n; i++) {
	              k = i;
	              aExpArr[i] = n - k;
	         }
	         return aExpArr[inputIndex];
	    }
	    public int bExponent(int inputN, int inputIndex) {
	         n = inputN;
	         int numberOfTerms = n + 1;
	         int[] bExpArr = new int[numberOfTerms];
	         for (int i = 0; i <= n; i++) {
	              k = i;
	              bExpArr[i] = k;
	         }
	         return bExpArr[inputIndex];
	    }
	}
}
