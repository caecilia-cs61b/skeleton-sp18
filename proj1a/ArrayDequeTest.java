import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayDequeTest {
    private static <T> T[] dequeToArray(ArrayDeque<T> ad) {
        T[] result = (T[]) new Object[ad.size()];
        for (int i = 0; i < ad.size(); i++) {
            result[i] = ad.get(i);
        }
        return result;
    }

    @Test
    public void testAddFirst() {
        ArrayDeque<Integer> target = new ArrayDeque<Integer>();
        for (int i = 0; i < 4; i++) {
            target.addFirst(i);
        }
        Integer[] exp = { 3, 2, 1, 0 };
        assertArrayEquals(exp, dequeToArray(target));
    }

    @Test
    public void testAddLast() {
        ArrayDeque<Integer> target = new ArrayDeque<Integer>();
        for (int i = 0; i < 4; i++) {
            target.addLast(i);
        }
        Integer[] exp = { 0, 1, 2, 3 };
        assertArrayEquals(exp, dequeToArray(target));
    }

    @Test
    public void testIsEmpty() {
        ArrayDeque<Integer> target = new ArrayDeque<Integer>();
        assertTrue(target.isEmpty());

        target.addLast(2026);
        assertFalse(target.isEmpty());
    }

    @Test
    public void testSize() {
        ArrayDeque<Integer> target = new ArrayDeque<Integer>();
        assertEquals(0, target.size());

        target.addLast(2026);
        assertEquals(1, target.size());

        target.removeLast();
        assertEquals(0, target.size());
    }

    @Test
    public void testRemoveFirst() {
        ArrayDeque<Integer> target0 = new ArrayDeque<Integer>();
        for (int i = 0; i < 8; i++) {
            target0.addFirst(i);
        }
        for (int i = 7; i > 3; i--) {
            assertEquals(Integer.valueOf(i), target0.removeFirst());
        }
        Integer[] exp = { 3, 2, 1, 0 };
        assertArrayEquals(exp, dequeToArray(target0));

        ArrayDeque<Integer> target1 = new ArrayDeque<Integer>();
        assertEquals(null, target1.removeFirst());
        assertEquals(0, target1.size());
    }

    @Test
    public void testRemoveLast() {
        ArrayDeque<Integer> target0 = new ArrayDeque<Integer>();
        for (int i = 0; i < 8; i++) {
            target0.addLast(i);
        }
        for (int i = 7; i > 3; i--) {
            assertEquals(Integer.valueOf(i), target0.removeLast());
        }
        Integer[] exp = { 0, 1, 2, 3 };
        assertArrayEquals(exp, dequeToArray(target0));

        ArrayDeque<Integer> target1 = new ArrayDeque<Integer>();
        assertEquals(null, target1.removeLast());
        assertEquals(0, target1.size());
    }

    @Test
    public void testResize() {
        // without resize
        ArrayDeque<Integer> target0 = new ArrayDeque<Integer>();
        for (int i = 0; i < 8; i++) {
            target0.addLast(i);
        }
        Integer[] exp0 = { 0, 1, 2, 3, 4, 5, 6, 7 };
        assertArrayEquals(exp0, dequeToArray(target0));
        // expand
        ArrayDeque<Integer> target1 = new ArrayDeque<Integer>();
        for (int i = 1; i < 1024; i *= 2) {
            target1.addLast(i);
        }
        Integer[] exp1 = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512 };
        assertArrayEquals(exp1, dequeToArray(target1));
        // shrink
        for (int i = 0; i < 4; i++) {
            target1.removeLast();
        }
        Integer[] exp2 = { 1, 2, 4, 8, 16, 32 };
        assertArrayEquals(exp2, dequeToArray(target1));
    }

    public static void main(String... args) {
        jh61b.junit.TestRunner.runTests("all", ArrayDequeTest.class);
    }
}
