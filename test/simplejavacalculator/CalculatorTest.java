package simplejavacalculator;

import static org.junit.Assert.*;

import org.junit.*;

import simplejavacalculator.*;

public class CalculatorTest {

	private static final double DELTA = 1e-15;
	Calculator cal;

	@Before
	public void setUp() throws Exception {
		cal = new Calculator();
		cal.reset();
	}


	@Test
	public void calculateBiTest() {
		double result, expect;
		double temp = 16.0d;	

		expect = Double.NaN;
		result = cal.calculateBi(Calculator.BiOperatorModes.add, temp);
		assertEquals(result, expect, DELTA);

		expect -= temp;
		result = cal.calculateBi(Calculator.BiOperatorModes.minus, temp);
		assertEquals(result, expect, DELTA);

		expect *= temp;
		result = cal.calculateBi(Calculator.BiOperatorModes.multiply, temp);
		assertEquals(result, expect, DELTA);

		expect /= temp;
		result = cal.calculateBi(Calculator.BiOperatorModes.divide, temp);
		assertEquals(result, expect, DELTA);
		
		cal.reset();
	}

	@Test
	public void calculateEqual() {
		double result, expect;

		expect = 1.0d + 5.0d;
		cal.calculateBi(Calculator.BiOperatorModes.add, 1.0d);
		result = cal.calculateEqual(5.0d);
		assertEquals(result, expect, DELTA);

		expect = 2.0d - 5.0d;
		cal.calculateBi(Calculator.BiOperatorModes.minus, 2.0d);
		result = cal.calculateEqual(5.0d);
		assertEquals(result, expect, DELTA);

		expect = 3.0d * 5.0d;
		cal.calculateBi(Calculator.BiOperatorModes.multiply, 3.0d);
		result = cal.calculateEqual(5.0d);
		assertEquals(result, expect, DELTA);

		expect = 4.0d / 3.0d;
		cal.calculateBi(Calculator.BiOperatorModes.divide, 4.0d);
		result = cal.calculateEqual(5.0d);
		assertEquals(result, expect, DELTA);
	}

	@Test
    public void resetTest() {
        double expect = Double.NaN;
		double result = cal.reset();
		assertEquals(result, expect, DELTA);
    }

	@Test
    public void calculateMonoTest() {
		double result, expect;

		expect = 3.3d * 3.3d;
		result = cal.calculateMono(Calculator.MonoOperatorModes.square, 3.3d);
		assertEquals(result, expect, DELTA);

		expect = Math.sqrt(3.3d);
		result = cal.calculateMono(Calculator.MonoOperatorModes.squareRoot, 3.3d);
		assertEquals(result, expect, DELTA);

		expect = 1.0d / 3.3d;
		result = cal.calculateMono(Calculator.MonoOperatorModes.oneDevidedBy, 3.3d);
		assertEquals(result, expect, DELTA);

		expect = Math.cos(3.3d);
		result = cal.calculateMono(Calculator.MonoOperatorModes.cos, 3.3d);
		assertEquals(result, expect, DELTA);

		expect = Math.sin(3.3d);
		result = cal.calculateMono(Calculator.MonoOperatorModes.sin, 3.3d);
		assertEquals(result, expect, DELTA);

		expect = Math.tan(3.3d);
		result = cal.calculateMono(Calculator.MonoOperatorModes.tan, 3.3d);
		assertEquals(result, expect, DELTA);
	}

}
