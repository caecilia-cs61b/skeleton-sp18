public class LinkedListDeque<T> {
    private class LinkNode {
        public T value;
        public LinkNode prev;
        public LinkNode next;

        public LinkNode(T v, LinkNode p, LinkNode n) {
            this.value = v;
            this.prev = p;
            this.next = n;
        }

        public LinkNode elemAt(int index) {
            assert index >= 0;
            if (index == 0) {
                return this;
            } else {
                return this.next.elemAt(index - 1);
            }
        }
    }

    private LinkNode sentinel;
    private int size;

    public LinkedListDeque() {
        this.sentinel = new LinkNode(null, null, null);
        this.sentinel.prev = this.sentinel;
        this.sentinel.next = this.sentinel;
        this.size = 0;
    }

    public LinkedListDeque(T item) {
        this.sentinel = new LinkNode(null, null, null);
        this.sentinel.next = new LinkNode(item, sentinel, sentinel);
        this.sentinel.prev = this.sentinel.next;
        this.size = 1;
    }

    public void addFirst(T item) {
        this.sentinel.next = new LinkNode(item, this.sentinel, this.sentinel.next);
        this.sentinel.next.next.prev = this.sentinel.next;
        this.size += 1;
    }

    public void addLast(T item) {
        this.sentinel.prev = new LinkNode(item, this.sentinel.prev, this.sentinel);
        this.sentinel.prev.prev.next = this.sentinel.prev;
        this.size += 1;
    }

    public boolean isEmpty() {
        return this.sentinel.next == this.sentinel;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        if (this.isEmpty()) {
            return;
        } else {
            LinkNode p = this.sentinel.next;
            while (p != this.sentinel) {
                System.out.print(p.value);
                System.out.print(" ");
            }
        }
    }

    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        } else {
            T valueOfFirst = this.sentinel.next.value;
            this.sentinel.next = this.sentinel.next.next;
            this.sentinel.next.prev = this.sentinel;
            this.size -= 1;
            return valueOfFirst;
        }
    }

    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        } else {
            T valueOfLast = this.sentinel.prev.value;
            this.sentinel.prev = this.sentinel.prev.prev;
            this.sentinel.prev.next = this.sentinel;
            this.size -= 1;
            return valueOfLast;
        }
    }

    public T get(int index) {
        if (index >= this.size) {
            return null;
        } else {
            LinkNode p = this.sentinel.next;
            for (int i = 0; i < index; i++) {
                p = p.next;
            }
            return p.value;
        }
    }

    public T getRecursive(int index) {
        if (index >= this.size) {
            return null;
        } else {
            return this.sentinel.next.elemAt(index).value;
        }
    }
}
