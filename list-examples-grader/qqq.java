import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.IOException;

class DogChecker implements StringChecker {
    @Override
    public boolean checkString(String s) {
        return s.startsWith("dog");
    }
}

public class TestListExamples {
  @Test
  public void testFilterEmpty() {
      List<String> input = new ArrayList<>();
      StringChecker checker = new DogChecker();
      assertTrue(ListExamples.filter(input, checker).isEmpty());
  }

  @Test
  public void testFilterOneGood() {
      List<String> input = new ArrayList<>(Arrays.asList("dog1"));
      StringChecker checker = new DogChecker();
      assertEquals(new ArrayList<>(Arrays.asList("dog1")),
                    ListExamples.filter(input, checker));
  }


  @Test(timeout = 1000)
  public void testMergeEmpty() {
      List<String> list1 = new ArrayList<>();
      List<String> list2 = new ArrayList<>();
      assertTrue(ListExamples.merge(list1, list2).isEmpty());
  }

  @Test(timeout = 1000)
  public void testMergeOnly1() {
      List<String> list1 = new ArrayList<>(Arrays.asList("hi"));
      List<String> list2 = new ArrayList<>();
      assertEquals(new ArrayList<>(Arrays.asList("hi")), 
                    ListExamples.merge(list1, list2));
  }
}
