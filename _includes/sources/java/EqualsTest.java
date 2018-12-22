public class EqualsTest {
    static class Entry<K, V> {
        public K key;
        public V val;

        public Entry() {}
        public Entry(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public String toString() {
            return "Entry{key=" + key + "," + "val=" + val + "}";
        }

        // SOLUTION_BEGIN
        public boolean equals(Object x) {
            if (this == x) return true;
            if (x == null) return false;
            if (this.getClass() != x.getClass()) return false;
            Entry that = (Entry) x;
            return this.key.equals(that.key) &&
                this.val.equals(that.val);
        }
        // SOLUTION_END
    }

    public static void main(String[] args) throws Throwable {
        Entry e1 = new Entry<>(1, "one");
        Entry e2 = new Entry<>(1, "one");
        Entry e3 = new Entry<>(2, "two");
        Assert.assertTrue(e1.equals(e1));
        Assert.assertFalse(e1.equals(null));
        Assert.assertFalse(e1.equals(new Pair<>(1, "one")));
        Assert.assertTrue(e1.equals(e2));
        Assert.assertFalse(e1.equals(e3));
        System.out.println("OK");
    }
}
