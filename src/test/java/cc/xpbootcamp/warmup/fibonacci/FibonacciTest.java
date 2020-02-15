package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibonacciTest {
	@Test
	void should_return_1_when_index_1_and_2(){
		assertEquals(1,FibonacciCalculator.calculate(1));
		assertEquals(1,FibonacciCalculator.calculate(2));
	}

	@Test
	void should_return_corresponding_result(){
		assertEquals(2,FibonacciCalculator.calculate(3));
		assertEquals(5,FibonacciCalculator.calculate(5));
		assertEquals(89,FibonacciCalculator.calculate(11));
	}

	@Test
	void should_return_12586269025_when_index_50(){
		assertEquals(12586269025L,FibonacciCalculator.calculate(50));
	}

	@Test
	void should_throw_exception_when_index_less_than_1(){
		assertThrows(IllegalArgumentException.class,()->FibonacciCalculator.calculate(0));
		assertThrows(IllegalArgumentException.class,()->FibonacciCalculator.calculate(-1));
	}
}
