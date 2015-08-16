package dz3LinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by dmitriy on 8/15/15.
 */
public class MyLinkedListTest {
    private MyLinkedList<String> myLinkedList;

    @Before
    public void setUp() throws Exception {
        myLinkedList = new MyLinkedList<String>();
    }

    @Test
    public void testAddToEmptyList() throws Exception {
        //when
        boolean result = myLinkedList.add("1");

        //then
        assertTrue(result);
        assertFalse(myLinkedList.isEmpty());
        assertEquals("1", myLinkedList.getFirst().getValue());
        assertEquals("1", myLinkedList.getLast().getValue());
        assertNull(myLinkedList.getFirst().getPrev());
        assertNull(myLinkedList.getLast().getNext());
    }

    @Test
    public void testAddToListWithOneElement() throws Exception {
        //given
        myLinkedList.add("1");

        //when
        boolean result = myLinkedList.add("2");

        //then
        assertTrue(result);
        assertEquals("1", myLinkedList.getFirst().getValue());
        assertEquals("2", myLinkedList.getLast().getValue());
        assertEquals(2, myLinkedList.size());
        assertEquals(myLinkedList.getFirst().getNext().getValue(), myLinkedList.getLast().getValue());
        assertEquals(myLinkedList.getLast().getPrev().getValue(), myLinkedList.getFirst().getValue());
        assertNull(myLinkedList.getFirst().getPrev());
        assertNull(myLinkedList.getLast().getNext());
    }

    @Test
    public void testAddToNotEmptyList() throws Exception {
        //given
        myLinkedList.add("1");
        myLinkedList.add("2");
        myLinkedList.add("3");

        //when
        boolean result = myLinkedList.add("4");

        //then
        assertTrue(result);
        assertEquals("1", myLinkedList.getFirst().getValue());
        assertEquals("4", myLinkedList.getLast().getValue());
        assertEquals(4, myLinkedList.size());
        assertNull(myLinkedList.getFirst().getPrev());
        assertNull(myLinkedList.getLast().getNext());
    }

