package cs271.lab.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestIterator {

  private List<Integer> list;
  // See the Java List Interface documentation to understand what all the List methods do ...
  // https://docs.oracle.com/javase/8/docs/api/java/util/List.html

  @Before
  public void setUp() throws Exception {
    list = new ArrayList<Integer>();
    // TODO also try with a LinkedList - does it make any difference?
  }

  @After
  public void tearDown() throws Exception {
    list = null;
  }

  @Test
  public void testEmpty() {
    final Iterator<Integer> i = list.iterator();
    assertFalse(i.hasNext());
  }

  @Test
  public void testNonempty() {
    list.add(33);
    list.add(77);
    list.add(44);
    list.add(77);
    list.add(55);
    list.add(77);
    list.add(66);
    final Iterator<Integer> i = list.iterator();
    assertTrue(i.hasNext());
    assertEquals(33, i.next().intValue());
    assertTrue(i.hasNext());
    assertEquals(77, i.next().intValue());
    assertTrue(i.hasNext());
    assertEquals(44, i.next().intValue());
    assertTrue(i.hasNext());
    assertEquals(77, i.next().intValue());
    assertTrue(i.hasNext());
    assertEquals(55, i.next().intValue());
    assertTrue(i.hasNext());
    assertEquals(77, i.next().intValue());
    assertTrue(i.hasNext());
    assertEquals(66, i.next().intValue());
    assertFalse(i.hasNext());
  }

  @Test
  public void testRemove() {
    list.add(33);
    list.add(77);
    list.add(44);
    list.add(77);
    list.add(55);
    list.add(77);
    list.add(66);
    final Iterator<Integer> i = list.iterator();
    while (i.hasNext()) {
      if (i.next() == 77) {
        //list.remove(Integer.valueOf(77)); //doesn't work correctly because it's not using the iterator
        i.remove(); // TODO what happens if you use list.remove(Integer.valueOf(77))?
      }
    }
    Integer[] b = new Integer[] {33, 44, 55, 66};
    assertEquals(true, list.containsAll(Arrays.asList(b)));
    // TODO clarify if this is the correct way to test
  }

  @Test
  public void testAverageValues() {
    list.add(33);
    list.add(77);
    list.add(44);
    list.add(77);
    list.add(55);
    list.add(77);
    list.add(66);
    double sum = 0;
    int n = 0;
    final Iterator<Integer> i = list.iterator();
    while (i.hasNext()){
      sum = sum + i.next();
      n++;
      }
    assertEquals(61.3, sum / n, 0.1);
    assertEquals(7, n);
  }
}
