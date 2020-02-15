package cc.xpbootcamp.warmup.fibonacci;

public class FibonacciCalculator {
	public static long calculate(int index) {
		if (index == 1 || index == 2) {
			return 1;
		}
		return calculate(index - 2) + calculate(index - 1);
	}
}
