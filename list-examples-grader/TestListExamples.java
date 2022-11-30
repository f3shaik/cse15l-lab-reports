import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;

class checkChecker implements StringChecker {
    @Override
    public boolean checkString(String s) {
        return s.startsWith("item");
    }
}

public class TestListExamples {
  @Test
  public void testFilterEmpty() {
      List<String> input = new ArrayList<>();
      StringChecker checker = new checkChecker();
      assertTrue(ListExamples.filter(input, checker).isEmpty());
  }

  @Test
  public void testFilterOne() {
      List<String> input = new ArrayList<>(Arrays.asList("item1"));
      StringChecker checker = new checkChecker();
      assertEquals(new ArrayList<>(Arrays.asList("item1")),
                    ListExamples.filter(input, checker));
  }

  @Test
  public void testFilterTwo() {
      List<String> input = new ArrayList<>(Arrays.asList("item1", "item2"));
      StringChecker checker = new checkChecker();
      assertEquals(new ArrayList<>(Arrays.asList("item1", "item2")),
                    ListExamples.filter(input, checker));
  }

  @Test(timeout = 1000)
  public void testMergeEmpty() {
      List<String> list1 = new ArrayList<>();
      List<String> list2 = new ArrayList<>();
      assertTrue(ListExamples.merge(list1, list2).isEmpty());
  }

  @Test(timeout = 1000)
  public void testMergeOne() {
      List<String> list1 = new ArrayList<>(Arrays.asList("item"));
      List<String> list2 = new ArrayList<>();
      assertEquals(new ArrayList<>(Arrays.asList("item")), 
                    ListExamples.merge(list1, list2));
  }

  @Test(timeout = 1000)
  public void testMergeTwo() {
      List<String> list1 = new ArrayList<>();
      List<String> list2 = new ArrayList<>(Arrays.asList("item"));
      assertEquals(new ArrayList<>(Arrays.asList("item")), 
                    ListExamples.merge(list1, list2));
  }
}
