package ch.csbe.small;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int population = 40;
		long timebefore = System.nanoTime(), 
				timeafter = System.nanoTime();
		long result = 0;
		
		timebefore = System.nanoTime();
		result = fibonacciA(population);
		timeafter = System.nanoTime();
		System.out.println("A " + result + " hat: " + (timeafter-timebefore));
		
		timebefore = System.nanoTime();
		result = fibonacciB(population);
		timeafter = System.nanoTime();
		System.out.println("B " + result + " hat: " + (timeafter-timebefore));
		
		timebefore = System.nanoTime();
		result = fibonacciC(population);
		timeafter = System.nanoTime();
		System.out.println("C " + result + " hat: " + (timeafter-timebefore));
		
		
	}

	/**
	 * Rekursive Lösung - bei hohen zahlen sehr aufwendig!
	 * @param n Populationsstufe
	 * @return Anzahl nach Fibonacci
	 */
	public static long fibonacciC(int n) {
		if (n <= 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fibonacciC(n - 2) + fibonacciC(n - 1);
	}

	/**
	 * Keine Ausnahme-Prüfung und Aufwendig
	 * @param n Populationsstufe
	 * @return Anzahl nach Fibonacci
	 */
	public static long fibonacciB(int n) {
		long begin = 1;
		long end = 0;
		for (int i = 0; i < n; i++) {
			long before = end;
			long after = begin + end;
			begin = before;
			end = after;
		}
		return end;
	}

	/**
	 * Mit Prüfung
	 * @param n Populationsstufe
	 * @return Anzahl nach Fibonacci
	 */
	public static long fibonacciA(int n) {
		if (n <= 0)
			return 0;
		else if (n == 1)
			return 1;
		else {
			long begin = 0;
			long end = 1;
			int i = 2;
			while (i <= n) {
				long before = end;
				long after = begin + end;
				begin = before;
				end = after;
				i++;
			}
			return end;
		}
	}

}