    @Test
    public void testAddByIndex() throws Exception {
        //given
        myLinkedList.add("1");
        myLinkedList.add("2");
        myLinkedList.add("3");
        myLinkedList.add("4");

        //when
        myLinkedList.add(1, "5");

        //then
        assertEquals("5", myLinkedList.get(1));
        assertEquals("1", myLinkedList.getFirst().getValue());
        assertEquals("4", myLinkedList.getLast().getValue());
        assertEquals("5", myLinkedList.getFirst().getNext().getValue());
        assertEquals(5, myLinkedList.size());
        assertNull(myLinkedList.getFirst().getPrev());
        assertNull(myLinkedList.getLast().getNext());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddByIndexLessThanZero() throws Exception {
        //given
        myLinkedList.add("1");
        myLinkedList.add("2");
        myLinkedList.add("3");
        myLinkedList.add("4");

        //when
        myLinkedList.add(-1, "5");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddByIndexMoreThanSize() throws Exception {
        //given
        myLinkedList.add("1");
        myLinkedList.add("2");
        myLinkedList.add("3");
        myLinkedList.add("4");

        //when
        myLinkedList.add(5, "5");
    }

    @Test
    public void testAddByIndexFirst() throws Exception {
        //given
        myLinkedList.add("1");

        //when
        myLinkedList.add(0, "2");

        //then
        assertEquals("2", myLinkedList.getFirst().getValue());
        assertEquals("1", myLinkedList.getFirst().getNext().getValue());
        assertEquals(2, myLinkedList.size());
        assertEquals("2", myLinkedList.getFirst().getNext().getPrev().getValue());
        assertNull(myLinkedList.getFirst().getPrev());
        assertNull(myLinkedList.getLast().getNext());
    }

    @Test
    public void testClear() throws Exception {
        //given
        myLinkedList.add("1");

        //when
        myLinkedList.clear();

        //then
        assertTrue(myLinkedList.isEmpty());
    }

    @Test
    public void testContains() throws Exception {
        //given
        myLinkedList.add("1");
        myLinkedList.add("2");
        myLinkedList.add("3");
        myLinkedList.add("4");

        //when
        assertTrue(myLinkedList.contains("1"));
        assertFalse(myLinkedList.contains("5"));
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(0, myLinkedList.size());

        myLinkedList.add("1");
        assertEquals(1, myLinkedList.size());

        myLinkedList.add("2");
        myLinkedList.add("3");
        assertEquals(3, myLinkedList.size());
    }

    @Test
    public void testGet() throws Exception {
        //given
        myLinkedList.add("1");
        myLinkedList.add("2");
        myLinkedList.add("3");

        //when
        assertEquals("1", myLinkedList.get(0));
        assertEquals("2", myLinkedList.get(1));
        assertEquals("3", myLinkedList.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetIndexLessThanZero() throws Exception {
        //given
        myLinkedList.add("1");

        //when
        myLinkedList.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetIndexMoreThanSize() throws Exception {
        //given
        myLinkedList.add("1");

        //when
        myLinkedList.get(1);
    }

    @Test
    public void testIsEmptyTrue() throws Exception {
        assertTrue(myLinkedList.isEmpty());
    }

    @Test
    public void testIsEmptyFalse() throws Exception {
        //given
        myLinkedList.add("1 ");

        //when
        assertFalse(myLinkedList.isEmpty());
    }

    @Test
    public void testRemoveMiddle() throws Exception {
        //given
        myLinkedList.add("1");
        myLinkedList.add("2");
        myLinkedList.add("3");

        //when
        String result = myLinkedList.remove(1);

        //then
        assertEquals("2", result);
        assertEquals("3", myLinkedList.get(1));
        assertEquals("1", myLinkedList.get(0));
        assertEquals(2, myLinkedList.size());
    }

    @Test
    public void testRemoveLast() throws Exception {
        //given
        myLinkedList.add("1");
        myLinkedList.add("2");
        myLinkedList.add("3");

        //when
        String result = myLinkedList.remove(2);

        //then
        assertEquals("3", result);
        assertEquals("2", myLinkedList.get(1));
        assertEquals("1", myLinkedList.get(0));
        assertEquals(2, myLinkedList.size());
        assertEquals("2", myLinkedList.getLast().getValue());
    }

    @Test
    public void testRemoveFirst() throws Exception {
        //given
        myLinkedList.add("1");
        myLinkedList.add("2");
        myLinkedList.add("3");

        //when
        String result = myLinkedList.remove(0);

        //then
        assertEquals("1", result);
        assertEquals("2", myLinkedList.get(0));
        assertEquals("3", myLinkedList.get(1));
        assertEquals(2, myLinkedList.size());
        assertEquals("2", myLinkedList.getFirst().getValue());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIndexLessThanZero() throws Exception {
        //given
        myLinkedList.add("1");
        myLinkedList.add("2");
        myLinkedList.add("3");

        //when
        myLinkedList.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIndexMoreThanSize() throws Exception {
        //given
        myLinkedList.add("1");
        myLinkedList.add("2");
        myLinkedList.add("3");

        //when
        myLinkedList.remove(20);
    }

    @Test
    public void testRemoveByValueTrue() throws Exception {
        //given
        myLinkedList.add("1");
        myLinkedList.add("2");
        myLinkedList.add("3");

        //when
        boolean result = myLinkedList.remove("1");

        //then
        assertTrue(result);
        assertEquals("2", myLinkedList.get(0));
        assertEquals("3", myLinkedList.get(1));
        assertEquals(2, myLinkedList.size());
    }

    @Test
    public void testRemoveByValueFalse() throws Exception {
        //given
        myLinkedList.add("1");
        myLinkedList.add("2");
        myLinkedList.add("3");

        //when
        boolean result = myLinkedList.remove("4");

        //then
        assertFalse(result);
        assertEquals(3, myLinkedList.size());
    }

    @Test
    public void testSet() throws Exception {
        //given
        myLinkedList.add("1");
        myLinkedList.add("2");
        myLinkedList.add("3");

        //when
        String result = myLinkedList.set(1, "4");

        //then
        assertEquals("2", result);
        assertEquals("4", myLinkedList.get(1));
        assertEquals(3, myLinkedList.size());

    }
}
