import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

interface StringChecker { boolean checkString(String s); }

class lengthCheck implements StringChecker
{
  private int minLen;
  private int maxLen;
  
  public lengthCheck(int minLen, int maxLen) {
    this.minLen = minLen;
    this.maxLen = maxLen;
  }
  
  public boolean checkString(String s) {
    return minLen <= s.length() && s.length() <= maxLen;
  }
}

public class ListTests {
  StringChecker s1 = new lengthCheck(1, 5);

	@Test 
	public void stringCheck() {
    List<String> listss = Arrays.asList("", "b", "cc", "ddd", "eeee", "fffff", "gggggg");
    List<String> expected = Arrays.asList("b", "cc", "ddd", "eeee", "fffff");
    assertThat(ListExamples.filter(listss, s1), is(expected));

	}
  
}
