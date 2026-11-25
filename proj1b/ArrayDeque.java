public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        this.items = (T[]) new Object[8];
        this.size = 0;
        this.nextFirst = 3;
        this.nextLast = 4;
    }

    private void resize(int cap) {
        T[] a = (T[]) new Object[cap];
        System.arraycopy(this.toArray(), 0, a, 0, this.size);
        this.nextFirst = cap - 1;
        this.nextLast = this.size;
        this.items = a;
    }

    private void increaseSize() {
        this.size += 1;
        if (this.size == this.items.length) {
            resize(this.items.length * 2);
        }
    }

    private void decreaseSize() {
        this.size -= 1;
        if (this.size < this.items.length / 4) {
            resize(this.items.length / 2);
        }
    }

    @Override
    public void addFirst(T item) {
        this.items[nextFirst] = item;
        this.nextFirst = Math.floorMod(this.nextFirst - 1, this.items.length);
        this.increaseSize();
    }

    @Override
    public void addLast(T item) {
        this.items[nextLast] = item;
        this.nextLast = Math.floorMod(this.nextLast + 1, this.items.length);
        this.increaseSize();
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void printDeque() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.get(i));
            System.out.print(" ");
        }
    }

    @Override
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        } else {
            T result = this.items[Math.floorMod(this.nextFirst + 1, this.items.length)];
            this.nextFirst = Math.floorMod(this.nextFirst + 1, this.items.length);
            this.items[nextFirst] = null;
            this.decreaseSize();
            return result;
        }
    }

    @Override
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        } else {
            T result = this.items[Math.floorMod(this.nextLast - 1, this.items.length)];
            this.nextLast = Math.floorMod(this.nextLast - 1, this.items.length);
            this.items[nextLast] = null;
            this.decreaseSize();
            return result;
        }
    }

    @Override
    public T get(int index) {
        if (index > this.size) {
            return null;
        } else {
            return this.items[Math.floorMod(this.nextFirst + 1 + index, this.items.length)];
        }
    }

    private T[] toArray() {
        T[] result = (T[]) new Object[this.size];
        for (int i = 0; i < this.size; i++) {
            result[i] = this.get(i);
        }
        return result;
    }
}
