public class IndexMinPQ<Key extends Comparable<Key>> extends IndexPQ<Key> {
    public IndexMinPQ(int maxN) { super(maxN); }
    public int delMin() { return delete(); }
    public Key minKey() { return topKey(); }
    public int minIndex() { return topIndex(); }

    boolean less(Key v, Key w) {
        return v.compareTo(w) > 0;
    }

    public static void main(String[] args) {
        IndexMinPQ<String> pq = new IndexMinPQ<>(7);
        pq.insert(1, "1");
        pq.insert(3, "3");
        pq.insert(5, "5");
        pq.insert(2, "2");
        pq.insert(4, "4");
        pq.insert(6, "6");
        pq.insert(0, "0");
        while (!pq.isEmpty()) {
            System.out.println(pq.delMin());
        }
    }
}
