package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibonacciTest {
	@Test
	void should_return_1_when_index_1_and_2(){
		assertEquals(1,FibonacciCalculator.calculate(1));
		assertEquals(1,FibonacciCalculator.calculate(2));
	}
}
