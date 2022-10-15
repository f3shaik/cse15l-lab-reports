import static org.junit.Assert.*;
import org.junit.*;

public class ArrayTests {
	@Test 
	public void testReverseInPlace() {
    int[] input1 = { 3 };
    ArrayExamples.reverseInPlace(input1);
    assertArrayEquals(new int[]{ 3 }, input1);
	}

  @Test
  public void testReversed() {
    int[] input1 = { };
    assertArrayEquals(new int[]{ }, ArrayExamples.reversed(input1));
  }

  @Test
  public void testReversedFiveElements() {
    int[] input1 = { 1, 2, 3, 4, 5 };
    int[] input2 = { 5, 4, 3, 2, 1 };
    ArrayExamples.reverseInPlace(input1);
    assertArrayEquals(input2, input1);
  }

  @Test
  public void testReversedFourElements() {
    int[] input1 = { 6, 7, 8, 9 };
    int[] input2 = { 9, 8, 7, 6 };
    assertArrayEquals(input2, ArrayExamples.reversed(input1));
  }

  @Test
  public void meanAverage() {
    double[] input1 = { 1.0, 1.0, 1.0 };
    assertEquals(1.0, ArrayExamples.averageWithoutLowest(input1), 0.01);
  }

  
}
