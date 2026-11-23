import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListDequeUnitTest {
    @Test
    public void testLinkedListDeque() {
        LinkedListDeque<Integer> target = new LinkedListDeque<Integer>();
        assertTrue(target.isEmpty());
        assertEquals(null, target.get(500));
        assertEquals(null, target.getRecursive(500));

        target.addFirst(2026);
        assertFalse(target.isEmpty());
        assertEquals(1, target.size());
        target.addLast(2027);
        assertEquals(2, target.size());
        assertEquals(Integer.valueOf(2027), target.removeLast());
        assertEquals(Integer.valueOf(2026), target.removeFirst());
        assertEquals(0, target.size());

        for (int i = 1; i < 64; i *= 2) {
            target.addLast(i);
        }
        assertEquals(Integer.valueOf(8), target.get(3));
        assertEquals(Integer.valueOf(32), target.getRecursive(5));
    }

    @Test
    public void testAddFirst() {
        LinkedListDeque<Integer> target = new LinkedListDeque<Integer>();
        target.addFirst(1);
        target.addFirst(2);
        target.addFirst(3);
        assertEquals(Integer.valueOf(1), target.get(2));
    }

    @Test
    public void testAddLast() {
        LinkedListDeque<Integer> target = new LinkedListDeque<Integer>();
        target.addLast(1);
        target.addLast(2);
        target.addLast(3);
        assertEquals(Integer.valueOf(3), target.get(2));
    }

    @Test
    public void testIsEmpty() {
        LinkedListDeque<Integer> target = new LinkedListDeque<Integer>();
        assertTrue(target.isEmpty());

        target.addLast(2026);
        assertFalse(target.isEmpty());
    }

    @Test
    public void testSize() {
        LinkedListDeque<Integer> target = new LinkedListDeque<Integer>();
        assertEquals(0, target.size());

        target.addLast(2026);
        assertEquals(1, target.size());

        target.removeLast();
        assertEquals(0, target.size());
    }

    @Test
    public void testRemoveFirst() {
        LinkedListDeque<Integer> target = new LinkedListDeque<Integer>();
        target.addFirst(2026);
        target.addFirst(2027);
        assertEquals(Integer.valueOf(2027), target.removeFirst());
        assertEquals(Integer.valueOf(2026), target.removeFirst());
    }

    @Test
    public void testRemoveLast() {
        LinkedListDeque<Integer> target = new LinkedListDeque<Integer>();
        target.addLast(2026);
        target.addLast(2027);
        assertEquals(Integer.valueOf(2027), target.removeLast());
        assertEquals(Integer.valueOf(2026), target.removeLast());
    }

    @Test
    public void testGet() {
        LinkedListDeque<Integer> target = new LinkedListDeque<Integer>();
        assertEquals(null, target.get(500));
        for (int i = 1; i < 10; i *= 2) {
            target.addLast(i);
        }
        assertEquals(Integer.valueOf(1), target.get(0));
        assertEquals(Integer.valueOf(2), target.get(1));
        assertEquals(Integer.valueOf(4), target.get(2));
        assertEquals(Integer.valueOf(8), target.get(3));
    }

    @Test
    public void testGetRecursive() {
        LinkedListDeque<Integer> target = new LinkedListDeque<Integer>();
        assertEquals(null, target.getRecursive(500));
        for (int i = 1; i < 10; i *= 2) {
            target.addLast(i);
        }
        assertEquals(Integer.valueOf(1), target.getRecursive(0));
        assertEquals(Integer.valueOf(2), target.getRecursive(1));
        assertEquals(Integer.valueOf(4), target.getRecursive(2));
        assertEquals(Integer.valueOf(8), target.getRecursive(3));
    }

    public static void main(String... args) {
        jh61b.junit.TestRunner.runTests("all", LinkedListDequeUnitTest.class);
    }
}
